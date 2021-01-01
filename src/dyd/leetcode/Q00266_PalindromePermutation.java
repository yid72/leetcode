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
        Map<Character, Integer> charCounts = new HashMap<>();
        int oddCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int count = charCounts.getOrDefault(ch, 0) + 1;
            charCounts.put(ch, count);
            if (count % 2 == 0) {
                oddCount --;
            } else {
                oddCount ++;
            }
        }
        return oddCount <= 1;
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
