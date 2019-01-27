package dyd.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 *
 * Input: "()"
 * Output: true
 * Example 2:
 *
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: "(]"
 * Output: false
 * Example 4:
 *
 * Input: "([)]"
 * Output: false
 * Example 5:
 *
 * Input: "{[]}"
 * Output: true
 */
public class Q00020_ValidParentheses {
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
    	Q00020_ValidParentheses q = new Q00020_ValidParentheses();
    	System.out.println(q.isValid("()[]{}"));
    	System.out.println(q.isValid("([)]"));
		System.out.println(q.isValid("]"));
		System.out.println(q.isValid(""));
    }
}
