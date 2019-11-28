package dyd.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 986. Interval List Intersections -- Medium
 *
 * Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.
 *
 * Return the intersection of these two interval lists.
 *
 * (Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  The
 * intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a
 * closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)
 *
 * Example 1:
 *
 * Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
 * Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 * Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.
 *
 *
 * Note:
 *
 * 0 <= A.length < 1000
 * 0 <= B.length < 1000
 * 0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method
 * signature.
 */
public class Q00986_IntervalListIntersections {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if (A.length == 0 || B.length == 0) {
            return new int[][] {};
        }

        List<int[]> intersections = new ArrayList();

        int i = 0;
        int j = 0;
        while (i < A.length && j < B.length) {
            if (A[i][1] < B[j][0]) {
                i ++;
            } else if (A[i][0] > B[j][1]) {
                j ++;
            } else {
                int[] intersect = intersect(A[i], B[j]);
                intersections.add(intersect);
                if (A[i][1] > B[j][1]) {
                    j ++;
                } else {
                    i ++;
                }
            }
        }

        return list2Array(intersections);
    }

    private int[] intersect(int[] a, int[] b) {
        if (a[0] > b[0]) {
            int[] temp = a;
            a = b;
            b = temp;
        }

        if (a[1] <= b[1]) {
            return new int[] {b[0], a[1]};
        } else {
            return new int[] {b[0], b[1]};
        }
    }

    private int[][] list2Array(List<int[]> list) {
        int[][] ret = new int[list.size()][2];
        for (int i = 0; i < ret.length; i ++) {
            ret[i] = list.get(i);
        }
        return ret;
    }

    public static void main(String[] args) {
        test(
                new int[][] {
                        {0,2},{5,10},{13,23},{24,25}
                },
                new int[][] {
                        {1,5},{8,12},{15,24},{25,26}
                });
    }

    private static void test(int[][] A, int[][] B) {
        System.out.println("A=" + Arrays.deepToString(A));
        System.out.println("B=" + Arrays.deepToString(B));
        Q00986_IntervalListIntersections q = new Q00986_IntervalListIntersections();
        System.out.println(Arrays.deepToString(q.intervalIntersection(A, B)));
    }
}
