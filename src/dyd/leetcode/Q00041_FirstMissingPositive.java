package dyd.leetcode;

import java.util.Arrays;

/**
 * Given an unsorted integer array, find the smallest missing positive integer.
 *
 * Example 1:
 *
 * Input: [1,2,0]
 * Output: 3
 * Example 2:
 *
 * Input: [3,4,-1,1]
 * Output: 2
 * Example 3:
 *
 * Input: [7,8,9,11,12]
 * Output: 1
 * Note:
 *
 * Your algorithm should run in O(n) time and uses constant extra space.
 */
public class Q00041_FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) {
            return 1;
        }

        boolean foundOne = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                foundOne = true;
                break;
            }
        }

        if (!foundOne) {
            return 1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > nums.length) {
                nums[i] = 1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]);
            if (index == nums.length) {
                if (nums[0] > 0) {
                    nums[0] = -nums[0];
                }
            } else if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }

        if (nums[0] > 0) {
            return nums.length;
        }

        return nums.length + 1;
    }

    public static void main(String[] args) {
        test(new int[] {2});
        test(new int[] {1});
        test(new int[] {1, 2, 0});
        test(new int[] {0, 1, 2});
        test(new int[] {1, 2, 3});
        test(new int[] {3,4,-1,1});
        test(new int[] {7,8,9,11,12});
        test(new int[] {1, 3, 3});
        test(new int[] {0, -1, 3, 1});
    }

    private static void test(int[] nums) {
        System.out.println("Input: " + Arrays.toString(nums));
        Q00041_FirstMissingPositive q = new Q00041_FirstMissingPositive();
        System.out.println("First missing positive: " + q.firstMissingPositive(nums));
    }
}
