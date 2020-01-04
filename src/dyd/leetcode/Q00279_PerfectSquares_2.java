package dyd.leetcode;

import java.util.Arrays;

public class Q00279_PerfectSquares_2 {
    public int numSquares(int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 1;

        int m = (int) Math.sqrt(n);
        int[] squares = new int[m];
        for (int i = 1; i <= m; i++) {
            squares[i - 1] = i * i;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                if (i < squares[j]) {
                    break;
                } else if (i == squares[j]) {
                    dp[i - 1] = 1;
                    break;
                } else {
                    dp[i - 1] = Math.min(dp[i - 1], dp[i - squares[j] - 1] + 1);
                }
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            test(i);
        }
    }

    private static void test(int n) {
        Q00279_PerfectSquares_2 q = new Q00279_PerfectSquares_2();
        System.out.printf("n=%d: %d\n", n, q.numSquares(n));
    }
}