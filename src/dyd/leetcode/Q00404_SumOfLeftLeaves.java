package dyd.leetcode;

import dyd.leetcode.common.TreeNode;

/**
 * Find the sum of all left leaves in a given binary tree.
 *
 * Example:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */
public class Q00404_SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root, false);
    }

    private int sumOfLeftLeaves(TreeNode node, boolean isLeft) {
        if (node == null) {
            return 0;
        }

        if (isLeft && node.left == null && node.right == null) {
            return node.val;
        }

        return sumOfLeftLeaves(node.left, true) + sumOfLeftLeaves(node.right, false);
    }

    public static void main(String[] args) {
        Q00404_SumOfLeftLeaves q = new Q00404_SumOfLeftLeaves();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(q.sumOfLeftLeaves(root));

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);
        System.out.println(q.sumOfLeftLeaves(root2));
    }
}
