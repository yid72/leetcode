package dyd.leetcode.q017;

import java.util.ArrayList;
import java.util.List;

/**
 *
given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

 * @author dyd
 *
 */
public class Q017_LetterCombinationOfPhoneNumber {
	private static String[] map = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	
    public List<String> letterCombinations(String digits) {
    	List<String> result = new ArrayList<String>();
    	letterCombinations(result, "", digits);
    	return result;
    }
    
    private void letterCombinations(List<String> result, String prefix, String digits) {
    	if (digits.length() == 0) {
    		if (prefix.length() > 0) {
    			result.add(prefix);
    		}
    		return;
    	}
    	
		int d = Character.getNumericValue(digits.charAt(0));
		for (int j = 0; j < map[d].length(); j++) {
			letterCombinations(result, prefix + map[d].charAt(j), digits.substring(1));
		}
    }
    
    public static void main(String[] args) {
    	Q017_LetterCombinationOfPhoneNumber q = new Q017_LetterCombinationOfPhoneNumber();
    	List<String> result = q.letterCombinations("23");
    	System.out.println(result);
    }
}
