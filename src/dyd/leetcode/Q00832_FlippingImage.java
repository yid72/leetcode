package dyd.leetcode;

import dyd.leetcode.common.PrintUtil;

public class Q00832_FlippingImage {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length/2; j++) {
                int temp = A[i][j];
                A[i][j] = 1 - A[i][A[i].length - 1 - j];
                A[i][A[i].length - 1 - j] = 1 - temp;
            }
            if (A[i].length % 2 == 1) {
                A[i][A[i].length/2] = 1 - A[i][A[i].length/2];
            }
        }
        return A;
    }

    public static void main(String[] args) {
        Q00832_FlippingImage q = new Q00832_FlippingImage();

        int[][] A = {
                {1, 1, 0},
                {1, 0, 1},
                {0, 0, 0}
        };
        PrintUtil.printArray("Input", A);
        A = q.flipAndInvertImage(A);
        PrintUtil.printArray("Output", A);

        int[][] B = {
                {1, 1, 0, 0},
                {1, 0, 0, 1},
                {0, 1, 1, 1},
                {1, 0, 1, 0}
        };
        PrintUtil.printArray("Input", B);
        B = q.flipAndInvertImage(B);
        PrintUtil.printArray("Output", B);
    }
}
