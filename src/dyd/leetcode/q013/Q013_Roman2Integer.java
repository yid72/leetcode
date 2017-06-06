package dyd.leetcode.q013;

import java.util.HashMap;

/**
 *
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.

 * @author dyd
 *
 */
public class Q013_Roman2Integer {
	private static HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	static {
		map.put('M', 1000);
		map.put('D', 500);
		map.put('C', 100);
		map.put('L', 50);
		map.put('X', 10);
		map.put('V', 5);
		map.put('I', 1);
	}
	
    public int romanToInt(String s) {
    	if (s == null || s.length() == 0) {
    		return 0;
    	}
    	
    	int sum = 0;
    	int prevValue = 4000;
        for (int i = 0; i < s.length(); i++) {
        	int curValue = map.get(s.charAt(i));
        	if (curValue <= prevValue) {
        		sum += curValue;
        	}
        	else {
        		sum += (curValue - 2*prevValue);
        	}
        	prevValue = curValue;
        }
        return sum;
    }
    
    private static void test(String s) {
    	Q013_Roman2Integer q = new Q013_Roman2Integer();
    	System.out.printf("%s = %d\n", s, q.romanToInt(s));
    }
    
    public static void main(String[] args) {
    	test("");
    	test("I");
    	test("IV");
    	test("VIII");
    	test("XII");
    	test("IX");
    	test("MCDXIII");
    }
}
