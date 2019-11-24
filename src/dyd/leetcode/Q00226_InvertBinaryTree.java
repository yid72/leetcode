package dyd.leetcode;

import dyd.leetcode.common.TreeNode;
import dyd.leetcode.common.TreeUtil;

/**
 * 226. Invert a binary tree. -- Easy
 *
 * Example:
 *
 * Input:
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * Output:
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * Trivia:
 * This problem was inspired by this original tweet by Max Howell:
 *
 * Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a
 * whiteboard so f*** off.
 */
public class Q00226_InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode temp = invertTree(root.right);
            root.right = invertTree(root.left);
            root.left = temp;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        test(root);
    }

    private static void test(TreeNode root) {
        TreeUtil.printTree(root);
        Q00226_InvertBinaryTree q = new Q00226_InvertBinaryTree();
        TreeUtil.printTree(q.invertTree(root));
    }
}
