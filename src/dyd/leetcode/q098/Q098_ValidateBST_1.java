package dyd.leetcode.q098;

import dyd.leetcode.common.TreeNode;

public class Q098_ValidateBST_1 {
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
    	Q098_ValidateBST_1 q = new Q098_ValidateBST_1();
    	
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
