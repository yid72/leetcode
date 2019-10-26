package dyd.leetcode;

import java.util.Arrays;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the
 * sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
public class Q00064_MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        return minPathSum(grid, dp, grid.length - 1, grid[0].length - 1);
    }

    private int minPathSum(int[][] grid, int[][] dp, int i, int j) {
        if (i == 0 && j == 0) {
            return grid[i][j];
        }

        if (dp[i][j] < Integer.MAX_VALUE) {
            return dp[i][j];
        }

        int top = (i > 0) ? minPathSum(grid, dp, i - 1, j) : Integer.MAX_VALUE;
        int left = (j > 0) ? minPathSum(grid, dp, i, j - 1) : Integer.MAX_VALUE;
        dp[i][j] = grid[i][j] + Math.min(top, left);
        return dp[i][j];
    }

    public static void main(String[] args) {
        test(new int[][] {
                {1,3,1}, {1,5,1}, {4,2,1}
        });
    }

    private static void test(int[][] grid) {
        System.out.println(Arrays.deepToString(grid));
        Q00064_MinimumPathSum q = new Q00064_MinimumPathSum();
        System.out.println(q.minPathSum(grid));
    }
}
