package dyd.leetcode.q009;

public class Q009_PalindromeNumber {
    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        
        int start = 0;
        if (start == '-') {
        	start ++;
        }
        
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
    	Q009_PalindromeNumber q = new Q009_PalindromeNumber();
    	
    	System.out.println(q.isPalindrome(-2147483648));
    }
}
