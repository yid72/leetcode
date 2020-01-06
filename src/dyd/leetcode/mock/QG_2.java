package dyd.leetcode.mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QG_2 {
    public int kEmptySlots(int[] bulbs, int K) {
        int[] status = new int[bulbs.length];
        for (int i = 0; i < bulbs.length; i++) {
            status[bulbs[i] - 1] = 1;
            if (checkKOff(status, K)) {
                return i + 1;
            }
        }
        return -1;
    }

    private boolean checkKOff(int[] status, int K) {
        return false;
    }

    private List<Integer> getZeroCounts(int[] status) {
        List<Integer> zeroCounts = new ArrayList<>();

        int start = -1;
        int end = 0;
        while (start < status.length && end < status.length) {
            while (++ start < status.length && status[start] == 1);

            end = start;
            while (++ end < status.length && status[end] == 0);

            if (end < status.length) {
                return null;
            }

            start = end;
        }

        return null;

    }

    public static void main(String[] args) {
 //       test(new int[] {1, 3, 2}, 1);
        test(new int[] {3,9,2,8,1,6,10,5,4,7}, 1);
    }

    private static void test(int[] bulbs, int K) {
        System.out.println(Arrays.toString(bulbs) + ", k=" + K);
        QG_2 q = new QG_2();
        System.out.println(q.kEmptySlots(bulbs, K));
    }
}
