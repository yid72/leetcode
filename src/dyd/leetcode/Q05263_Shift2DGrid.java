package dyd.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 5263. Shift 2D Grid -- Easy
 *
 * Given a 2D grid of size n * m and an integer k. You need to shift the grid k times.
 *
 * In one shift operation:
 *
 * Element at grid[i][j] becomes at grid[i][j + 1].
 * Element at grid[i][m - 1] becomes at grid[i + 1][0].
 * Element at grid[n - 1][m - 1] becomes at grid[0][0].
 * Return the 2D grid after applying shift operation k times.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
 * Output: [[9,1,2],[3,4,5],[6,7,8]]
 * Example 2:
 *
 *
 * Input: grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
 * Output: [[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
 * Example 3:
 *
 * Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
 * Output: [[1,2,3],[4,5,6],[7,8,9]]
 *
 *
 * Constraints:
 *
 * 1 <= grid.length <= 50
 * 1 <= grid[i].length <= 50
 * -1000 <= grid[i][j] <= 1000
 * 0 <= k <= 100
 */
public class Q05263_Shift2DGrid {
    private int n;
    private int m;

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> ret = new ArrayList<>();

        if (grid.length == 0 || grid[0].length == 0) {
            return ret;
        }

        n = grid.length;
        m = grid[0].length;

        for (int i =0; i < k; i++) {
            oneShift(grid);
        }

        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                row.add(grid[i][j]);
            }
            ret.add(row);
        }
        return ret;
    }

    private void oneShift(int[][] grid) {
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            temp.add(grid[i][m - 1]);
        }

        for (int j = m - 1; j > 0; j--) {
            for (int i = 0; i < n; i++) {
                grid[i][j] = grid[i][j - 1];
            }
        }

        for (int i = 0; i < n - 1; i++) {
            grid[i + 1][0] = temp.get(i);
        }

        grid[0][0] = temp.get(n - 1);
    }

    public static void main(String[] args) {
        test(new int[][] {
                        {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
                        },
                1);
        test(new int[][] {
                        {3,8,1,9}, {19,7,2,5}, {4,6,11,10}, {12,0,21,13}
                },
                4);
    }

    private static void test(int[][] grid, int k) {
        System.out.println(Arrays.deepToString(grid));
        System.out.println("k = " + k);
        Q05263_Shift2DGrid q = new Q05263_Shift2DGrid();
        System.out.println(q.shiftGrid(grid, k));
    }
}
