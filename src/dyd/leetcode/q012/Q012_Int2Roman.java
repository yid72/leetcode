package dyd.leetcode.q012;

/**
 * 
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.

 * @author dyd
 *
 */
public class Q012_Int2Roman {
	private static String[] romanSymbols = {"M", "CM", "DCCC", "DCC", "DC", "D", 
				"CD", "CCC", "CC", "C", 
				"XC", "LXXX", "LXX", "LX", "L",
				"XL", "XXX", "XX", "X", 
				"IX", "VIII", "VII", "VI", "V",
				"IV", "III", "II", "I"};

	private static int[] decimals = {1000, 900, 800, 700, 600, 500, 
			400, 300, 200, 100, 
			90, 80, 70, 60, 50,
			40, 30, 20, 10,
			9, 8, 7, 6, 5,
			4, 3, 2, 1};
	
    public String intToRoman(int num) {
    	if (num <= 0) {
    		return "";
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	
        int i = 0;
        while (num > 0) {
        	if (num >= decimals[i]) {
        		sb.append(romanSymbols[i]);
        		num -= decimals[i];
        	}
        	else {
        		i ++;
        	}
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
    	test(1);
    	test(8);
    	test(16);
    	test(3000);
    	test(2999);
    }
    
    private static void test(int num) {
    	Q012_Int2Roman q = new Q012_Int2Roman();
    	System.out.printf("%d = %s\n", num, q.intToRoman(num));
    }
}
