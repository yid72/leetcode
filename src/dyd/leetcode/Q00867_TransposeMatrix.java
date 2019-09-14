package dyd.leetcode;

import dyd.leetcode.common.PrintUtil;

/**
 * Given a matrix A, return the transpose of A.
 *
 * The transpose of a matrix is the matrix flipped over it's main diagonal, switching the row and column indices of the matrix.
 *
 *
 *
 * Example 1:
 *
 * Input: [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[1,4,7],[2,5,8],[3,6,9]]
 * Example 2:
 *
 * Input: [[1,2,3],[4,5,6]]
 * Output: [[1,4],[2,5],[3,6]]
 */
public class Q00867_TransposeMatrix {
    public int[][] transpose(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return new int[0][0];
        }

        int[][] B = new int[A[0].length][A.length];
        for (int i = 0; i < A[0].length; i++) {
            for (int j = 0; j < A.length; j++) {
                B[i][j] = A[j][i];
            }
        }

        return B;
    }

    public static void main(String[] args) {
        test(new int[][] {{1,2,3},{4,5,6},{7,8,9}});
        test(new int[][] {{1,2,3},{4,5,6}});
    }

    private static void test(int[][] A) {
        Q00867_TransposeMatrix transpose = new Q00867_TransposeMatrix();
        System.out.println("Input=");
        PrintUtil.printArray(A);
        System.out.println("Output=");
        int[][] B = transpose.transpose(A);
        PrintUtil.printArray(B);
    }
}
