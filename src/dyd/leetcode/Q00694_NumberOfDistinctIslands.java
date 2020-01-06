package dyd.leetcode;

public class Q00694_NumberOfDistinctIslands {
    public int numDistinctIslands(int[][] grid) {
        int numberOfIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j);
                }
            }
        }
        return -1;
    }

    private void dfs(int i, int j) {

    }
}
