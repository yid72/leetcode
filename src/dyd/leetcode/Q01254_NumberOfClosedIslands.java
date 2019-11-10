package dyd.leetcode;

import java.util.Arrays;

public class Q01254_NumberOfClosedIslands {
    private int[][] grid;
    private boolean[][] visited;
    private int closedCount;

    public int closedIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        this.grid = grid;
        visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == 0) {
                    if (dfs(i, j)) {
                        closedCount ++;
                    }
                }
            }
        }

        return closedCount;
    }

    private boolean dfs(int i, int j) {
        boolean closed = true;

        if (visited[i][j] || grid[i][j] == 1) {
            return true;
        }

        visited[i][j] = true;

        if (i > 0) {
            closed &= dfs(i - 1, j);
        } else {
            closed = false;
        }

        if (i < grid.length - 1) {
            closed &= dfs(i + 1, j);
        } else {
            closed = false;
        }

        if (j > 0) {
            closed &= dfs(i, j - 1);
        } else {
            closed = false;
        }

        if (j < grid[0].length - 1) {
            closed &= dfs(i, j + 1);
        } else {
            closed = false;
        }

        return closed;
    }

    public static void main(String[] args) {
        test(new int[][] {
                {1,1,1,1,1,1,1,0}, {1,0,0,0,0,1,1,0}, {1,0,1,0,1,1,1,0}, {1,0,0,0,0,1,0,1}, {1,1,1,1,1,1,1,0}
        });

        test(new int[][] {
                {0,0,1,0,0}, {0,1,0,1,0}, {0,1,1,1,0}
        });

        test(new int[][] {
                {0,0,1,1,0,1,0,0,1,0},
                {1,1,0,1,1,0,1,1,1,0},
                {1,0,1,1,1,0,0,1,1,0},
                {0,1,1,0,0,0,0,1,0,1},
                {0,0,0,0,0,0,1,1,1,0},
                {0,1,0,1,0,1,0,1,1,1},
                {1,0,1,0,1,1,0,0,0,1},
                {1,1,1,1,1,1,0,0,0,0},
                {1,1,1,0,0,1,0,1,0,1},
                {1,1,1,0,1,1,0,1,1,0}
        });
    }

    private static void test(int[][] grid) {
        Q01254_NumberOfClosedIslands q = new Q01254_NumberOfClosedIslands();
        System.out.println(Arrays.deepToString(grid) + ": ");
        System.out.println(q.closedIsland(grid));
    }
}
