package dyd.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, determine if a permutation of the string could form a palindrome.
 *
 * Example 1:
 *
 * Input: "code"
 * Output: false
 * Example 2:
 *
 * Input: "aab"
 * Output: true
 * Example 3:
 *
 * Input: "carerac"
 * Output: true
 */
public class Q00266_PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> chCounts = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (chCounts.containsKey(ch)) {
                chCounts.put(ch, chCounts.get(ch) + 1);
            } else {
                chCounts.put(ch, 1);
            }
        }
        int oddCount = 0;
        for (Integer count : chCounts.values()) {
            if (count % 2 == 1) {
                if (++ oddCount > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        test("code");
        test("aab");
        test("carerac");
    }

    private static void test(String s) {
        Q00266_PalindromePermutation q = new Q00266_PalindromePermutation();
        System.out.println(s + ": " + q.canPermutePalindrome(s));
    }
}
