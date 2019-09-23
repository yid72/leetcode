package dyd.leetcode.q236;

import java.util.ArrayList;
import java.util.List;

import dyd.leetcode.common.TreeNode;
import dyd.leetcode.common.TreeUtil;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 * Example 1:
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * Example 2:
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the
 * LCA definition.
 */
public class Q236_LCABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	List<TreeNode> path1 = findPathFromNode(root, p);
    	List<TreeNode> path2 = findPathFromNode(root, q);
    	
    	TreeNode lca = null;
    	for (int i = 0, j = 0; i < path1.size() && j < path2.size(); i ++, j++) {
    		if (path1.get(i) == path2.get(j)) {
    			lca = path1.get(i);
    		}
    		else {
    			break;
    		}
    	}
    	
    	return lca;
    }
    
    private List<TreeNode> findPathFromNode(TreeNode node, TreeNode p) {
    	List<TreeNode> path = new ArrayList<TreeNode>();
    	findPathFromNode(node, p, path);
    	return path;
    }
    
    private boolean findPathFromNode(TreeNode node, TreeNode p, List<TreeNode> path) {
    	if (node == null) {
    		return false;
    	}
    	else if (node == p) {
    		path.add(node);
    		return true;
    	}
    	
    	path.add(node);
    	if (findPathFromNode(node.left, p, path)) {
    		return true;
    	}
    	else if (findPathFromNode(node.right, p, path)) {
    		return true;
    	}
    	else {
    		path.remove(path.size()-1);
    		return false;
    	}
    }
    
    public static void main(String[] args) {
    	TreeNode[] nodes = new TreeNode[9];
    	for (int i = 0; i < nodes.length; i++) {
    		nodes[i] = new TreeNode(i);
    	}
    	
    	//
    	//            _________3_________
    	//           /                   \
    	//     ______5______            __1____
    	//    /             \          /       \
    	//    6           ___2___      0        8
    	//               /       \
    	//               7        4
    	//
    	TreeNode root = nodes[3];
    	root.left = nodes[5];
    	root.right = nodes[1];
    	nodes[5].left = nodes[6];
    	nodes[5].right = nodes[2];
    	nodes[2].left = nodes[7];
    	nodes[2].right = nodes[4];
    	nodes[1].left = nodes[0];
    	nodes[1].right = nodes[8];
    	
    	Q236_LCABinaryTree q = new Q236_LCABinaryTree();
    	
    	TreeNode lca = q.lowestCommonAncestor(root, nodes[6], nodes[7]);
    	System.out.print("The LCA of nodes 6 and 7 is: ");
    	TreeUtil.printTree(lca);
    	System.out.println();
    	
    	lca = q.lowestCommonAncestor(root, nodes[6], nodes[0]);
    	System.out.print("The LCA of nodes 6 and 0 is: ");
    	TreeUtil.printTree(lca);
    	System.out.println();
    	
    	lca = q.lowestCommonAncestor(root, nodes[1], nodes[3]);
    	System.out.print("The LCA of nodes 1 and 3 is: ");
    	TreeUtil.printTree(lca);
    	System.out.println();
    	
    	lca = q.lowestCommonAncestor(root, nodes[0], nodes[3]);
    	System.out.print("The LCA of nodes 0 and 3 is: ");
    	TreeUtil.printTree(lca);
    	System.out.println();    	
    }
}
