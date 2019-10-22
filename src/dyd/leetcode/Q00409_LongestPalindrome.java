package dyd.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can
 * be built with those letters.
 *
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 *
 * Note:
 * Assume the length of given string will not exceed 1,010.
 *
 * Example:
 *
 * Input:
 * "abccccdd"
 *
 * Output:
 * 7
 *
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
public class Q00409_LongestPalindrome {
    public int longestPalindrome(String s) {
        Map<Character, Integer> counts = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            counts.put(ch, counts.getOrDefault(ch, 0) + 1);
        }
        int evenCounts = 0;
        int oddCounts = 0;
        for (Integer c : counts.values()) {
            if (c % 2 == 0) {
                evenCounts += c;
            } else {
                oddCounts ++;
                evenCounts += c - 1;
            }
        }
        return evenCounts + ((oddCounts > 0) ? 1 : 0);
    }

    public static void main(String[] args) {
        test("abccccdd");
        test("ccc");
    }

    private static void test(String s) {
        System.out.println("S: " + s);
        Q00409_LongestPalindrome q = new Q00409_LongestPalindrome();
        System.out.println("Output: " + q.longestPalindrome(s));
    }
}
