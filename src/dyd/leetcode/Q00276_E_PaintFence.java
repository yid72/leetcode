package dyd.leetcode;

import java.util.Arrays;

/**
 * There is a fence with n posts, each post can be painted with one of the k colors.
 *
 * You have to paint all the posts such that no more than two adjacent fence posts have the same color.
 *
 * Return the total number of ways you can paint the fence.
 *
 * Note:
 * n and k are non-negative integers.
 *
 * Example:
 *
 * Input: n = 3, k = 2
 * Output: 6
 * Explanation: Take c1 as color 1, c2 as color 2. All possible ways are:
 *
 *             post1  post2  post3
 *  -----      -----  -----  -----
 *    1         c1     c1     c2
 *    2         c1     c2     c1
 *    3         c1     c2     c2
 *    4         c2     c1     c1
 *    5         c2     c1     c2
 *    6         c2     c2     c1
 */
public class Q00276_E_PaintFence {
    public int numWays(int n, int k) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return k;
        } else if (n == 2) {
            return k *(k - 1);
        }

        int[] numWays = new int[n];
        Arrays.fill(numWays, -1);

        if (numWays[n - 1] != -1) {
            return numWays[n - 1];
        }

        numWays[n - 1] = numWays(n - 1, k)*(k - 1) + numWays(n - 2, k)*k;
        return numWays[n - 1];
    }

    public static void main(String[] args) {
        test(2, 1);
 //       test(3, 2);
    }

    private static void test(int n, int k) {
        Q00276_E_PaintFence q = new Q00276_E_PaintFence();
        System.out.printf("n=%d, k=%d: %d\n", n, k, q.numWays(n, k));
    }
}
