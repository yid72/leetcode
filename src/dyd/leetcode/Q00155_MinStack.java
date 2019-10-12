package dyd.leetcode;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 *
 * Example:
 *
 * Q00155_MinStack minStack = new Q00155_MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 */
public class Q00155_MinStack {
	class MinStackNode {
		int min;
		int val;
	}
	
	private Stack<MinStackNode> stack;
	
    public Q00155_MinStack() {
        this.stack = new Stack<MinStackNode>();
    }
    
    public void push(int x) {
    	MinStackNode node = new MinStackNode();
    	node.val = x;
    	node.min = x;
    	if (this.stack.size() > 0) {
    		node.min = Math.min(x, this.stack.peek().min);
    	}
    	this.stack.push(node);
    }
    
    public void pop() {
        this.stack.pop();
    }
    
    public int top() {
        return this.stack.peek().val;
    }
    
    public int getMin() {
        return this.stack.peek().min;
    }

    public static void main(String[] args) {
        Q00155_MinStack minStack = new Q00155_MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
