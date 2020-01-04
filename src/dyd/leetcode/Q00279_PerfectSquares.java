package dyd.leetcode;

/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...)
 * which sum to n.
 *
 * Example 1:
 *
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 *
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */
public class Q00279_PerfectSquares {
    public int numSquares(int n) {
        if (n == 1) {
            return 1;
        }

        int m = (int) Math.sqrt(n);
        return numSquares(m, n, new int[n]);
    }

    private int numSquares(int m, int n, int[] dp) {
        if (n == m*m) {
            return 1;
        }

        if (dp[n - 1] > 0) {
            return dp[n - 1];
        }

        int min = Integer.MAX_VALUE;
        for (int i = m; i >= 1; i--) {
            int square = i*i;
            if (square == n) {
                min = 1;
                break;
            } else if (square < n) {
                min = Math.min(min, numSquares(m, n - square, dp) + 1);
            }
        }

        dp[n - 1] = min;
        return dp[ n - 1];
    }

    public static void main(String[] args) {
        test(3);
        test(4);
        test(5);
        test(12);
        test(13);
    }

    private static void test(int n) {
        Q00279_PerfectSquares q = new Q00279_PerfectSquares();
        System.out.printf("n=%d: %d\n", n, q.numSquares(n));
    }
}
