package dyd.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1391. Check if There is a Valid Path in a Grid -- Medium
 *
 * Given a m x n grid. Each cell of the grid represents a street. The street of grid[i][j] can be:
 * 1 which means a street connecting the left cell and the right cell.
 * 2 which means a street connecting the upper cell and the lower cell.
 * 3 which means a street connecting the left cell and the lower cell.
 * 4 which means a street connecting the right cell and the lower cell.
 * 5 which means a street connecting the left cell and the upper cell.
 * 6 which means a street connecting the right cell and the upper cell.
 *
 *
 * You will initially start at the street of the upper-left cell (0,0). A valid path in the grid is a path which starts from the upper left cell (0,0) and ends at the bottom-right cell (m - 1, n - 1). The path should only follow the streets.
 *
 * Notice that you are not allowed to change any street.
 *
 * Return true if there is a valid path in the grid or false otherwise.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[2,4,3],[6,5,2]]
 * Output: true
 * Explanation: As shown you can start at cell (0, 0) and visit all the cells of the grid to reach (m - 1, n - 1).
 * Example 2:
 *
 *
 * Input: grid = [[1,2,1],[1,2,1]]
 * Output: false
 * Explanation: As shown you the street at cell (0, 0) is not connected with any street of any other cell and you will get stuck at cell (0, 0)
 * Example 3:
 *
 * Input: grid = [[1,1,2]]
 * Output: false
 * Explanation: You will get stuck at cell (0, 1) and you cannot reach cell (0, 2).
 * Example 4:
 *
 * Input: grid = [[1,1,1,1,1,1,3]]
 * Output: true
 * Example 5:
 *
 * Input: grid = [[2],[2],[2],[2],[2],[2],[6]]
 * Output: true
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * 1 <= grid[i][j] <= 6
 */
public class Q01391_CheckIfThereIsAPathInAGrid {

    private int[][] grid;
    private int m;
    private int n;
    private boolean[][] visited;

    public boolean hasValidPath(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        return dfs(0, 0);
    }

    private boolean dfs(int i, int j) {
        if (i == m - 1 && j == n - 1) {
            return true;
        }

        if (visited[i][j]) {
            return false;
        }

        visited[i][j] = true;
        List<Integer[]> adjacents = getAdjacents(i, j);
        for (Integer[] adjacent : adjacents) {
            if (dfs(adjacent[0], adjacent[1])) {
                return true;
            }
        }

        return false;
    }

    private List<Integer[]> getAdjacents(int i, int j) {
        List<Integer[]> res = new ArrayList<>();
        switch(grid[i][j]) {
            case 1:
                addLeft(res, i, j);
                addRight(res, i, j);
                break;

            case 2:
                addTop(res, i, j);
                addBottom(res, i, j);
                break;

            case 3:
                addLeft(res, i, j);
                addBottom(res, i, j);
                break;

            case 4:
                addRight(res, i, j);
                addBottom(res, i, j);
                break;

            case 5:
                addLeft(res, i, j);
                addTop(res, i, j);
                break;

            case 6:
                addRight(res, i, j);
                addTop(res, i, j);
                break;

            default:
                break;
        }
        return res;
    }

    private void addLeft(List<Integer[]> res, int i, int j) {
        if (j <= 0) {
            return;
        }
        int leftVal = grid[i][j - 1];
        if (leftVal == 1 || leftVal == 4 || leftVal == 6) {
            res.add(new Integer[] {i, j - 1});
        }
    }

    private void addRight(List<Integer[]> res, int i, int j) {
        if (j >= n - 1) {
            return;
        }

        int rightVal = grid[i][j + 1];
        if (rightVal == 1 || rightVal == 3 || rightVal == 5) {
            res.add(new Integer[] {i, j + 1});
        }
    }

    private void addTop(List<Integer[]> res, int i, int j) {
        if (i <= 0) {
            return;
        }
        int topVal = grid[i - 1][j];
        if (topVal == 2 || topVal == 3 || topVal == 4) {
            res.add(new Integer[] {i - 1, j});
        }
    }

    private void addBottom(List<Integer[]> res, int i, int j) {
        if (i >= m - 1) {
            return;
        }
        int bottomVal = grid[i + 1][j];
        if (bottomVal == 2 || bottomVal == 5 || bottomVal == 6) {
            res.add(new Integer[] {i + 1, j});
        }
    }
}
