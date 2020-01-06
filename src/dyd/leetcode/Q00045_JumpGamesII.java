package dyd.leetcode;

import java.util.Arrays;

/**
 * 45. Jump Game II -- Hard
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * Example:
 *
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 *     Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Note:
 *
 * You can assume that you can always reach the last index.
 */
public class Q00045_JumpGamesII {
    public int jump(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];

        for (int i = 1; i < nums.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (nums[j] >= (i - j)) {
                    min = Math.min(min, dp[j] + 1);
                }
            }
            dp[i] = min;
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        test(new int[] {2,3,1,1,4});
    }

    private static void test(int[] nums) {
        Q00045_JumpGamesII q = new Q00045_JumpGamesII();
        System.out.println(Arrays.toString(nums) + ": " + q.jump(nums));
    }
}
