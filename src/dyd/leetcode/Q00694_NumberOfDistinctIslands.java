package dyd.leetcode;

import java.util.*;

/**
 * 694. Number of Distinct Islands -- Medium
 *
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected
 * 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 *
 * Count the number of distinct islands. An island is considered to be the same as another if and only if one island can
 * be translated (and not rotated or reflected) to equal the other.
 *
 * Example 1:
 * 11000
 * 11000
 * 00011
 * 00011
 * Given the above grid map, return 1.
 * Example 2:
 * 11011
 * 10000
 * 00001
 * 11011
 * Given the above grid map, return 3.
 *
 * Notice that:
 * 11
 * 1
 * and
 *  1
 * 11
 * are considered different island shapes, because we do not consider reflection / rotation.
 * Note: The length of each dimension in the given grid does not exceed 50.
 */
public class Q00694_NumberOfDistinctIslands {
    static class Island {
        int minI = Integer.MAX_VALUE;
        int minJ = Integer.MAX_VALUE;
        int maxI = Integer.MIN_VALUE;
        int maxJ = Integer.MIN_VALUE;

        List<int[]> positions = new ArrayList<>();

        void add(int i, int j) {
            positions.add(new int[] {i, j});

            minI = Math.min(minI, i);
            minJ = Math.min(minJ, j);
            maxI = Math.max(maxI, i);
            maxJ = Math.max(maxJ, j);
        }

        String createUniqueKey() {
            int[][] area = new int[maxI - minI + 1][maxJ - minJ + 1];
            for (int[] p : positions) {
                area[p[0] - minI][p[1] - minJ] = 1;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < area.length; i++) {
                sb.append('[');
                for (int j = 0; j < area[i].length; j++) {
                    if (j > 0) {
                        sb.append(',');
                    }
                    sb.append(area[i][j]);
                }
                sb.append(']');
            }
            return sb.toString();
        }
    }

    private int[][] grid;
    private int m;
    private int n;
    private boolean[][] visited;

    public int numDistinctIslands(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;

        visited = new boolean[grid.length][grid[0].length];

        Set<String> keys = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    Island island = new Island();
                    dfs(i, j, island);
                    keys.add(island.createUniqueKey());
                }
            }
        }
        return keys.size();
    }

    private void dfs(int i, int j, Island island) {
        if (visited[i][j] || grid[i][j] == 0) {
            return;
        }

        visited[i][j] = true;
        island.add(i, j);

        List<int[]> adjs = getAdjs(i, j);
        for (int[] adj : adjs) {
            dfs(adj[0], adj[1], island);
        }
    }

    private List<int[]> getAdjs(int i, int j) {
        List<int[]> ret = new ArrayList<>();
        if (i > 0 && grid[i - 1][j] == 1) {
            ret.add(new int[] {i - 1, j});
        }
        if (i < m - 1 && grid[i + 1][j] == 1) {
            ret.add(new int[] {i + 1, j});
        }
        if (j > 0 && grid[i][j - 1] == 1) {
            ret.add(new int[] {i, j - 1});
        }
        if (j < n - 1 && grid[i][j + 1] == 1) {
            ret.add(new int[] {i, j + 1});
        }
        return ret;
    }

    public static void main(String[] args) {
        test(new int[][] {
                {1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,0,1,1},
                {0,0,0,1,1}
        });

        test(new int[][] {
                {1,1,0,1,1},
                {1,0,0,0,0},
                {0,0,0,0,1},
                {1,1,0,1,1}
        });
    }
    private static void test(int[][] grid) {
        Q00694_NumberOfDistinctIslands q = new Q00694_NumberOfDistinctIslands();
        System.out.printf("grid=%s: %d\n", Arrays.deepToString(grid), q.numDistinctIslands(grid));
    }
}
