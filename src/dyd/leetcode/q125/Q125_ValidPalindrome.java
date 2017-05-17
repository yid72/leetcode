package dyd.leetcode.q125;

public class Q125_ValidPalindrome {
    public boolean isPalindrome(String s) {
    	if (s == null) {
    		throw new NullPointerException("The string is null");
    	}
    	
    	int start = 0;
    	int end = s.length() - 1;
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
    	Q125_ValidPalindrome q = new Q125_ValidPalindrome();
    	System.out.println(q.isPalindrome("abccba"));
    }
}
