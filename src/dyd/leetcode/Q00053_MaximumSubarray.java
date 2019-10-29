package dyd.leetcode;

import java.util.Arrays;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum
 * and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 *
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which
 * is more subtle.
 */
public class Q00053_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
            maxSum = Math.max(maxSum, nums[i]);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        test(new int[] {-2,1,-3,4,-1,2,1,-5,4});
    }

    private static void test(int[] nums) {
        System.out.println(Arrays.toString(nums));
        Q00053_MaximumSubarray q = new Q00053_MaximumSubarray();
        System.out.println(q.maxSubArray(nums));
    }
}
