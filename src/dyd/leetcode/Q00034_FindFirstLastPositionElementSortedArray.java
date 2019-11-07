package dyd.leetcode;

import java.util.Arrays;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 * Medium
 *
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target
 * value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */
public class Q00034_FindFirstLastPositionElementSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[] {-1, -1};
        }

        int left = binarySearch(nums, target, true);
        int right = binarySearch(nums, target, false);
        return new int[] {left, right};
    }

    private int binarySearch(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi)/2;
            if (left) {
                if (target <= nums[mid]){
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target >= nums[mid]){
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }

            }
        }

        if (left) {
            if (lo > nums.length - 1) {
                lo = nums.length - 1;
            }
            if (nums[lo] == target) {
                return lo;
            } else {
                return -1;
            }
        } else {
            if (hi < 0) {
                hi = 0;
            }
            if (nums[hi] == target) {
                return hi;
            } else {
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        test(new int[] {5,7,7,8,8,10}, 8);
        test(new int[] {5,7,7,8,8,10}, 7);
        test(new int[] {5,7,7,8,8,10}, 9);
        test(new int[] {}, 0);
    }

    private static void test(int[] nums, int target) {
        Q00034_FindFirstLastPositionElementSortedArray q = new Q00034_FindFirstLastPositionElementSortedArray();
        System.out.println(Arrays.toString(nums) + ", target=" + target + ": " + Arrays.toString(q.searchRange(nums, target)));
    }
}
