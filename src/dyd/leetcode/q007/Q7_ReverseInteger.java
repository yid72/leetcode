package dyd.leetcode.q007;

public class Q7_ReverseInteger {
    public int reverse(int x) {
    	int sign = (x >= 0) ? 1 : -1;
    	long rem = Math.abs((long) x);
    	
        long ret = rem % 10;
        rem = rem / 10;
        while (rem > 0) {
            ret = 10*ret + rem % 10;
            rem = rem / 10;
        }
        
        ret *= sign;
        if (ret > Integer.MAX_VALUE || ret < Integer.MIN_VALUE) {
        	ret = 0;
        }
        
        return (int) ret;
    }
    
    public static void main(String args[]) {
    	Q7_ReverseInteger q = new Q7_ReverseInteger();
    	System.out.println(q.reverse(-2147483648));
    }
}
