package dyd.leetcode;

import java.util.Arrays;

/**
 * 1232. Check If It Is a Straight Line -- Easy
 *
 * You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.
 *
 * Example 1:
 *
 * Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * Output: true
 * Example 2:
 *
 * Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * Output: false
 *
 * Constraints:
 *
 * 2 <= coordinates.length <= 1000
 * coordinates[i].length == 2
 * -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
 * coordinates contains no duplicate point.
 */
public class Q01232_CheckIfItIsAStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        double k = computeK(coordinates[0], coordinates[1]);

        for (int i = 2; i < coordinates.length; i++) {
            if (k != computeK(coordinates[i - 1], coordinates[i])) {
                return false;
            }
        }

        return true;
    }

    private double computeK(int[] coordinate1, int[] coordinate2) {
        return (coordinate2[1] - coordinate1[1])*1.0/(coordinate2[0] - coordinate1[0]);
    }

    public static void main(String[] args) {
        test(new int[][] {
                {1, 1}, {2, 3}
        });

        test(new int[][] {
                {1,1}, {2, 2}
        });

        test(new int[][] {
                {1,1}, {2, 2}, {3, 3}
        });

        test(new int[][] {
                {1,1},{2,2},{3,4},{4,5},{5,6},{7,7}
        });

        test(new int[][] {
                {1,2},{2,3},{3,4},{4,5},{5,6},{6,7}
        });

        test(new int[][] {
                {-4,-3},{1,0},{3,-1},{0,-1},{-5,2}
        });
    }

    private static void test(int[][] coordinates) {
        System.out.println(Arrays.deepToString(coordinates));
        Q01232_CheckIfItIsAStraightLine q = new Q01232_CheckIfItIsAStraightLine();
        System.out.println(q.checkStraightLine(coordinates));
    }
}
