package dyd.leetcode;

import dyd.leetcode.common.TreeNode;
import dyd.leetcode.common.TreeUtil;

/**
 * 333. Largest BST Subtree -- Medium
 *
 * Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.
 *
 * Note:
 * A subtree must include all of its descendants.
 *
 * Example:
 *
 * Input: [10,5,15,1,8,null,7]
 *
 *    10
 *    / \
 *   5  15
 *  / \   \
 * 1   8   7
 *
 * Output: 3
 * Explanation: The Largest BST Subtree in this case is the highlighted one.
 *              The return value is the subtree's size, which is 3.
 * Follow up:
 * Can you figure out ways to solve it with O(n) time complexity?
 */
public class Q00333_LargestBSTSubTree {
    class Status {
        boolean isBst;
        int min;
        int max;
        int size;

        public Status(boolean isBst) {
            this.isBst = isBst;
        }

        public Status(boolean isBst, int min, int max, int size) {
            this.isBst = isBst;
            this.min = min;
            this.max = max;
            this.size = size;
        }
    }

    private int maxSize = 0;

    public int largestBSTSubtree(TreeNode root) {
        helper(root);
        return maxSize;
    }

    private Status helper(TreeNode node) {
        if (node == null) {
            return new Status(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        Status left = helper(node.left);
        Status right = helper(node.right);

        if (!left.isBst || !right.isBst) {
            return new Status(false);
        }

        if (node.val > left.max && node.val < right.min) {
            int size = left.size + right.size + 1;
            maxSize = Math.max(size, maxSize);
            return new Status(true, Math.min(left.min, node.val), Math.max(right.max, node.val), size);
        }

        return new Status(false);
    }

    public static void main(String[] args) {
        test(new Integer[] {10,5,15,1,8,null,7});
        test(new Integer[] {1,2});
    }

    private static void test(Integer[] tree) {
        TreeNode root = TreeUtil.createBinaryTree(tree);
        TreeUtil.printTree(root);
        Q00333_LargestBSTSubTree q = new Q00333_LargestBSTSubTree();
        System.out.println(q.largestBSTSubtree(root));
    }
}
