package dyd.leetcode;

import java.util.HashMap;

/**
 * 
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

 * @author dyd
 *
 */
public class Q00003_LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
    	if (s == null || s.length() == 0) {
    		return 0;
    	}
    	
    	int maxLength = 0;
    	
    	HashMap<Character, Integer> indexMap = new HashMap<>();
    	
        for (int i = 0, j = 0; j < s.length(); j++)
        {
        	char ch = s.charAt(j);

        	if (indexMap.containsKey(s.charAt(j))) {
        		for (int k = i; k < indexMap.get(ch); k++) {
        			indexMap.remove(s.charAt(k));
        		}
        		
        		i = indexMap.get(ch) + 1;
        		indexMap.put(ch, j);
        	}
        	else {
        		indexMap.put(ch, j);
        		maxLength = Math.max(maxLength, j - i + 1);
        	}
        }
        
        return maxLength;
    }
    
    public static void main(String[] args) {
    	test("");
    	test("abcabcbb");
    	test("bbbbb");
    	test("pwwkew");    	
    	test("tmmzuxt");
    }
    
    private static void test(String s) {
    	Q00003_LongestSubstring q = new Q00003_LongestSubstring();
    	System.out.printf("ls('%s') = %d\n", s, q.lengthOfLongestSubstring(s));
    }
}
