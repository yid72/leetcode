package dyd.leetcode.q104;

import dyd.leetcode.common.PrintUtil;
import dyd.leetcode.common.TreeNode;

/**

Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6

 * @author dyd
 *
 */
public class Q104_FlattenBTToLinkedList {
    public void flatten(TreeNode root) {
    	if (root == null) {
    		return;
    	}
    	
   		flatten(root.left);
   		flatten(root.right);
    	
    	TreeNode temp = root.right;
    	root.right = root.left;
    	root.left = null;
    	
    	TreeNode cur = root;
    	while (cur.right != null) {
    		cur = cur.right;
    	}
    	
    	cur.right = temp;
    }
    
    public static void main(String[] args) {
    	Q104_FlattenBTToLinkedList q = new Q104_FlattenBTToLinkedList();
    	
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(2);
    	root.right = new TreeNode(5);
    	root.left.left = new TreeNode(3);
    	root.left.right = new TreeNode(4);
    	root.right.left = new TreeNode(6);
    	
    	q.flatten(root);
    	PrintUtil.printTreeNode(root);
    }
}
