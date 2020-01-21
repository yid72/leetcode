package dyd.leetcode;

import dyd.leetcode.common.TreeNode;
import dyd.leetcode.common.TreeUtil;

import java.util.Arrays;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal -- Medium
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class Q00105_ConstructBinaryTreeFromPreorderInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) {
            return null;
        }

        return helper(preorder, 0, inorder, 0, inorder.length);
    }

    private TreeNode helper(int[] preorder, int index, int[] inorder, int start, int end) {
        if (index >= preorder.length || start < 0 || end > inorder.length) {
            return null;
        }

        TreeNode root = null;
        for (int i = start; i < end; i++) {
            if (preorder[index] == inorder[i]) {
                root = new TreeNode(preorder[index]);
                root.left = helper(preorder, index + 1, inorder, start, i);
                root.right = helper(preorder, index + i - start + 1, inorder, i + 1, end);
                break;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        test(new int[] {3,9,20,15,7}, new int[] {9,3,15,20,7});
    }

    private static void test(int[] preorder, int[] inorder) {
        System.out.printf("preorder=%s\n", Arrays.toString(preorder));
        System.out.printf("inorder=%s\n", Arrays.toString(inorder));
        Q00105_ConstructBinaryTreeFromPreorderInorder q = new Q00105_ConstructBinaryTreeFromPreorderInorder();
        TreeUtil.printTree(q.buildTree(preorder, inorder));
    }
}
