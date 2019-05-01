package dyd.leetcode;

import dyd.leetcode.common.TreeNode;

/**
 * 108. Convert Sorted Array to Binary Search Tree
 *
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees
 * of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted array: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class Q00108_ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start == end) {
            return new TreeNode(nums[start]);
        }

        int middle = (end + start) / 2;
        TreeNode root = new TreeNode(nums[middle]);
        if (middle > start) {
            root.left = sortedArrayToBST(nums, start, middle - 1);
        }
        if (middle < end) {
            root.right = sortedArrayToBST(nums, middle + 1, end);
        }
        return root;
    }

    public static void main(String[] args) {
        Q00108_ConvertSortedArrayToBST q = new Q00108_ConvertSortedArrayToBST();
        int[] nums = new int[] {-10,-3,0,5,9};
        TreeNode root = q.sortedArrayToBST(nums);
        System.out.print(root.val);
    }
}
