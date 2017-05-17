package dyd.leetcode.q236;

import java.util.ArrayList;
import java.util.List;

import dyd.leetcode.common.PrintUtil;
import dyd.leetcode.common.TreeNode;

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
    	PrintUtil.printTreeNode(lca);
    	System.out.println();
    	
    	lca = q.lowestCommonAncestor(root, nodes[6], nodes[0]);
    	System.out.print("The LCA of nodes 6 and 0 is: ");
    	PrintUtil.printTreeNode(lca);
    	System.out.println();
    	
    	lca = q.lowestCommonAncestor(root, nodes[1], nodes[3]);
    	System.out.print("The LCA of nodes 1 and 3 is: ");
    	PrintUtil.printTreeNode(lca);    	
    	System.out.println();
    	
    	lca = q.lowestCommonAncestor(root, nodes[0], nodes[3]);
    	System.out.print("The LCA of nodes 0 and 3 is: ");
    	PrintUtil.printTreeNode(lca);    	
    	System.out.println();    	
    }
}
