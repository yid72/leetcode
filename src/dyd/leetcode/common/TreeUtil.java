package dyd.leetcode.common;

import java.util.LinkedList;
import java.util.Queue;

public class TreeUtil {
	/**
	 * Create a tree from an integer array. The array is a complete binary tree. 
	 * A value of -1 means the node is null. e.g.,
	 * 
	 * [1, 2, 3, 4]
	 * 
	 *      1
	 *     /  \
	 *    2    3
	 *   /
	 *  4
	 *  
	 *  [1, 2, 3, -1, 4]
	 *  
	 *  	1
	 *     / \
	 *    2   3
	 *     \
	 *      4
	 * 
	 * @param vals	a complete binary tree
	 * @return
	 */
	public static TreeNode createBinaryTree(int[] vals) {
		if (vals == null || vals.length == 0) {
			return null;
		}
		
		TreeNode root = new TreeNode(vals[0]);
		
		Queue<TreeNode> level = new LinkedList<TreeNode>();
		level.add(root);
		
		Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
		
		int i = 1;
		while (level.size() > 0 && i < vals.length) {
			while (level.size() > 0 && i < vals.length) {
				TreeNode parent = level.poll();
				if (vals[i] != -1) {
					parent.left = new TreeNode(vals[i]);
					nextLevel.add(parent.left);
				}
				i ++;
				
				if (i < vals.length && vals[i] != -1) {
					parent.right = new TreeNode(vals[i]);
					nextLevel.add(parent.right);
				}
				i ++;
			}
			
			level = nextLevel;
		}
				
		return root;
	}
}
