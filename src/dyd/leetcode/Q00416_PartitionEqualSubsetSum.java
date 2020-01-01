package dyd.leetcode;

import java.util.Arrays;

/**
 * 416. Partition Equal Subset Sum
 * Medium
 *
 * 1768
 *
 * 54
 *
 * Add to List
 *
 * Share
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 *
 * Note:
 *
 * Each of the array element will not exceed 100.
 * The array size will not exceed 200.
 *
 *
 * Example 1:
 *
 * Input: [1, 5, 11, 5]
 *
 * Output: true
 *
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 *
 *
 * Example 2:
 *
 * Input: [1, 2, 3, 5]
 *
 * Output: false
 *
 * Explanation: The array cannot be partitioned into equal sum subsets.
 */
public class Q00416_PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum %2 == 1) {
            return false;
        }

        return canPartition(nums, 0, sum/2, new Boolean[nums.length][sum/2]);
    }

    public boolean canPartition(int[] nums, int start, int target, Boolean[][] dp) {
        if (target <= 0 || start >= nums.length) {
            return false;
        }

        if (dp[start][target - 1] != null) {
            return dp[start][target - 1];
        }

        boolean can = false;
        for (int i = start; i < nums.length; i++) {
            if (nums[i] == target) {
                can = true;
                break;
            } else if (nums[i] < target) {
                can = canPartition(nums, i + 1, target - nums[i], dp);
                break;
            }
        }

        if (!can) {
            can = canPartition(nums, start + 1, target, dp);
        }

        dp[start][target - 1] = can;
        return can;
    }

    public static void main(String[] args) {
        test(new int[] {1, 2, 3});
        test(new int[] {1, 5, 11, 5});
        test(new int[] {1, 2, 3, 5});
    }

    private static void test(int[] nums) {
        Q00416_PartitionEqualSubsetSum q = new Q00416_PartitionEqualSubsetSum();
        System.out.printf("nums=%s: %b\n", Arrays.toString(nums), q.canPartition(nums));
    }
}
