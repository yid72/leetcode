package dyd.leetcode.q020;

import java.util.Stack;

public class Q20_ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
        	char ch = s.charAt(i);
        	if (ch == '(' || ch == '[' || ch == '{') {
        		stack.push(ch);
        	}
        	else if (ch == ')') {
        		if (!checkMatch(stack, '(')) {
        			return false;
        		}
        	}
        	else if (ch == ']') {
        		if (!checkMatch(stack, '[')) {
        			return false;
        		}
        	}
        	else if (ch == '}') {
        		if (!checkMatch(stack, '{')) {
        			return false;
        		}        		
        	}
        	else {
        		throw new IllegalArgumentException("Invalid character " + ch);
        	}
        }
        
        return stack.isEmpty();
    }
    
    private boolean checkMatch(Stack<Character> stack, char stackCh) {
    	if (!stack.isEmpty() && stack.pop() == stackCh) {
    		return true;
    	}
    	return false;
    }
    
    public static void main(String[] args) {
    	Q20_ValidParentheses q = new Q20_ValidParentheses();
    	System.out.println(q.isValid("()[]{}"));
    	System.out.println(q.isValid("([)]"));
    }
}
