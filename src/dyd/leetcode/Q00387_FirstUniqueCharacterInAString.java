package dyd.leetcode;

import java.util.HashMap;

public class Q00387_FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> counts = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            Integer count = counts.get(ch);
            if (count == null) {
                count = 0;
            }
            counts.put(ch, count + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (counts.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Q00387_FirstUniqueCharacterInAString q = new Q00387_FirstUniqueCharacterInAString();
        System.out.println(q.firstUniqChar("leetcode"));
        System.out.println(q.firstUniqChar("loveleetcode"));
    }
}
