package dyd.leetcode.q155;

import java.util.Stack;

public class MinStack {
	class MinStackNode {
		int min;
		int val;
	}
	
	private Stack<MinStackNode> stack;
	
    public MinStack() {
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
}
