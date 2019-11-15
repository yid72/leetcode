package dyd.leetcode;

import java.util.Arrays;

/**
 *
 * 5. Longest Palindromic Substring
 *
 * Medium
 *
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 *
 * Example:
 * Input: "cbbd"
 * Output: "bb"
 *
 */
public class Q00005_LongestPalindromicSubstring {
	private int[][] dp;

    public String longestPalindrome(String s) {
    	if (s == null) {
    		return "";
    	}
    	
    	if (s.length() < 2) {
    		return s;
    	}

    	dp = new int[s.length()][s.length()];
    	for (int i = 0; i < s.length(); i++) {
			Arrays.fill(dp[i], -1);
		}

    	int maxLen = 0;
    	int start = -1;
    	int end = -1;
    	for (int i = 1; i < s.length(); i++) {
    		for (int j = 0; j < i; j ++) {
    			if (isPalindrome(s, j, i) && i - j + 1 > maxLen) {
    				maxLen = i - j + 1;
    				start = j;
    				end = i;
				}
			}
		}

    	if (maxLen > 0) {
    		return s.substring(start, end + 1);
		} else {
    		return s.substring(0, 1);
		}
    }

    private boolean isPalindrome(String str, int start, int end) {
    	if (dp[start][end] != -1) {
    		return dp[start][end] == 1;
		}

    	if (str.charAt(start) != str.charAt(end)) {
			dp[start][end] = 0;
    		return false;
		}

    	if (end - start <= 1) {
			dp[start][end] = 1;
    		return true;
		}

    	boolean isPalindrome = isPalindrome(str, start + 1, end - 1);
    	dp[start][end] = isPalindrome ? 1 : 0;
    	return isPalindrome;
    }
    
    public static void main(String[] args) {
    	test("a");
		test("ab");
    	test("babad");
    	test("cbbd");
    	test("babaddtattarrattatddetartrateedredividerb");
    }
    
    private static void test(String s) {
    	Q00005_LongestPalindromicSubstring q = new Q00005_LongestPalindromicSubstring();
    	System.out.printf("lps('%s') = %s\n", s, q.longestPalindrome(s));
    }
}
