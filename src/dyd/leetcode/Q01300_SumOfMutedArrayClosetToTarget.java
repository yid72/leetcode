package dyd.leetcode;

import java.util.Arrays;

/**
 * 1300. Sum of Mutated Array Closest to Target -- Medium
 *
 * Given an integer array arr and a target value target, return the integer value such that when we change all the integers larger than value in the given array to be equal to value, the sum of the array gets as close as possible (in absolute difference) to target.
 *
 * In case of a tie, return the minimum such integer.
 *
 * Notice that the answer is not neccesarilly a number from arr.
 *
 * Example 1:
 *
 * Input: arr = [4,9,3], target = 10
 * Output: 3
 * Explanation: When using 3 arr converts to [3, 3, 3] which sums 9 and that's the optimal answer.
 * Example 2:
 *
 * Input: arr = [2,3,5], target = 10
 * Output: 5
 * Example 3:
 *
 * Input: arr = [60864,25176,27249,21296,20204], target = 56803
 * Output: 11361
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 10^4
 * 1 <= arr[i], target <= 10^5
 */
public class Q01300_SumOfMutedArrayClosetToTarget {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);

        int value = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int num = target/(arr.length - i);
            int diff = Math.abs(arr[i] * (arr.length - i) - target);
            if (diff < min) {
                value = arr[i];
                min = diff;
            }
        }


        return value;
    }

    public static void main(String[] args) {
        test(new int[] {4,9,3}, 10);
    }

    private static void test(int[] arr, int target) {
        Q01300_SumOfMutedArrayClosetToTarget q = new Q01300_SumOfMutedArrayClosetToTarget();
        System.out.printf("arr=%s, target=%d: %d\n", Arrays.toString(arr), target, q.findBestValue(arr, target));
    }
}
