package dyd.leetcode.common;

import dyd.leetcode.Q00655_PrintBinaryTree;

import java.util.LinkedList;
import java.util.List;
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

	public static void printTree(TreeNode root) {
		Q00655_PrintBinaryTree printBinaryTree = new Q00655_PrintBinaryTree();
		List<List<String>> result = printBinaryTree.printTree(root);
		for (List<String> row : result) {
			for (String col : row) {
				System.out.printf("%3s ", col);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		TreeUtil.printTree(root);
	}
}
