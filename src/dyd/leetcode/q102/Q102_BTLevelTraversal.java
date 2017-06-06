package dyd.leetcode.q102;

import dyd.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]

 * @author dyd
 *
 */
public class Q102_BTLevelTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> results = new ArrayList<List<Integer>>();
    	if (root == null) {
    		return results;
    	}
    	
        List<TreeNode> curLevelNodes = new ArrayList<TreeNode>();
        curLevelNodes.add(root);
        
        while (curLevelNodes.size() > 0) {	
        	List<Integer> curLevelValues = new ArrayList<Integer>();
        	results.add(curLevelValues);
        	
        	List<TreeNode> nextLevelNodes = new ArrayList<TreeNode>();
        	for(TreeNode node : curLevelNodes) {
        		curLevelValues.add(node.val);
        		
        		if (node.left != null) {
        			nextLevelNodes.add(node.left);
        		}
        		
        		if (node.right != null) {
        			nextLevelNodes.add(node.right);
        		}
        	}
        	
        	curLevelNodes = nextLevelNodes;
        }
        
        return results;
    }
    
    public static void main(String[] args) {
    	Q102_BTLevelTraversal q = new Q102_BTLevelTraversal();
    	
    	TreeNode root = new TreeNode(3);
    	root.left = new TreeNode(9);
    	root.right = new TreeNode(20);
    	root.right.left = new TreeNode(15);
    	root.right.right = new TreeNode(7);
    	
    	List<List<Integer>> results = q.levelOrder(root);
    	System.out.println("[");
    	for (List<Integer> level : results) {
    		System.out.print("[");
    		for (Integer val : level) {
    			System.out.print(val + " ");
    		}
    		System.out.println("]");
    	}
    	System.out.println("]");
    }
}
