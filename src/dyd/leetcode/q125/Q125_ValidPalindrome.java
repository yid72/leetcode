package dyd.leetcode.q125;

public class Q125_ValidPalindrome {
    public boolean isPalindrome(String s) {
    	if (s == null || s.isEmpty()) {
    		return true;
    	}
    	
    	int start = 0;
    	int end = s.length() - 1;
    	while (start < end) {
    		char a = s.charAt(start);
    		char b = s.charAt(end);
    		while (start < end && !Character.isLetterOrDigit(a)) {
    			start ++;
    			if (start < s.length()) {
    				a = s.charAt(start);
    			}
    		}
    		while (start < end  && !Character.isLetterOrDigit(b)) {
    			end --;
    			if (end >= 0) {
    				b = s.charAt(end);
    			}
    		}
    		
    		if (Character.toLowerCase(a) != Character.toLowerCase(b)) {
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
    	System.out.println(q.isPalindrome("a."));
    	System.out.println(q.isPalindrome("a.b,."));
    	System.out.println(q.isPalindrome("a a"));  	
    }
}
