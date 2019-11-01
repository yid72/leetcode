package dyd.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 *
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 */
public class Q00303_RangeSumQueryImmutable {
    private int[] sums;

    public Q00303_RangeSumQueryImmutable(int[] nums) {
        sums = new int[nums.length];
        if (sums.length == 0) {
            return;
        }

        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (sums.length == 0) {
            return 0;
        }

        if (i == 0) {
            return sums[j];
        }
        return sums[j] - sums[i - 1];
    }

    public static void main(String[] args) {
        test(new int[] {-2, 0, 3, -5, 2, -1}, 0, 2);
        test(new int[] {-2, 0, 3, -5, 2, -1}, 2, 5);
        test(new int[] {-2, 0, 3, -5, 2, -1}, 0, 5);
    }

    private static void test(int[] nums, int i, int j) {
        Q00303_RangeSumQueryImmutable q = new Q00303_RangeSumQueryImmutable(nums);
        System.out.printf("%s. i=%d, j=%d: %d\n", Arrays.toString(nums), i, j, q.sumRange(i, j));
    }
}
