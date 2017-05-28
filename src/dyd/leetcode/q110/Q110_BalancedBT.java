package dyd.leetcode.q110;

import dyd.leetcode.common.TreeNode;

/**
 * 
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

 * @author dyd
 *
 */
public class Q110_BalancedBT {
    public boolean isBalanced(TreeNode root) {
    	if (root == null) {
    		return true;
    	}
    	
        return (Math.abs(height(root.left) - height(root.right)) <= 1) && 
        		isBalanced(root.left) &&
        		isBalanced(root.right);
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
