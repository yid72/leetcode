package dyd.leetcode;

import dyd.leetcode.Q00973_KClosestPointsToOrigin_1.Point;
import dyd.leetcode.common.PrintUtil;

import java.util.ArrayList;
import java.util.List;

public class Q00973_KClosestPointsToOrigin_2 {
    public int[][] kClosest(int[][] points, int K) {
        if (K >= points.length) {
            return points;
        }

        Point[] pointObjs = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
            pointObjs[i] = new Point(points[i][0], points[i][1]);
        }

        List<int[]> results = new ArrayList<>();
        kClosest(results, pointObjs, 0, pointObjs.length-1, K);
        return results.toArray(new int[results.size()][]);
    }

    private void kClosest(List<int[]> results, Point[] points, int lo, int hi, int K) {
        if (K < 1) {
            return;
        }

        int j = partition(points, lo, hi);
        if (j < K) {
            for (int i = 0; i <= j; i++) {
                results.add(new int[] {points[i].x, points[i].y});
            }

            kClosest(results, points, j+1, hi, K-j-1);
        } else {
            kClosest(results, points, lo, j-1, K);
        }
    }

    private int partition(Point[] points, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (i < points.length-1 && points[++i].compareTo(points[lo]) == -1) {
                if (i == hi) break;
            }

            while (j > 0 && points[lo].compareTo(points[--j]) == -1) {
                if (j == lo) break;
            }

            if (i >= j) {
                break;
            }
            swap(points, i, j);
        }

        swap(points, lo, j);
        return j;
    }

    private void swap(Point[] points, int i, int j) {
        Point temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }

    public static void main(String[] args) {
        Q00973_KClosestPointsToOrigin_2 q = new Q00973_KClosestPointsToOrigin_2();

        int[][] points1 = new int[][] {
                {1, 3},
                {-2, 2}
        };
        int K1 = 1;
        PrintUtil.printArray(q.kClosest(points1, K1));

        int[][] points2 = new int[][] {
                {3, 3},
                {5, -1},
                {-2, 4}
        };
        int K2 = 2;
        System.out.println();
        PrintUtil.printArray(q.kClosest(points2, K2));

        int[][] points3 = new int[][]{
                {-5, 4}, {-3, 2}, {0, 1}, {-3, 7}, {-2, 0}, {-4, -6}, {0, -5}
        };
        int K3 = 6;
        System.out.println();
        PrintUtil.printArray(q.kClosest(points3, K3));
    }
}