package dyd.leetcode;

import dyd.leetcode.common.TreeNode;

/**
 * 110. Balanced Binary Tree -- Easy
 *
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 *
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 *
 *
 *
 * Example 1:
 *
 * Given the following tree [3,9,20,null,null,15,7]:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Return true.
 *
 * Example 2:
 *
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * Return false.
 *
 */
public class Q00110_BalancedBT {
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
    	Q00110_BalancedBT bt = new Q00110_BalancedBT();
    	
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(2);
    	root.right = new TreeNode(3);
    	root.left.left = new TreeNode(4);
    	
    	System.out.println(bt.isBalanced(root));
    	
    	root.left.left.left = new TreeNode(5);
    	System.out.println(bt.isBalanced(root));
    }
}
