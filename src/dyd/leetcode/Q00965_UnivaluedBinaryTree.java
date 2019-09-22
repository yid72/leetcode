package dyd.leetcode;

import dyd.leetcode.common.PrintUtil;
import dyd.leetcode.common.TreeNode;
import dyd.leetcode.common.TreeUtil;

/**
 * A binary tree is univalued if every node in the tree has the same value.
 *
 * Return true if and only if the given tree is univalued.
 *
 * Example 1:
 *
 * Input: [1,1,1,1,1,null,1]
 * Output: true
 */
public class Q00965_UnivaluedBinaryTree {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isUnivalTree(root, root.val);
    }

    private boolean isUnivalTree(TreeNode node, int value) {
        if (node == null) {
            return true;
        }
        return node.val == value && isUnivalTree(node.left, value) && isUnivalTree(node.right, value);
    }

    private static void test(int[] tree) {
        Q00965_UnivaluedBinaryTree q = new Q00965_UnivaluedBinaryTree();
        TreeNode root = TreeUtil.createBinaryTree(tree);
        System.out.print("Input: ");
        PrintUtil.printArray(tree);
        System.out.println("Result: " + q.isUnivalTree(root));
    }

    public static void main(String[] args) {
        test(new int[] {1, 1, -1, 1, 1});
        test(new int[] {1, 1, -1, 2, 1});
        test(new int[] {});
    }
}
