package dyd.leetcode;

import dyd.leetcode.common.TreeNode;
import dyd.leetcode.common.TreeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 *
 * Example 1:
 *
 * Input: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * Output: 1
 * Example 2:
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * Output: 3
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How
 * would you optimize the kthSmallest routine?
 */
public class Q00230_KthSmallestElementInBst {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> count = new ArrayList<>();
        count.add(0);
        return kthSmallest(root, k, count);
    }

    private int kthSmallest(TreeNode node, int k, List<Integer> count) {
        if (node.left != null) {
            int val = kthSmallest(node.left, k, count);
            if (val < Integer.MAX_VALUE) {
                return val;
            }
        }

        count.set(0, count.get(0) + 1);
        if (count.get(0) == k) {
            return node.val;
        }

        if (node.right != null) {
            int val = kthSmallest(node.right, k, count);
            if (val < Integer.MAX_VALUE) {
                return val;
            }
        }

        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        test(root, 1);

        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(6);
        root1.left.left = new TreeNode(2);
        root1.left.right = new TreeNode(4);
        root1.left.left.left = new TreeNode(1);
        test(root1, 3);
    }

    private static void test(TreeNode root, int k) {
        TreeUtil.printTree(root);
        System.out.println("k=" + k);
        Q00230_KthSmallestElementInBst q = new Q00230_KthSmallestElementInBst();
        System.out.println(q.kthSmallest(root, k));
    }
}
