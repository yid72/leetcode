package dyd.leetcode;

import java.util.Arrays;

/**
 * 1267. Count Servers that Communicate -- Medium
 *
 * You are given a map of a server center, represented as a m * n integer matrix grid, where 1 means that on that cell there is a server and 0 means that it is no server. Two servers are said to communicate if they are on the same row or on the same column.
 *
 * Return the number of servers that communicate with any other server.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: grid = [[1,0],[0,1]]
 * Output: 0
 * Explanation: No servers can communicate with others.
 * Example 2:
 *
 *
 *
 * Input: grid = [[1,0],[1,1]]
 * Output: 3
 * Explanation: All three servers can communicate with at least one other server.
 * Example 3:
 *
 *
 *
 * Input: grid = [[1,1,0,0],[0,0,1,0],[0,0,1,0],[0,0,0,1]]
 * Output: 4
 * Explanation: The two servers in the first row can communicate with each other. The two servers in the third column can communicate with each other. The server at right bottom corner can't communicate with any other server.
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m <= 250
 * 1 <= n <= 250
 * grid[i][j] == 0 or 1
 */
public class Q01267_CountServersThatCommunicate {
    int n;
    int m;
    int[][] grid;
    boolean[][] visited;

    public int countServers(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        this.grid = grid;
        n = grid.length;
        m = grid[0].length;
        visited = new boolean[n][m];

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int c = dfs(i, j);
                    if (c > 1) {
                        count += c;
                    }
                }
            }
        }

        return count;
    }

    private int dfs(int i, int j) {
        if (visited[i][j]) {
            return 0;
        }

        visited[i][j] = true;

        int count = 0;

        for (int k = 0; k < n; k++) {
            if (grid[k][j] == 1 && !visited[k][j]) {
                count += dfs(k, j);
            }
        }

        for (int k = 0; k < m; k++) {
            if (grid[i][k] == 1 && !visited[i][k]) {
                count += dfs(i, k);
            }
        }

        return count + 1;
    }

    public static void main(String[] args) {
        test(new int[][] {
                {1, 0}, {0, 1}
        });

        test(new int[][] {
                {1, 0}, {1, 1}
        });

        test(new int[][] {
                {1,1,0,0},{0,0,1,0},{0,0,1,0},{0,0,0,1}
        });
    }
    
    private static void test(int[][] grid) {
        System.out.println(Arrays.deepToString(grid));
        Q01267_CountServersThatCommunicate q = new Q01267_CountServersThatCommunicate();
        System.out.println(q.countServers(grid));
    }
}
