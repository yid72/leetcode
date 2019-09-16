package dyd.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.
 *
 * Examples:
 * Input: S = "a1b2"
 * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 *
 * Input: S = "3z4"
 * Output: ["3z4", "3Z4"]
 *
 * Input: S = "12345"
 * Output: ["12345"]
 */
public class Q00784_LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        if (S.length() == 0) {
            return new ArrayList<>();
        }

        List<StringBuilder> perms = letterCasePermutation(S, 0);
        return perms.stream().map(StringBuilder::toString).collect(Collectors.toList());
    }

    private List<StringBuilder> letterCasePermutation(String s, int pos) {
        List<StringBuilder> perms = new ArrayList<>();

        char ch = s.charAt(pos);
        if (pos >= s.length() - 1) {
            if (Character.isLetter(ch)) {
                perms.add(new StringBuilder().append(Character.toUpperCase(ch)));
                perms.add(new StringBuilder().append(Character.toLowerCase(ch)));
            } else {
                perms.add(new StringBuilder().append(ch));
            }
            return perms;
        }

        List<StringBuilder> subPerms = letterCasePermutation(s, pos + 1);
        for (StringBuilder subPerm : subPerms) {
            if (Character.isLetter(ch)) {
                perms.add(new StringBuilder(subPerm).insert(0, Character.toUpperCase(ch)));
                perms.add(subPerm.insert(0, Character.toLowerCase(ch)));
            } else {
                perms.add(subPerm.insert(0, ch));
            }
        }

        return perms;
    }

    public static void main(String[] args) {
        test("");
        test("a1b2");
        test("3z4");
        test("12345");
    }

    private static void test(String s) {
        Q00784_LetterCasePermutation q = new Q00784_LetterCasePermutation();
        System.out.println("Input=" + s);
        System.out.println(q.letterCasePermutation(s));
    }
}
