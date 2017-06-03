package dyd.leetcode.q098;

import dyd.leetcode.common.TreeNode;

/**
 * 
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:
    2
   / \
  1   3
Binary tree [2,1,3], return true.
Example 2:
    1
   / \
  2   3
Binary tree [1,2,3], return false.

 * @author dyd
 *
 */
public class Q098_ValidateBST {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
        	return true;
        }
        
        if (root.left == null && root.right == null) {
        	return true;
        }
        
        if (root.left != null) {
        	if (!isValidBST(root.left) || getMaxValue(root.left) >= root.val) {
        		return false;
        	}
        }
        
        if (root.right != null) {
        	if (!isValidBST(root.right) || getMinValue(root.right) <= root.val) {
        		return false;
        	}       	
        }
        
        return true;
    }
    
    private int getMaxValue(TreeNode node) {
    	TreeNode curNode = node;
    	while (curNode.right != null) {
    		curNode = curNode.right;
    	}
    	return curNode.val;
    }
    
    private int getMinValue(TreeNode node) {
    	TreeNode curNode = node;
    	while (curNode.left != null) {
    		curNode = curNode.left;
    	}
    	return curNode.val;
    }
    
    public static void main(String[] args) {
    	Q098_ValidateBST q = new Q098_ValidateBST();
    	
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
