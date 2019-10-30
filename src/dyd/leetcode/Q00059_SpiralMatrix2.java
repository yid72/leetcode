package dyd.leetcode;

import java.util.Arrays;

/**
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 *
 * Example:
 *
 * Input: 3
 * Output:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */
public class Q00059_SpiralMatrix2 {
    public int[][] generateMatrix(int n) {
        if (n == 0) {
            return new int[0][0];
        }

        int[][] matrix = new int[n][n];

        int rowStart = 0;
        int rowEnd = n;
        int colStart = 0;
        int colEnd = n;
        int cur = 1;
        while (rowStart < rowEnd && colStart < colEnd) {
            for (int i = colStart; i < colEnd; i++) {
                matrix[rowStart][i] = cur ++;
            }

            if (++ rowStart >= rowEnd) {
                break;
            }

            for (int i = rowStart; i < rowEnd; i++) {
                matrix[i][colEnd - 1] = cur ++;
            }

            if (-- colEnd <= colStart) {
                break;
            }

            for (int i = colEnd - 1; i >= colStart; i--) {
                matrix[rowEnd - 1][i] = cur ++;
            }

            if (-- rowEnd <= rowStart) {
                break;
            }

            for (int i = rowEnd - 1; i >= rowStart; i--) {
                matrix[i][colStart] = cur ++;
            }

            ++ colStart;
        }

        return matrix;
    }

    public static void main(String[] args) {
        test(1);
        test(2);
        test(3);
        test(5);
    }

    private static void test(int n) {
        System.out.println("n=" + n);
        Q00059_SpiralMatrix2 q = new Q00059_SpiralMatrix2();
        System.out.println(Arrays.deepToString(q.generateMatrix(n)));
    }
}
