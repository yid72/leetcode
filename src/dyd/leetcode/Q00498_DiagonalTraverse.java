package dyd.leetcode;

import dyd.leetcode.common.PrintUtil;

/**
 * 498. Diagonal Traverse -- Medium
 *
 * Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.
 *
 * Example:
 *
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 *
 * Output:  [1,2,4,7,5,3,6,8,9]
 */
public class Q00498_DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[] {};
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int[] res = new int[m * n];
        int k = 0;
        res[k ++] = matrix[0][0];

        int i = 0;
        int j = 0;
        while (i < m - 1 || j < n - 1) {
            while (i > 0 && j < n - 1) {
                res[k++] = matrix[--i][++j];
            }

            if (j == n - 1) {
                if (i < m - 1) {
                    res[k ++] = matrix[++ i][j];
                } else {
                    break;
                }
            } else {
                res[k ++] = matrix[i][++ j];
            }

            while (i < m - 1 && j > 0) {
                res[k ++] = matrix[++ i][-- j];
            }

            if (i == m - 1) {
                if (j < n - 1) {
                    res[k ++] = matrix[i][++ j];
                } else {
                    break;
                }
            } else {
                if (i < m - 1) {
                    res[k ++] = matrix[++ i][j];
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        test(new int[][] {
                {1,2,3},{4,5,6},{7,8,9}
        });
    }

    private static void test(int[][] matrix) {
        PrintUtil.printArray("matrix", matrix);

        Q00498_DiagonalTraverse q = new Q00498_DiagonalTraverse();
        PrintUtil.printArray("result", q.findDiagonalOrder(matrix));
    }
}
