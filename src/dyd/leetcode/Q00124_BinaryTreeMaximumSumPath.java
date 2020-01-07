package dyd.leetcode;

import dyd.leetcode.common.TreeNode;
import dyd.leetcode.common.TreeUtil;

/**
 * 124. Binary Tree Maximum Path Sum -- Hard
 *
 * Given a non-empty binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along
 * the parent-child connections. The path must contain at least one node and does not need to go through the root.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * Output: 6
 * Example 2:
 *
 * Input: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * Output: 42
 */
public class Q00124_BinaryTreeMaximumSumPath {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }

    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftChild = helper(node.left);
        int rightChild = helper(node.right);

        maxSum = Math.max(maxSum, node.val + Math.max(Math.max(Math.max(leftChild, rightChild), leftChild + rightChild), 0));
        return node.val + Math.max(Math.max(leftChild, rightChild), 0);
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    private static void test1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        test(root);
    }

    private static void test2() {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        test(root);
    }

    private static void test3() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(-1);
        test(root);
    }

    private static void test4() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(3);
        test(root);
    }

    private static void test5() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.right = new TreeNode(1);
        test(root);
    }

    private static void test(TreeNode root) {
        TreeUtil.printTree(root);
        Q00124_BinaryTreeMaximumSumPath q = new Q00124_BinaryTreeMaximumSumPath();
        System.out.println("max path sum: " + q.maxPathSum(root));
    }
}
