package dyd.leetcode;

import java.util.Arrays;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * Example 1:
 *
 * Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 * Example 2:
 *
 * Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * Output: false
 */
public class Q00074_Search2DMatrix {
    private int m;
    private int n;

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        m = matrix.length;
        n = matrix[0].length;
        int low = 0;
        int high = m * n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int val = getValue(matrix, mid);
            if (val == target) {
                return true;
            } else if (val < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    private int getValue(int[][] matrix, int pos) {
        int row = pos / n;
        int col = pos % n;
        return matrix[row][col];
    }

    private static void test(int[][] matrix, int target) {
        Q00074_Search2DMatrix q = new Q00074_Search2DMatrix();

        System.out.println(Arrays.deepToString(matrix));
        System.out.println(q.searchMatrix(matrix, target));
    }

    public static void main(String[] args) {
        Q00074_Search2DMatrix q = new Q00074_Search2DMatrix();
        int[][] matrix = {
                {1,   3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}};
        test(matrix, 3);
        test(matrix, 15);
        test(new int[][] {{}}, 1);
    }
}
