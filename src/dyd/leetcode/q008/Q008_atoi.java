package dyd.leetcode.q008;

import java.math.BigInteger;

/**
 * 
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

 * @author dyd
 *
 */
public class Q008_atoi {
    public int myAtoi(String str) {
    	if (str == null || str.trim().length() == 0) {
    		return 0;
    	}
    	
    	int i = 0;
    	while (i < str.length() && Character.isWhitespace(str.charAt(i))) {
    		i ++;
    	}
    	
    	String sign = "";
    	if (i < str.length() && str.charAt(i) == '+' || str.charAt(i) == '-') {
    		sign += str.charAt(i++);
    	}
    	
    	StringBuffer sb = new StringBuffer();
    	
    	for (; i < str.length(); i++) {
    		char ch = str.charAt(i);
    		if (Character.isDigit(ch)) {
    			sb.append(ch);
    		}
    		else {
    			break;
    		}
    	}
    	
    	if (sb.length() == 0) {
    		return 0;
    	}
    	
    	String strInt = sign + sb.toString();
    	
    	BigInteger bigInt = new BigInteger(strInt);
    	if (bigInt.compareTo(new BigInteger("" + Integer.MAX_VALUE)) > 0) {
    		return Integer.MAX_VALUE;
    	}
    	else if (bigInt.compareTo(new BigInteger("" + Integer.MIN_VALUE)) < 0) {
    		return Integer.MIN_VALUE;
    	}
    	else {
    		return bigInt.intValue();
    	}
   }
    
    public static void main(String[] args) {
    	Q008_atoi q = new Q008_atoi();
    	System.out.printf("%s=%d\n", "", q.myAtoi(""));
    	System.out.printf("%s=%d\n", "1234a5", q.myAtoi("1234a5"));
    	System.out.printf("%s=%d\n", "-1234", q.myAtoi("-1234"));
    	System.out.printf("%s=%d\n", "12345678901234567890", q.myAtoi("12345678901234567890"));
    	
    }
}
