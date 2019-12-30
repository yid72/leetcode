package dyd.leetcode;

import dyd.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1305. All Elements in Two Binary Search Trees -- Medium
 *
 * Given two binary search trees root1 and root2.
 *
 * Return a list containing all the integers from both trees sorted in ascending order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root1 = [2,1,4], root2 = [1,0,3]
 * Output: [0,1,1,2,3,4]
 * Example 2:
 *
 * Input: root1 = [0,-10,10], root2 = [5,1,7,0,2]
 * Output: [-10,0,0,1,2,5,7,10]
 * Example 3:
 *
 * Input: root1 = [], root2 = [5,1,7,0,2]
 * Output: [0,1,2,5,7]
 * Example 4:
 *
 * Input: root1 = [0,-10,10], root2 = []
 * Output: [-10,0,10]
 * Example 5:
 *
 *
 * Input: root1 = [1,null,8], root2 = [8,1]
 * Output: [1,1,8,8]
 *
 *
 * Constraints:
 *
 * Each tree has at most 5000 nodes.
 * Each node's value is between [-10^5, 10^5].
 */
public class Q01305_AllElementsInTwoBSTs {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> nums1 = new ArrayList<>();
        inOrder(root1, nums1);

        List<Integer> nums2 = new ArrayList<>();
        inOrder(root2, nums2);

        List<Integer> ret = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (i < nums1.size() && j < nums2.size()) {
            if (nums1.get(i) <= nums2.get(j)) {
                ret.add(nums1.get(i));
                i ++;
            } else {
                ret.add(nums2.get(j));
                j ++;
            }
        }

        for (; i < nums1.size(); i++) {
            ret.add(nums1.get(i));
        }

        for (; j < nums2.size(); j++) {
            ret.add(nums2.get(j));
        }

        return ret;
    }

    private void inOrder(TreeNode root, List<Integer> ret) {
        if (root == null) {
            return;
        }

        inOrder(root.left, ret);
        ret.add(root.val);
        inOrder(root.right, ret);
    }
}
