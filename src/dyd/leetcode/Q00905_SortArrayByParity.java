package dyd.leetcode;

import dyd.leetcode.common.PrintUtil;

public class Q00905_SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int i = 0;
        int j = A.length - 1;
        while (i < j) {
            while (i < j && A[i] % 2 == 0) {
                i ++;
            }

            while (i < j && A[j] % 2 == 1) {
                j --;
            }

            if (i < j) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }

        return A;
    }

    public static void main(String[] args) {
        Q00905_SortArrayByParity q = new Q00905_SortArrayByParity();
        int a[] = {3, 1, 2, 4};
        PrintUtil.printArray(a);
        q.sortArrayByParity(a);
        PrintUtil.printArray(a);
    }
}
