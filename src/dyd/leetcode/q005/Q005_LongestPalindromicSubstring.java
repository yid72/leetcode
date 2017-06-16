package dyd.leetcode.q005;

/**
 * 
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.
Example:

Input: "cbbd"

Output: "bb"

 * @author dyd
 *
 */
public class Q005_LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
    	if (s == null) {
    		return "";
    	}
    	
    	if (s.length() < 2) {
    		return s;
    	}
    	
        return longestPalindrome(s, 0, s.length() - 1);
    }
    
    private String longestPalindrome(String s, int start, int end) {
    	if (isPalinedrome(s, start, end)) {
    		return s.substring(start, end + 1);
    	}
    	
    	String s1 = longestPalindrome(s, start, end - 1);
    	String s2 = longestPalindrome(s, start + 1, end);
    	
    	return (s1.length() >= s2.length()) ? s1 : s2;
    }
    
    private boolean isPalinedrome(String s, int start, int end) {
    	while (start <= end) {
    		if (s.charAt(start) != s.charAt(end)) {
    			return false;
    		}
    		start ++;
    		end --;
    	}
    	return true;
    }
    
    public static void main(String[] args) {
    	test("babad");
    	test("cbbd");
    }
    
    private static void test(String s) {
    	Q005_LongestPalindromicSubstring q = new Q005_LongestPalindromicSubstring();
    	System.out.printf("lps('%s') = %s\n", s, q.longestPalindrome(s));
    }
}
