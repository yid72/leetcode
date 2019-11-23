package dyd.leetcode;

import java.util.Arrays;

/**
 * 836. Rectangle Overlap -- Easy
 *
 * A rectangle is represented as a list [x1, y1, x2, y2], where (x1, y1) are the coordinates of its bottom-left corner,
 * and (x2, y2) are the coordinates of its top-right corner.
 *
 * Two rectangles overlap if the area of their intersection is positive.  To be clear, two rectangles that only touch
 * at the corner or edges do not overlap.
 *
 * Given two (axis-aligned) rectangles, return whether they overlap.
 *
 * Example 1:
 *
 * Input: rec1 = [0,0,2,2], rec2 = [1,1,3,3]
 * Output: true
 * Example 2:
 *
 * Input: rec1 = [0,0,1,1], rec2 = [1,0,2,1]
 * Output: false
 * Notes:
 *
 * Both rectangles rec1 and rec2 are lists of 4 integers.
 * All coordinates in rectangles will be between -10^9 and 10^9.
 */
public class Q00836_RectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if (rec2[2] <= rec1[0] || rec2[0] >= rec1[2] || rec2[1] >= rec1[3] || rec2[3] <= rec1[1]) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        test(new int[] {0,0,2,2}, new int[] {1,1,3,3});
        test(new int[] {0,0,1,1}, new int[] {1,0,2,1});
    }

    private static void test(int[] rec1, int[] rec2) {
        System.out.println("rec1=" + Arrays.toString(rec1));
        System.out.println("rec2=" + Arrays.toString(rec2));
        Q00836_RectangleOverlap q = new Q00836_RectangleOverlap();
        System.out.println(q.isRectangleOverlap(rec1, rec2));
    }
}
