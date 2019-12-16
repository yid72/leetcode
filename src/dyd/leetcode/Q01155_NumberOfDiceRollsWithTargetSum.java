package dyd.leetcode;

/**
 * 1155. Number of Dice Rolls With Target Sum -- Medium
 *
 * You have d dice, and each die has f faces numbered 1, 2, ..., f.
 *
 * Return the number of possible ways (out of fd total ways) modulo 10^9 + 7 to roll the dice so the sum of the face up numbers equals target.
 *
 * Example 1:
 *
 * Input: d = 1, f = 6, target = 3
 * Output: 1
 * Explanation:
 * You throw one die with 6 faces.  There is only one way to get a sum of 3.
 * Example 2:
 *
 * Input: d = 2, f = 6, target = 7
 * Output: 6
 * Explanation:
 * You throw two dice, each with 6 faces.  There are 6 ways to get a sum of 7:
 * 1+6, 2+5, 3+4, 4+3, 5+2, 6+1.
 * Example 3:
 *
 * Input: d = 2, f = 5, target = 10
 * Output: 1
 * Explanation:
 * You throw two dice, each with 5 faces.  There is only one way to get a sum of 10: 5+5.
 * Example 4:
 *
 * Input: d = 1, f = 2, target = 3
 * Output: 0
 * Explanation:
 * You throw one die with 2 faces.  There is no way to get a sum of 3.
 * Example 5:
 *
 * Input: d = 30, f = 30, target = 500
 * Output: 222616187
 * Explanation:
 * The answer must be returned modulo 10^9 + 7.
 */
public class Q01155_NumberOfDiceRollsWithTargetSum {
    private static final int MOD = 1000000000 + 7;

    private int[][] dp;

    public int numRollsToTarget(int d, int f, int target) {
        dp = new int[d][target];
        return helper(d, f, target);
    }

    private int helper(int d, int f, int target) {
        if (target <= 0 || target > d*f) {
            return 0;
        } else if (d == 1 && target <= f) {
            return 1;
        }

        if (dp[d - 1][target - 1] != 0) {
            return dp[d - 1][target - 1];
        }

        long num = 0;
        for (int i = 1; i <= f; i++) {
            num += helper(d - 1, f, target - i);
        }
        if (num > MOD) {
            num %= MOD;
        }
        dp[d - 1][target - 1] = (int) num;
        return (int) num;
    }

    public static void main(String[] args) {
        test(1, 6, 3);
        test(2, 6, 7);
        test(2, 5, 10);
        test(1, 2, 3);
        test(30, 30, 500);
    }

    private static void test(int d, int f, int target) {
        Q01155_NumberOfDiceRollsWithTargetSum q = new Q01155_NumberOfDiceRollsWithTargetSum();
        System.out.printf("d=%d, f=%d, target=%d: %d\n", d, f, target, q.numRollsToTarget(d, f, target));
    }
}
