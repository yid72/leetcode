package dyd.leetcode.q066;

public class Q066_PlusOne {
    public int[] plusOne(int[] digits) {
    	for (int i = digits.length - 1; i >= 0; i--) {
    		if (digits[i] < 9) {
    			digits[i] ++;
    			return digits;
    		}
    		digits[i] = 0;
    	}
    	int[] newDigits = new int[digits.length + 1];
    	System.arraycopy(digits, 0, newDigits, 0, digits.length);
    	newDigits[0] = 1;
    	return newDigits;
    }
}
