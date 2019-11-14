package dyd.leetcode;

import dyd.leetcode.common.TreeNode;
import dyd.leetcode.common.TreeUtil;

/**
 * Given a binary tree, count the number of uni-value subtrees.
 *
 * A Uni-value subtree means all nodes of the subtree have the same value.
 *
 * Example :
 *
 * Input:  root = [5,1,5,5,5,null,5]
 *
 *               5
 *              / \
 *             1   5
 *            / \   \
 *           5   5   5
 *
 * Output: 4
 */
public class Q00250_CountUnivalueSubtrees {
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int count = countUnivalSubtrees(root.left) + countUnivalSubtrees(root.right);
        if (unival(root)) {
            count ++;
        }
        return count;
    }

    private boolean unival(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!unival(root.left) || !unival(root.right)) {
            return false;
        }

        if (root.left != null && root.left.val != root.val) {
            return false;
        }

        if (root.right != null && root.right.val != root.val) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    private static void test1() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(5);
        test(root);
    }

    private static void test2() {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(0);
        root.right.left.left = new TreeNode(1);
        root.right.left.right = new TreeNode(1);
        test(root);
    }

    private static void test3() {
        TreeNode root = null;
        test(root);
    }

    private static void test4() {
        TreeNode root = new TreeNode(1);
        test(root);
    }

    private static void test(TreeNode root) {
        TreeUtil.printTree(root);
        Q00250_CountUnivalueSubtrees q = new Q00250_CountUnivalueSubtrees();
        System.out.println("Number of Unival substrees: " + q.countUnivalSubtrees(root));
    }
}
