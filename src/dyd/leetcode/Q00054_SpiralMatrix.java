package dyd.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * Example 1:
 *
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 *
 * Input:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class Q00054_SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> results = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return results;
        }

        int rowStart = 0;
        int rowEnd = matrix.length;
        int colStart = 0;
        int colEnd = matrix[0].length;

        while (rowStart < rowEnd && colStart < colEnd) {
            for (int i = colStart; i < colEnd; i++) {
                results.add(matrix[rowStart][i]);
            }

            if (++ rowStart >= rowEnd) {
                break;
            }

            for (int i = rowStart; i < rowEnd; i++) {
                results.add(matrix[i][colEnd - 1]);
            }

            if (-- colEnd <= colStart) {
                break;
            }

            for (int i = colEnd - 1; i >= colStart; i--) {
                results.add(matrix[rowEnd - 1][i]);
            }

            if (-- rowEnd <= rowStart) {
                break;
            }

            for (int i = rowEnd - 1; i >= rowStart; i--) {
                results.add(matrix[i][colStart]);
            }
            colStart ++;
        }

        return results;
    }

    public static void main(String[] args) {
        test(new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });

        test(new int[][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        });
    }

    private static void test(int[][] matrix) {
        System.out.println(Arrays.deepToString(matrix));
        Q00054_SpiralMatrix q = new Q00054_SpiralMatrix();
        System.out.println(q.spiralOrder(matrix));
    }
}
