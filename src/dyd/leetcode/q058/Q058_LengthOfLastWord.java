package dyd.leetcode.q058;

/**
 * 
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.

 * @author dyd
 *
 */
public class Q058_LengthOfLastWord {
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
    	Q058_LengthOfLastWord q = new Q058_LengthOfLastWord();
    	
    	System.out.println(q.lengthOfLastWord("Hi World"));
    	System.out.println(q.lengthOfLastWord("World"));
    }
}
