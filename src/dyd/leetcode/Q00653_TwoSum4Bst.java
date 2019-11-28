package dyd.leetcode;

import dyd.leetcode.common.TreeNode;
import dyd.leetcode.common.TreeUtil;

/**
 * 653. Two Sum IV - Input is a BST -- Easy
 *
 * Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their
 * sum is equal to the given target.
 *
 * Example 1:
 *
 * Input:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 9
 *
 * Output: True
 *
 *
 * Example 2:
 *
 * Input:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 28
 *
 * Output: False
 */
public class Q00653_TwoSum4Bst {
    private TreeNode root;

    public boolean findTarget(TreeNode root, int k) {
        this.root = root;
        return helper(root, k);
    }

    private boolean helper(TreeNode node, int k) {
        if (node == null) {
            return false;
        }

        int target = k - node.val;

        if (search(node, target)) {
            return true;
        }

        if (helper(node.left, k)) {
            return true;
        }

        if (helper(node.right, k)) {
            return true;
        }

        return false;

    }

    private boolean search(TreeNode curNode, int k) {
        TreeNode node = root;
        while (node != null) {
            if (node != curNode && node.val == k) {
                return true;
            } else if (node.val > k) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    private static void test1() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        test(root, 9);
    }

    private static void test2() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        test(root, 28);
    }

    private static void test3() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        test(root, 4);
    }

    private static void test4() {
        TreeNode root = new TreeNode(1);
        test(root, 2);
    }

    private static void test(TreeNode root, int k) {
        TreeUtil.printTree(root);
        System.out.println("k=" + k);
        Q00653_TwoSum4Bst q = new Q00653_TwoSum4Bst();
        System.out.println(q.findTarget(root, k));
    }
}
