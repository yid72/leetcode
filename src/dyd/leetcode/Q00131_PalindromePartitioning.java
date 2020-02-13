package dyd.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 131. Palindrome Partitioning -- Medium
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return all possible palindrome partitioning of s.
 *
 * Example:
 *
 * Input: "aab"
 * Output:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */
public class Q00131_PalindromePartitioning {
    private List<List<String>> res;
    private char[] chars;
    private int[][] dp;

    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        chars = s.toCharArray();

        dp = new int[s.length()][s.length()];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        helper(0, new LinkedList<>());
        return res;
    }

    private void helper(int start, LinkedList<String> curr) {
        if (start >= chars.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < chars.length; i++) {
            if (isPalindrome(start, i)) {
                curr.add(new String(chars, start, i - start + 1));
                helper(i + 1, curr);
                curr.removeLast();
            }
        }
    }

    private boolean isPalindrome(int start, int end) {
        if (start >= end) {
            return true;
        }

        if (dp[start][end] != -1) {
            return dp[start][end] == 1;
        }

        boolean isPalindrome = chars[start] == chars[end] && isPalindrome(start + 1, end - 1);
        dp[start][end] = isPalindrome ? 1 : 0;
        return isPalindrome;
    }

    public static void main(String[] s) {
        test("ab");
        test("aab");
        test("abaaba");
    }

    private static void test(String s) {
        System.out.println("s=" + s);
        Q00131_PalindromePartitioning q = new Q00131_PalindromePartitioning();
        System.out.println(q.partition(s));
    }
}
