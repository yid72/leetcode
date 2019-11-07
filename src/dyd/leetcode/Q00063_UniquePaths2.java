package dyd.leetcode;

import java.util.Arrays;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right
 * corner of the grid (marked 'Finish' in the diagram below).
 *
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 *
 * Note: m and n will be at most 100.
 *
 * Example 1:
 *
 * Input:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * Output: 2
 * Explanation:
 * There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 */
public class Q00063_UniquePaths2 {
    private int[][] obstacleGrid;
    private int[][] paths;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }

        this.obstacleGrid = obstacleGrid;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        paths = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(paths[i], -1);
        }
        paths[0][0] = 1;

        return uniquePaths(m - 1, n - 1);
    }

    private int uniquePaths(int m, int n) {
        if (obstacleGrid[m][n] == 1) {
            return 0;
        }

        if (paths[m][n] != -1) {
            return paths[m][n];
        }

        int path = 0;
        if ( m > 0) {
            path += uniquePaths(m - 1, n);
        }
        if (n > 0) {
            path += uniquePaths(m, n - 1);
        }
        paths[m][n] = path;
        return path;
    }

    public static void main(String[] args) {
        test(new int[][] {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        });

       test(new int[][] {{1}});
    }

    private static void test(int[][] obstacleGrid) {
        System.out.println(Arrays.deepToString(obstacleGrid));
        Q00063_UniquePaths2 q = new Q00063_UniquePaths2();
        System.out.println(q.uniquePathsWithObstacles(obstacleGrid));
    }
}
