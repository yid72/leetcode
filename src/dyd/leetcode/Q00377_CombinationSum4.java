package dyd.leetcode;

import java.util.Arrays;

/**
 * 377. Combination Sum IV -- Medium
 *
 * Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add
 * up to a positive integer target.
 *
 * Example:
 *
 * nums = [1, 2, 3]
 * target = 4
 *
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 *
 * Note that different sequences are counted as different combinations.
 *
 * Therefore the output is 7.
 *
 *
 * Follow up:
 * What if negative numbers are allowed in the given array?
 * How does it change the problem?
 * What limitation we need to add to the question to allow negative numbers?
 *
 * Credits:
 * Special thanks to @pbrother for adding this problem and creating all test cases.
 */
public class Q00377_CombinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        return combinationSum4(nums, target, new Integer[target]);
    }

    private int combinationSum4(int[] nums, int target, Integer[] dp) {
        if (target == 0) {
            return 0;
        }

        if (dp[target - 1] != null) {
            return dp[target - 1];
        }

        int ret = 0;
        for (int num : nums) {
            if (num < target) {
                ret += combinationSum4(nums, target - num, dp);
            } else if (num == target) {
                ret ++;
            }
        }

        dp[target - 1] = ret;
        return dp[target - 1];
    }

    public static void main(String[] args) {
        test(new int[] {1, 2, 3}, 4);
    }

    private static void test(int[] nums, int target) {
        Q00377_CombinationSum4 q = new Q00377_CombinationSum4();
        System.out.printf("nums=%s, target=%d: %d\n", Arrays.toString(nums), target, q.combinationSum4(nums, target));
    }
}
