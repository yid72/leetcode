package dyd.leetcode.q110;

import dyd.leetcode.TreeNode;

public class Q110_BalancedBT {
    public boolean isBalanced(TreeNode root) {
    	if (root == null) {
    		return true;
    	}
    	
        return (isBalanced(root.left) &&
        		isBalanced(root.right) &&
        		Math.abs(height(root.left) - height(root.right)) <= 1);
    }
    
    private int height(TreeNode root) {
    	if (root == null) {
    		return 0;
    	}
    	else {
    		return Math.max(height(root.left), height(root.right)) + 1;
    	}
    }
    
    public static void main(String[] args) {
    	Q110_BalancedBT bt = new Q110_BalancedBT();
    	
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(2);
    	root.right = new TreeNode(3);
    	root.left.left = new TreeNode(4);
    	
    	System.out.println(bt.isBalanced(root));
    	
    	root.left.left.left = new TreeNode(5);
    	System.out.println(bt.isBalanced(root));
    }
}
