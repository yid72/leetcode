package dyd.leetcode;

import java.util.Arrays;

/**
 * Given n and m which are the dimensions of a matrix initialized by zeros and given an array indices where indices[i] =
 * [ri, ci]. For each pair of [ri, ci] you have to increment all cells in row ri and column ci by 1.
 *
 * Return the number of cells with odd values in the matrix after applying the increment to all indices.
 *
 *
 * Example 1:
 *
 *
 * Input: n = 2, m = 3, indices = [[0,1],[1,1]]
 * Output: 6
 * Explanation: Initial matrix = [[0,0,0],[0,0,0]].
 * After applying first increment it becomes [[1,2,1],[0,1,0]].
 * The final matrix will be [[1,3,1],[1,3,1]] which contains 6 odd numbers.
 * Example 2:
 *
 *
 * Input: n = 2, m = 2, indices = [[1,1],[0,0]]
 * Output: 0
 * Explanation: Final matrix = [[2,2],[2,2]]. There is no odd number in the final matrix.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 50
 * 1 <= m <= 50
 * 1 <= indices.length <= 100
 * 0 <= indices[i][0] < n
 * 0 <= indices[i][1] < m
 */
public class Q01252_CellsWithOddValuesInAMatrix {
    public int oddCells(int n, int m, int[][] indices) {
        int[][] matrix = new int[n][m];
        for (int i = 0; i < indices.length; i++) {
            increaseRow(matrix, indices[i][0]);
            increaseCol(matrix, indices[i][1]);
        }

        int oddCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] % 2 == 1) {
                    oddCount ++;
                }
            }
        }
        return oddCount;
    }

    private void increaseRow(int[][] matrix, int row) {
        for (int i = 0; i < matrix[row].length; i++) {
            matrix[row][i] ++;
        }
    }

    private void increaseCol(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] ++;
        }
    }

    public static void main(String[] args) {
        test(2, 3, new int[][] {{0, 1}, {1, 1}});
    }

    private static void test(int n, int m, int[][] indices) {
        System.out.printf("n=%d, m=%d, %s: ", n, m, Arrays.deepToString(indices));
        Q01252_CellsWithOddValuesInAMatrix q = new Q01252_CellsWithOddValuesInAMatrix();
        System.out.println(q.oddCells(n, m, indices));
    }

}
