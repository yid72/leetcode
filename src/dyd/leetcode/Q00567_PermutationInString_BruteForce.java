package dyd.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q00567_PermutationInString_BruteForce {
    public boolean checkInclusion(String s1, String s2) {
        List<String> perms = permutations(s1);
        for (String perm : perms) {
            if (s2.indexOf(perm) > -1) {
                return true;
            }
        }
        return false;
    }

    private List<String> permutations(String s) {
        List<String> perms = new ArrayList<>();
        List<StringBuilder> sbs = permutations(s, 0);
        for (StringBuilder sb : sbs) {
            perms.add(sb.toString());
        }
        return perms;
    }

    private List<StringBuilder> permutations(String s, int pos) {
        List<StringBuilder> perms = new ArrayList<>();
        if (pos == s.length() - 1) {
            perms.add(new StringBuilder().append(s.charAt(pos)));
            return perms;
        }

        char ch = s.charAt(pos);

        List<StringBuilder> subPerms = permutations(s, pos + 1);

        for (StringBuilder subPerm : subPerms) {
            for (int i = 0; i <= subPerm.length(); i++) {
                perms.add(new StringBuilder(subPerm).insert(i, ch));
            }
        }

        return perms;
    }

    public static void main(String[] args) {
        test("ab", "eidbaooo");
        test("ab", "eidboaoo");
    }

    private static void test(String s1, String s2) {
        Q00567_PermutationInString_BruteForce ps = new Q00567_PermutationInString_BruteForce();

        System.out.print("s1=" + s1 + ", s2=" + s2 + ": ");
        System.out.println(ps.checkInclusion(s1, s2));
    }
}
