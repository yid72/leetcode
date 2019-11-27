package dyd.leetcode;

import dyd.leetcode.common.TreeNode;
import dyd.leetcode.common.TreeUtil;

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree -- Easy
 *
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 * Example 1:
 *
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 * Example 2:
 *
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * Output: 2
 * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 *
 *
 * Note:
 *
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the BST.
 */
public class Q00235_LCAOfABst {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val == q.val) {
            return p;
        }

        TreeNode ret = root;

        TreeNode node = root;
        while (node != null) {
            if (p.val < node.val && q.val < node.val) {
                ret = node;
                node = node.left;
            } else if (p.val > node.val && q.val > node.val) {
                ret = node;
                node = node.right;
            } else {
                return node;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(8);
        test(root, p, q);

        p = new TreeNode(2);
        q = new TreeNode(4);
        test(root, p, q);
    }

    private static void test(TreeNode root, TreeNode p, TreeNode q) {
        TreeUtil.printTree(root);
        Q00235_LCAOfABst problem = new Q00235_LCAOfABst();
        System.out.printf("p=%d, q=%d, LCA=%d\n", p.val, q.val, problem.lowestCommonAncestor(root, p, q).val);
    }
}
