package dyd.leetcode;

import dyd.leetcode.common.TreeNode;
import dyd.leetcode.common.TreeUtil;

/**
 * 543. Diameter of Binary Tree -- Easy
 *
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the
 * length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * Example:
 * Given a binary tree
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 *
 * Note: The length of path between two nodes is represented by the number of edges between them.
 *
 * Accepted
 * 180.4K
 * Submissions
 * 377K
 */
public class Q00543_DiameterOfBinaryTree {
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        getHeight(root);
        return diameter;
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = getHeight(node.left);
        int right = getHeight(node.right);
        int height = Math.max(left, right) + 1;
        diameter = Math.max(left + right, diameter);
        return height;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        test(root);
    }

    private static void test(TreeNode root) {
        TreeUtil.printTree(root);
        Q00543_DiameterOfBinaryTree q = new Q00543_DiameterOfBinaryTree();
        System.out.println("Diameter: " + q.diameterOfBinaryTree(root));
    }
}
