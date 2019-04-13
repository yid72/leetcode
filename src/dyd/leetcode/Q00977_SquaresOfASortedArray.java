package dyd.leetcode;

import dyd.leetcode.common.PrintUtil;

public class Q00977_SquaresOfASortedArray {
    public int[] sortedSquares(int[] A) {
        int[] B = new int[A.length];

        // i is the position of the smallest non-negative number
        int i = 0;
        while (i < A.length && A[i] < 0) {
            i ++;
        }

        // j is the position of the largest negative number
        int j = i - 1;

        int k = 0;
        while (i < A.length && j >= 0) {
            if (A[i] <= -A[j]) {
                B[k++] = A[i]*A[i];
                i ++;
            } else {
                B[k++] = A[j]*A[j];
                j --;
            }
        }

        while (i < A.length) {
            B[k++] = A[i]*A[i];
            i ++;
        }

        while (j >= 0) {
            B[k++] = A[j]*A[j];
            j --;
        }

        return B;
    }

    public static void main(String[] args) {
        Q00977_SquaresOfASortedArray q = new Q00977_SquaresOfASortedArray();
        int[] A1 = {-4,-1,0,3,10};
        PrintUtil.printArray("Input1", A1);
        int[] B1 = q.sortedSquares(A1);
        PrintUtil.printArray("Output1", B1);

        System.out.println();
        int[] A2 = {-7,-3,2,3,11};
        PrintUtil.printArray("Input2", A2);
        int[] B2 = q.sortedSquares(A2);
        PrintUtil.printArray("Output2", B2);
    }
}
