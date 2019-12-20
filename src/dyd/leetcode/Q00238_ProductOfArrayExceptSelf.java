package dyd.leetcode;

import java.util.Arrays;

/**
 * 238. Product of Array Except Self -- Medium
 *
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product
 * of all the elements of nums except nums[i].
 *
 * Example:
 *
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Note: Please solve it without division and in O(n).
 *
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of
 * space complexity analysis.)
 */
public class Q00238_ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] ret = new int[nums.length];

        int[] leftProducts = new int[nums.length];
        leftProducts[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            leftProducts[i] = leftProducts[i - 1] * nums[i];
        }

        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            ret[i] = right;
            if (i > 0) {
                ret[i] *= leftProducts[i - 1];
            }
            right = right * nums[i];
        }

        return ret;
    }

    public static void main(String[] args) {
        test(new int[] {1,2});
        test(new int[] {1,2,3,4});
    }

    private static void test(int[] nums) {
        Q00238_ProductOfArrayExceptSelf q = new Q00238_ProductOfArrayExceptSelf();
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + Arrays.toString(q.productExceptSelf(nums)));
    }
}
