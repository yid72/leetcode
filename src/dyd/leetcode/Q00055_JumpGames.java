package dyd.leetcode;

import java.util.Arrays;

/**
 * 55. Jump Game -- Medium
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * Example 1:
 *
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 *              jump length is 0, which makes it impossible to reach the last index.
 */
public class Q00055_JumpGames {
    public boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return false;
        }

        boolean[] dp = new boolean[nums.length];
        dp[0] = true;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && nums[j] >= (i - j)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        test(new int[] {2,3,1,1,4});
        test(new int[] {3,2,1,0,4});
    }

    private static void test(int[] nums) {
        Q00055_JumpGames q = new Q00055_JumpGames();
        System.out.println(Arrays.toString(nums) + ": " + q.canJump(nums));
    }
}
