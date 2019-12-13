package dyd.leetcode;

import java.util.Arrays;

/**
 * 398. Random Pick Index -- Medium
 *
 * Given an array of integers with possible duplicates, randomly output the index of a given target number. You can
 * assume that the given target number must exist in the array.
 *
 * Note:
 * The array size can be very large. Solution that uses too much extra space will not pass the judge.
 *
 * Example:
 *
 * int[] nums = new int[] {1,2,3,3,3};
 * Solution solution = new Solution(nums);
 *
 * // pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
 * solution.pick(3);
 *
 * // pick(1) should return 0. Since in the array only nums[0] is equal to 1.
 * solution.pick(1);
 */
public class Q00398_RandomPickIndex {
    private int[] nums;

    public Q00398_RandomPickIndex(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        int count = 0;
        for (int num : nums) {
            if (num == target) {
                count ++;
            }
        }

        int index = (int) (count * Math.random());
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                if (j ++ == index) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        test(new int[] {1,2,3,3,3}, 3);
    }

    private static void test(int[] nums, int target) {
        Q00398_RandomPickIndex q = new Q00398_RandomPickIndex(nums);
        System.out.println(Arrays.toString(nums) + ", target=" + target + ": " + q.pick(target));
    }
}
