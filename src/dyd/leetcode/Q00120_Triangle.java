package dyd.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the
 * row below.
 *
 * For example, given the following triangle
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 * Note:
 *
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the
 * triangle.
 */
public class Q00120_Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0 || triangle.get(0).size() == 0) {
            return 0;
        }

        int[] mins = new int[1];
        mins[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            mins = minimumTotal(triangle.get(i), mins);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < mins.length; i++) {
            min = Math.min(min, mins[i]);
        }
        return min;
    }

    private int[] minimumTotal(List<Integer> level, int[] prevMins) {
        int[] mins = new int[level.size()];
        mins[0] = prevMins[0] + level.get(0);
        for (int i = 1; i < mins.length; i++) {
            if (i == mins.length - 1) {
                mins[i] = prevMins[i - 1] + level.get(i);
            } else {
                mins[i] = Math.min(prevMins[i - 1], prevMins[i]) + level.get(i);
            }
        }
        return mins;
    }

    public static void main(String[] args) {
        test(data1());
        test(data2());
    }

    private static List<Integer[]> data1() {
        List<Integer[]> triangle = new ArrayList<>();
        triangle.add(new Integer[] {});
        return triangle;
    }

    private static List<Integer[]> data2() {
        List<Integer[]> triangle = new ArrayList<>();
        triangle.add(new Integer[] {2});
        triangle.add(new Integer[] {3, 4});
        triangle.add(new Integer[] {6, 5, 7});
        triangle.add(new Integer[] {4, 1, 8, 3});
        return triangle;
    }

    private static void test(List<Integer[]> triangle) {
        List<List<Integer>> newTriangle = new ArrayList<>();
        for (int i = 0; i < triangle.size(); i++) {
            newTriangle.add(Arrays.asList(triangle.get(i)));
        }

        System.out.println(newTriangle);

        Q00120_Triangle q = new Q00120_Triangle();
        System.out.println("min=" + q.minimumTotal(newTriangle));
    }
}
