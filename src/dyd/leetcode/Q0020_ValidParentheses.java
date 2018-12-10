package dyd.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Q0020_ValidParentheses {
	private static final List<Character> LEFT_PARENTHESIS = Arrays.asList('(', '[', '{');
	private static final List<Character> RIGHT_PARENTHESIS = Arrays.asList(')', ']', '}');

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
        	char ch = s.charAt(i);
        	if (LEFT_PARENTHESIS.contains(ch)) {
        		stack.push(ch);
        	}
        	else {
        		int rightIndex = RIGHT_PARENTHESIS.indexOf(ch);
        		if (rightIndex == -1) {
					throw new IllegalArgumentException("Invalid character " + ch);
				}
				char leftParenthesis = LEFT_PARENTHESIS.get(rightIndex);
        		if (stack.isEmpty() ||  stack.pop() != leftParenthesis) {
        			return false;
				}
			}
        }
        
        return stack.isEmpty();
    }
    
    public static void main(String[] args) {
    	Q0020_ValidParentheses q = new Q0020_ValidParentheses();
    	System.out.println(q.isValid("()[]{}"));
    	System.out.println(q.isValid("([)]"));
		System.out.println(q.isValid("]"));
		System.out.println(q.isValid(""));
    }
}
