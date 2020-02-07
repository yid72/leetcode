package dyd.leetcode;

import dyd.leetcode.common.TreeNode;

/**
 * 98. Validate Binary Search Tree -- Medium
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * Example 1:
 *
 *     2
 *    / \
 *   1   3
 *
 * Input: [2,1,3]
 * Output: true
 * Example 2:
 *
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 *
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 */
public class Q00098_ValidateBST {
    public boolean isValidBST(TreeNode root) {
    	return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private boolean isValidBST(TreeNode node, int min, int max) {
    	if (node == null) {
    		return true;
    	}
    	
    	if (node.val <= min || node.val >= max) {
    		return false;
    	}
    	
    	return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }
    
    public static void main(String[] args) {
    	Q00098_ValidateBST q = new Q00098_ValidateBST();
    	
    	TreeNode root = new TreeNode(2);
    	root.left = new TreeNode(1);
    	root.right = new TreeNode(3);
    	System.out.println(q.isValidBST(root));
    	
    	TreeNode root1 = new TreeNode(1);
    	root1.left = new TreeNode(2);
    	root1.right = new TreeNode(3);
    	System.out.println(q.isValidBST(root1));
    	
    	TreeNode root2 = new TreeNode(1);
    	root2.left = new TreeNode(1);
    	System.out.println(q.isValidBST(root2));
    }    
}
