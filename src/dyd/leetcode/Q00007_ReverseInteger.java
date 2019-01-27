package dyd.leetcode;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 * Input: 123
 * Output: 321
 *
 * Example 2:
 * Input: -123
 * Output: -321
 *
 * Example 3:
 * Input: 120
 * Output: 21
 *
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer
 * range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the
 * reversed integer overflows.
 */
public class Q00007_ReverseInteger {
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
    	Q00007_ReverseInteger q = new Q00007_ReverseInteger();
    	System.out.println(q.reverse(-2147483648));
    }
}
