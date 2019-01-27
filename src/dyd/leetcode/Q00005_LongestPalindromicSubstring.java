package dyd.leetcode;

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
public class Q00005_LongestPalindromicSubstring {
	private int maxLength = 0;

    public String longestPalindrome(String s) {
    	if (s == null) {
    		return "";
    	}
    	
    	if (s.length() < 2) {
    		return s;
    	}

    	int[] indices = longestPalindrome(s.toCharArray(), 0, s.length() - 1);
    	return s.substring(indices[0], indices[1] + 1);
    }

    private int[] longestPalindrome(char[] str, int start, int end) {
    	System.out.println(new String(str, start, end-start+1));
    	
    	if (isPalinedrome(str, start, end)) {
    		maxLength = Math.max(maxLength, end - start + 1);
    		return new int[] {start, end};
    	}
    	
    	int[] indices1 = longestPalindrome(str, start, end - 1);
    	int[] indices2 = longestPalindrome(str, start + 1, end);
    	
    	return (indices1[1] - indices1[0] >= indices2[1] - indices2[0]) ? indices1 : indices2;
    }
    
    private boolean isPalinedrome(char[] str, int start, int end) {
    	while (start <= end) {
    		if (str[start] != str[end]) {
    			return false;
    		}
    		start ++;
    		end --;
    	}
    	return true;
    }
    
    public static void main(String[] args) {
//    	test("babad");
//    	test("cbbd");
    	test("babaddtattarrattatddetartrateedredividerb");
    }
    
    private static void test(String s) {
    	Q00005_LongestPalindromicSubstring q = new Q00005_LongestPalindromicSubstring();
    	System.out.printf("lps('%s') = %s\n", s, q.longestPalindrome(s));
    }
}
