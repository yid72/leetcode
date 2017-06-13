package dyd.leetcode.common;

import java.util.LinkedList;
import java.util.Queue;

public class TreeUtil {
	public static TreeNode createTree(int[] vals) {
		if (vals == null || vals.length == 0) {
			return null;
		}
		
		TreeNode head = new TreeNode(0);
		
		Queue<TreeNode> level = new LinkedList<TreeNode>();
		level.add(head);
		
		Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
		
		int i = 0;
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
				
		return head;
	}
}
