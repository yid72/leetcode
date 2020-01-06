package dyd.leetcode.mock;

import java.util.Arrays;

/**
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 *
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 *
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
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
public class QA_1 {
    public int[][] kClosest(int[][] points, int K) {
        if (K > points.length || points.length == 0 || K < 1) {
            return new int[][] {{}};
        } else if (K == points.length) {
            return points;
        }

        kClosest(points, K, 0, points.length - 1);
        int[][] ret = new int[K][2];
        for (int i = 0; i < K; i++) {
            ret[i] = points[i];
        }

        return ret;
    }

    private void kClosest(int[][] points, int K, int lo, int hi) {
        int pivot = partition(points, lo, hi);
        int leftSize = pivot - lo + 1;
        if (leftSize == K) {
            return;
        } else if (leftSize < K) {
            kClosest(points, K - leftSize, pivot + 1, hi);
        } else {
            kClosest(points, K, lo, pivot - 1);
        }
    }

    private int partition(int[][] points, int lo, int hi) {
        int i = lo;
        int j = hi;
        int pivot = dist(points[i ++]);
        while (i <= j) {
            while (i <= hi && dist(points[i]) < pivot) {
                i ++;
            }

            while (j >= i && dist(points[j]) >= pivot) {
                j --;
            }

            if (i < j) {
                swap(points, i, j);
            }
        }
        swap(points, lo, i);
        return i;
    }

    private int dist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    private void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }

    public static void main(String[] args) {
        test(new int[][] {
                {1, 3}, {-2, 2}
        }, 1);
    }

    private static void test(int[][] points, int K) {
        System.out.println(Arrays.deepToString(points) + ", K=" + K);
        QA_1 q = new QA_1();
        System.out.println(Arrays.deepToString(q.kClosest(points, K)));
    }
}
