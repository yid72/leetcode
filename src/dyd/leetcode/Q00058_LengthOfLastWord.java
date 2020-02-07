package dyd.leetcode;

/**
 * 58. Length of Last Word -- Easy
 *
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word (last word means the last appearing word if we loop from left to right) in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a maximal substring consisting of non-space characters only.
 *
 * Example:
 *
 * Input: "Hello World"
 * Output: 5
 *
 */
public class Q00058_LengthOfLastWord {
    public int lengthOfLastWord(String s) {
    	int i = s.length() - 1;
    	while (i >= 0 && s.charAt(i) == ' ') {
    		i --;
    	}
    	
    	if (i < 0) {
    		return 0;
    	}
    	
    	int end = i;
    	while (i >= 0 && Character.isLetter(s.charAt(i))) {
    		i --;
    	}

    	return end - i;
    }
    
    public static void main(String[] args) {
    	Q00058_LengthOfLastWord q = new Q00058_LengthOfLastWord();
    	
    	System.out.println(q.lengthOfLastWord("Hi World"));
    	System.out.println(q.lengthOfLastWord("World"));
    }
}
