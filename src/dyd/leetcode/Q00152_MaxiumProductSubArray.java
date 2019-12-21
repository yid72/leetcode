package dyd.leetcode;

import java.util.Arrays;

/**
 * 152. Maximum Product Subarray -- Medium
 *
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has
 * the largest product.
 *
 * Example 1:
 *
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
public class Q00152_MaxiumProductSubArray {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int max_dp = nums[0];
        int min_dp = nums[0];
        int maxProd = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int prod1 = max_dp * nums[i];
            int prod2 = min_dp * nums[i];
            max_dp = Math.max(Math.max(prod1, prod2), nums[i]);
            min_dp = Math.min(Math.min(prod1, prod2), nums[i]);
            maxProd = Math.max(maxProd, max_dp);
        }
        return maxProd;
    }

    public static void main(String[] args) {
        test(new int[] {1});
        test(new int[] {2,3,-2,4});
        test(new int[] {-2,0,-1});
        test(new int[] {-2,0,-1,-2});
    }

    private static void test(int[] nums) {
        Q00152_MaxiumProductSubArray q = new Q00152_MaxiumProductSubArray();
        System.out.printf("%s: %d\n", Arrays.toString(nums), q.maxProduct(nums));
    }
}
