package dyd.leetcode;

import java.util.Arrays;

/**
 * 322. Coin Change -- Medium
 *
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the
 * fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any
 * combination of the coins, return -1.
 *
 * Example 1:
 *
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 */
public class Q0322_CoinChange {
    public int coinChange(int[] coins, int amount) {
        return coinChange(coins, amount, new Integer[amount]);
    }

    public int coinChange(int[] coins, int amount, Integer[] dp) {
        if (amount == 0) {
            return 0;
        }

        if (dp[amount - 1] != null) {
            return dp[amount - 1];
        }

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (coin < amount) {
                int count = coinChange(coins, amount - coin, dp);
                if (count != -1) {
                    min = Math.min(min, count + 1);
                }
            } else if (coin == amount) {
                min = Math.min(min, 1);
            }
        }
        dp[amount - 1] = min < Integer.MAX_VALUE ? min : -1;
        return dp[amount - 1];
    }

    public static void main(String[] args) {
//        test(new int[] {1, 2, 5}, 11);
//        test(new int[] {2}, 3);
//        test(new int[] {1}, 0);
        test(new int[] {1,2,5}, 100);
    }

    private static void test(int[] coins, int amount) {
        Q0322_CoinChange q = new Q0322_CoinChange();
        System.out.printf("coins=%s, amount=%d: %d\n", Arrays.toString(coins), amount, q.coinChange(coins, amount));
    }
}
