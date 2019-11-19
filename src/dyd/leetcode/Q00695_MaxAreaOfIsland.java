package dyd.leetcode;

import java.util.Arrays;

/**
 * 695. Max Area of Island -- Medium
 *
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 *
 * Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
 *
 * Example 1:
 *
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
 * Example 2:
 *
 * [[0,0,0,0,0,0,0,0]]
 * Given the above grid, return 0.
 * Note: The length of each dimension in the given grid does not exceed 50.
 */
public class Q00695_MaxAreaOfIsland {
    int[][] grid;
    int n;
    int m;
    private boolean[][] visited;

    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        this.grid = grid;
        n = grid.length;
        m = grid[0].length;

        visited = new boolean[n][m];

        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    maxArea = Math.max(maxArea, dfs(i, j));
                }
            }
        }

        return maxArea;
    }

    private int dfs(int i, int j) {
        if (grid[i][j] == 0 || visited[i][j]) {
            return 0;
        }

        visited[i][j] = true;

        int area = 1;

        if (i > 0) {
            area += dfs(i - 1, j);
        }

        if (i < n - 1) {
            area += dfs(i + 1, j);
        }

        if (j > 0) {
            area += dfs(i, j - 1);
        }

        if (j < m - 1) {
            area += dfs(i, j + 1);
        }

        return area;
    }

    public static void main(String[] args) {
        test(new int[][] {
                {0,0,0,0,0,0,0,0}
        });

        test(new int[][] {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        });
    }

    private static void test(int[][] grid) {
        System.out.println(Arrays.deepToString(grid));
        Q00695_MaxAreaOfIsland q = new Q00695_MaxAreaOfIsland();
        System.out.println("Max area: " + q.maxAreaOfIsland(grid));
    }
}
