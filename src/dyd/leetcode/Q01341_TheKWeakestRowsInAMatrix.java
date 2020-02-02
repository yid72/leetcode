package dyd.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 1341. The K Weakest Rows in a Matrix -- Easy
 *
 * Given a m * n matrix mat of ones (representing soldiers) and zeros (representing civilians), return the indexes of
 * the k weakest rows in the matrix ordered from the weakest to the strongest.
 *
 * A row i is weaker than row j, if the number of soldiers in row i is less than the number of soldiers in row j, or
 * they have the same number of soldiers but i is less than j. Soldiers are always stand in the frontier of a row, that
 * is, always ones may appear first and then zeros.
 *
 * Example 1:
 *
 * Input: mat =
 * [[1,1,0,0,0],
 *  [1,1,1,1,0],
 *  [1,0,0,0,0],
 *  [1,1,0,0,0],
 *  [1,1,1,1,1]],
 * k = 3
 * Output: [2,0,3]
 * Explanation:
 * The number of soldiers for each row is:
 * row 0 -> 2
 * row 1 -> 4
 * row 2 -> 1
 * row 3 -> 2
 * row 4 -> 5
 * Rows ordered from the weakest to the strongest are [2,0,3,1,4]
 * Example 2:
 *
 * Input: mat =
 * [[1,0,0,0],
 *  [1,1,1,1],
 *  [1,0,0,0],
 *  [1,0,0,0]],
 * k = 2
 * Output: [0,2]
 * Explanation:
 * The number of soldiers for each row is:
 * row 0 -> 1
 * row 1 -> 4
 * row 2 -> 1
 * row 3 -> 1
 * Rows ordered from the weakest to the strongest are [0,2,3,1]
 *
 *
 * Constraints:
 *
 * m == mat.length
 * n == mat[i].length
 * 2 <= n, m <= 100
 * 1 <= k <= m
 * matrix[i][j] is either 0 or 1.
 */
public class Q01341_TheKWeakestRowsInAMatrix {
    static class Element implements Comparable<Element> {
        int index;
        int soldiers;

        Element(int index, int soldiers) {
            this.index = index;
            this.soldiers = soldiers;
        }

        public int compareTo(Element el) {
            if (this.soldiers < el.soldiers) {
                return -1;
            } else if (this.soldiers > el.soldiers) {
                return 1;
            } else if (index < el.index) {
                return -1;
            } else if (index > el.index) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Element> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < mat.length; i++) {
            q.add(sumSoldiers(i, mat[i]));
            if (q.size() > k) {
                q.poll();
            }
        }

        int[] ret = new int[q.size()];
        int i = ret.length - 1;
        while (q.size() > 0) {
            ret[i --] = q.poll().index;
        }
        return ret;
    }

    private Element sumSoldiers(int index, int[] row) {
        int sum = 0;
        for (int i = 0; i < row.length; i++) {
            sum += row[i];
        }
        return new Element(index, sum);
    }

    public static void main(String[] args) {
        test(new int[][] {{1,1,0,0,0},
                        {1,1,1,1,0},
                        {1,0,0,0,0},
                        {1,1,0,0,0},
                        {1,1,1,1,1}},
                3);
    }

    private static void test(int[][] mat, int k) {
        System.out.println("Matrix=");
        System.out.println(Arrays.deepToString(mat));
        System.out.println("k=" + k);
        Q01341_TheKWeakestRowsInAMatrix q = new Q01341_TheKWeakestRowsInAMatrix();
        System.out.println("The weakest: " + Arrays.toString(q.kWeakestRows(mat, k)));
    }
}
