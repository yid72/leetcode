package dyd.leetcode.q028;

/**
 * 
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 * @author dyd
 *
 */
public class Q028_StrStr {
    public int strStr(String haystack, String needle) {
    	if (needle.length() == 0) {
    		return 0;
    	}
    	
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
        	int j = 0;
        	for (; j < needle.length(); j++) {
        		if (haystack.charAt(i + j) != needle.charAt(j)) {
        			break;
        		}
        	}
        	if (j == needle.length()) {
        		return i;
        	}
        }
        return -1;
    }
    
    public static void main(String[] args) {
    	Q028_StrStr q = new Q028_StrStr();
    	System.out.println(q.strStr("hello world", "ll"));
    	System.out.println(q.strStr("hello world", "or"));
    	System.out.println(q.strStr("hello world", "ler"));    	
    	System.out.println(q.strStr("a", "a"));    	
    }
}
