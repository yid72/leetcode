package dyd.leetcode;

import dyd.leetcode.common.PrintUtil;

import java.util.Arrays;

/**
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 *
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 *
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 *
 *
 *
 * Example 1:
 *
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 * Example 2:
 *
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * Output: [[3,3],[-2,4]]
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 */
public class Q00973_KClosestPointsToOrigin_1 {
    static class Point implements Comparable<Point> {
        public int x;
        public int y;
        private int distance2;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            distance2 = x*x + y*y;
        }

        public int compareTo(Point o) {
            if (this.distance2 < o.distance2) {
                return -1;
            } else if (this.distance2 > o.distance2) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public int[][] kClosest(int[][] points, int K) {
        if (K >= points.length) {
            return points;
        }

        Point[] pointObjs = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
            pointObjs[i] = new Point(points[i][0], points[i][1]);
        }

        Arrays.sort(pointObjs);

        int[][] results = new int[K][2];
        for (int i = 0; i < K; i++) {
            results[i][0] = pointObjs[i].x;
            results[i][1] = pointObjs[i].y;
        }
        return results;
    }

    public static void main(String[] args) {
        Q00973_KClosestPointsToOrigin_1 q = new Q00973_KClosestPointsToOrigin_1();

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
    }
}
