package dyd.leetcode;

import java.util.Arrays;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money
 * stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of
 * money you can rob tonight without alerting the police.
 *
 * Example 1:
 *
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 *
 * Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 *              Total amount you can rob = 2 + 9 + 1 = 12.
 */
public class Q00198_HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] rob = new int[nums.length];
        rob[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            rob[i] = Math.max(rob[i - 1], nums[i]);
            if (i > 1) {
                rob[i] = Math.max(rob[i], rob[i - 2] + nums[i]);
            }
        }
        return rob[nums.length - 1];
    }

    public static void main(String[] args) {
        test(new int[] {1,2,3,1});
        test(new int[] {2,7,9,3,1});
    }

    private static void test(int[] nums) {
        System.out.println(Arrays.toString(nums));
        Q00198_HouseRobber q = new Q00198_HouseRobber();
        System.out.println(q.rob(nums));
    }
}
