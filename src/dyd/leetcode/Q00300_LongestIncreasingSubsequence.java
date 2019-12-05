package dyd.leetcode;

import java.util.Arrays;

/**
 * 300. Longest Increasing Subsequence -- Medium
 *
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * Example:
 *
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Note:
 *
 * There may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 * Follow up: Could you improve it to O(n log n) time complexity?
 */
public class Q00300_LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int longest = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            longest = Math.max(longest, dp[i]);
        }
        return longest;
    }

    public static void main(String[] args) {
        test(new int[] {0});
        test(new int[] {2, 2});
        test(new int[] {10,9,2,5,3,7,101,18});
        test(new int[] {1, 3, 2, 4, 9, 6, 7, 8});
        test(new int[] {1,3,6,7,9,4,10,5,6});
    }

    private static void test(int[] nums) {
        Q00300_LongestIncreasingSubsequence q = new Q00300_LongestIncreasingSubsequence();
        System.out.println("nums=" + Arrays.toString(nums) + ": " + q.lengthOfLIS(nums));
    }
}
