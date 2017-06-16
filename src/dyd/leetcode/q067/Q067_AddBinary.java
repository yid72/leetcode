package dyd.leetcode.q067;

/**
 * 
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".

 * @author dyd
 *
 */
public class Q067_AddBinary {
    public String addBinary(String a, String b) {
    	int x = Integer.parseInt(a, 2);
    	int y = Integer.parseInt(b, 2);
    	return Integer.toBinaryString(x + y);
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 && j >= 0) {
        	i --;
        	j --;
        }
    }
    
    private String addBianry(String a, String b, int carry) {
    	int i = a.length() - 1;
    	int j = b.length() - 1;
    	while (i >= 0 && j >= 0) {
    		i --;
    		j --;
    	}
    }
}
