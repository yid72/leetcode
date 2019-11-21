package dyd.leetcode;

/**
 * 567. Permutation in String -- Medium
 *
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words,
 * one of the first string's permutations is the substring of the second string.
 *
 * Example 1:
 *
 * Input: s1 = "ab" s2 = "eidbaooo"
 * Output: True
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 *
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 *
 * Note:
 *
 * The input strings only contain lower case letters.
 * The length of both given strings is in range [1, 10,000].
 */
public class Q00567_PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() == 0 || s2.length() < s1.length()) {
            return false;
        }

        int[] counts1 = count(s1, 0, s1.length() - 1);
        int[] counts2 = count(s2, 0, s1.length() - 1);
        if (matches(counts1, counts2)) {
            return true;
        }

        for (int i = 1; i <= s2.length() - s1.length(); i++) {
            counts2[s2.charAt(i - 1) - 'a'] --;
            counts2[s2.charAt(i + s1.length() - 1) - 'a'] ++;
            if (matches(counts1, counts2)) {
                return true;
            }
        }

        return false;
    }

    private int[] count(String s, int begin, int end) {
        int[] counts = new int[26];
        for (int i = begin; i <= end; i++) {
            counts[s.charAt(i) - 'a'] ++;
        }
        return counts;
    }

    private boolean matches(int[] counts1, int[] counts2) {
        if (counts1.length != counts2.length) {
            return false;
        }

        for (int i = 0; i < counts1.length; i++) {
            if (counts1[i] != counts2[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
//        test("ab", "eidbaooo");
//        test("ab", "eidboaoo");
        test("adc", "dcda");
    }

    private static void test(String s1, String s2) {
        Q00567_PermutationInString q = new Q00567_PermutationInString();
        System.out.printf("s1=%s, s2=%s: %b\n", s1, s2, q.checkInclusion(s1, s2));
    }
}