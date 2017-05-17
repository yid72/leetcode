package dyd.leetcode.q151;

public class Q151_ReverseWordsInAString {
    public String reverseWords(String s) {
    	// Remove trailing spaces.
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
        	end --;
        }
        
        if (end < 0) {
        	return "";
        }
        
        // Remove leading spaces.
        int start = 0;
        while (start < end && s.charAt(start) == ' ') {
        	start ++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        int i = end;
        while (i >= start) {
        	if (s.charAt(i) == ' ') {
        		sb.append(s.substring(i+1, end + 1));
        		sb.append(' ');
        		
        		// Collapse multiple spaces.
            	while (i >= start && s.charAt(i) == ' ') {
            		i --;
            	}
            	
            	end = i;
        	}
        	else {
        		i --;
        	}
        }
        
       	sb.append(s.substring(start, end+1));
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
    	String test = "the sky is blue";
    	Q151_ReverseWordsInAString q = new Q151_ReverseWordsInAString();
    	System.out.println(q.reverseWords("the sky is blue"));
    	System.out.println(q.reverseWords(" 1"));
    	System.out.println(q.reverseWords("a  b"));
    	
    }
}
