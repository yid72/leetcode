package dyd.leetcode;

/**
 * Given a binary tree with n nodes, your task is to check if it's possible to partition the tree to two trees which have the equal sum of values after removing exactly one edge on the original tree.
 *
 * Example 1:
 * Input:
 *     5
 *    / \
 *   10 10
 *     /  \
 *    2   3
 *
 * Output: True
 * Explanation:
 *     5
 *    /
 *   10
 *
 * Sum: 15
 *
 *    10
 *   /  \
 *  2    3
 *
 * Sum: 15
 * Example 2:
 * Input:
 *     1
 *    / \
 *   2  10
 *     /  \
 *    2   20
 *
 * Output: False
 * Explanation: You can't split the tree into two trees with equal sum after removing exactly one edge on the tree.
 * Note:
 * The range of tree node value is in the range of [-100000, 100000].
 * 1 <= n <= 10000
 */

import dyd.leetcode.common.TreeNode;
import dyd.leetcode.common.TreeUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Q00663_EqualTreePartition {
    Map<TreeNode, Integer> subTreeValues = new HashMap<>();

    public boolean checkEqualTree(TreeNode root) {
        if (root == null) {
            return false;
        }

        subTreeValues.clear();
        computeSubTreeValues(root);

        return checkEqualTree(root, subTreeValues.get(root));
    }

    private int computeSubTreeValues(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int val = root.val + computeSubTreeValues(root.left) + computeSubTreeValues(root.right);
        subTreeValues.put(root, val);
        return val;
    }

    private boolean checkEqualTree(TreeNode node, int treeVal) {
        if (node.left == null && node.right == null) {
            return false;
        }

        if (node.left != null) {
            int leftSubTreeVal =  subTreeValues.get(node.left);
            if (leftSubTreeVal == treeVal - leftSubTreeVal) {
                return true;
            }
        }

        if (node.right != null) {
            int rightSubTreeVal = subTreeValues.get(node.right);
            if (rightSubTreeVal == treeVal - rightSubTreeVal) {
                return true;
            }
        }

        return (node.left != null && checkEqualTree(node.left, treeVal))
                || (node.right != null && checkEqualTree(node.right, treeVal));
    }

    public static void main(String[] args) {
        Q00663_EqualTreePartition q = new Q00663_EqualTreePartition();

//        TreeNode root1 = new TreeNode(5);
//        root1.left = new TreeNode(10);
//        root1.right = new TreeNode(10);
//        root1.right.left = new TreeNode(2);
//        root1.right.right = new TreeNode(3);
//        TreeUtil.printTree(root1);
//        System.out.println("Can be equally partitioned: " + q.checkEqualTree(root1));
//
//        TreeNode root2 = new TreeNode(1);
//        root2.left = new TreeNode(2);
//        root2.right = new TreeNode(10);
//        root2.right.left = new TreeNode(2);
//        root2.right.right = new TreeNode(20);
//        TreeUtil.printTree(root2);
//        System.out.println("Can be equally partitioned: " + q.checkEqualTree(root2));
//
//        TreeNode root3 = new TreeNode(0);
//        root3.left = new TreeNode(-1);
//        root3.right = new TreeNode(1);
//        TreeUtil.printTree(root3);
//        System.out.println("Can be equally partitioned: " + q.checkEqualTree(root3));
//
//        TreeNode root4 = new TreeNode(1);
//        root4.left = new TreeNode(1);
//        TreeUtil.printTree(root4);
//        System.out.println("Can be equally partitioned: " + q.checkEqualTree(root4));

        TreeNode root5 = new TreeNode(1);
        root5.left = new TreeNode(-1);
        TreeUtil.printTree(root5);
        System.out.println("Can be equally partitioned: " + q.checkEqualTree(root5));
    }
}
