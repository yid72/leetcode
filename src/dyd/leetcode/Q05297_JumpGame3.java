package dyd.leetcode;

import java.util.Arrays;

/**
 * 5297. Jump Game III -- Medium
 *
 * Given an array of non-negative integers arr, you are initially positioned at start index of the array. When you are
 * at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.
 *
 * Notice that you can not jump outside of the array at any time.
 *
 * Example 1:
 *
 * Input: arr = [4,2,3,0,3,1,2], start = 5
 * Output: true
 * Explanation:
 * All possible ways to reach at index 3 with value 0 are:
 * index 5 -> index 4 -> index 1 -> index 3
 * index 5 -> index 6 -> index 4 -> index 1 -> index 3
 * Example 2:
 *
 * Input: arr = [4,2,3,0,3,1,2], start = 0
 * Output: true
 * Explanation:
 * One possible way to reach at index 3 with value 0 is:
 * index 0 -> index 4 -> index 1 -> index 3
 * Example 3:
 *
 * Input: arr = [3,0,2,1,2], start = 2
 * Output: false
 * Explanation: There is no way to reach at index 1 with value 0.
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 5 * 10^4
 * 0 <= arr[i] < arr.length
 * 0 <= start < arr.length
 */
public class Q05297_JumpGame3 {
    private Boolean[] dp;
    private boolean[] visited;

    public boolean canReach(int[] arr, int start) {
        dp = new Boolean[arr.length];
        visited = new boolean[arr.length];
        return  helper(arr, start);
    }

    private boolean helper(int[] arr, int start) {
        if (arr[start] == 0) {
            return true;
        }

        if (dp[start] != null) {
            return dp[start];
        } else if (visited[start]) {
            return false;
        }

        visited[start] = true;

        dp[start] = (start + arr[start] < arr.length && helper(arr, start + arr[start]))
                || (start - arr[start] >= 0 && helper(arr, start - arr[start]));
        return dp[start];
    }

    public static void main(String[] args) {
        test(new int[] {4,2,3,0,3,1,2}, 5);
        test(new int[] {4,2,3,0,3,1,2}, 0);
        test(new int[] {3,0,2,1,2}, 2);
    }

    private static void test(int[] arr, int start) {
        Q05297_JumpGame3 q = new Q05297_JumpGame3();
        System.out.printf("arr=%s, start=%d: %b\n", Arrays.toString(arr), start, q.canReach(arr, start));
    }
}
