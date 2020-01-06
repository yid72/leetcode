package dyd.leetcode;

import java.util.Arrays;

/**
 * 518. Coin Change 2 -- Medium
 *
 * You are given coins of different denominations and a total amount of money. Write a function to compute the number of
 * combinations that make up that amount. You may assume that you have infinite number of each kind of coin.
 *
 * Example 1:
 *
 * Input: amount = 5, coins = [1, 2, 5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * Example 2:
 *
 * Input: amount = 3, coins = [2]
 * Output: 0
 * Explanation: the amount of 3 cannot be made up just with coins of 2.
 * Example 3:
 *
 * Input: amount = 10, coins = [10]
 * Output: 1
 *
 *
 * Note:
 *
 * You can assume that
 *
 * 0 <= amount <= 5000
 * 1 <= coin <= 5000
 * the number of coins is less than 500
 * the answer is guaranteed to fit into signed 32-bit integer
 */
public class Q00518_CoinChange2 {
    public int change(int amount, int[] coins) {
        return change(amount, coins, 0, new Integer[coins.length][amount]);
    }

    private int change(int amount, int[] coins, int start, Integer[][] dp) {
        if (amount <= 0 || start >= coins.length) {
            return 0;
        }

        if (dp[start][amount - 1] != null) {
            return dp[start][amount - 1];
        }

        int count = change(amount, coins, start + 1, dp);
        if (coins[start] == amount) {
            count ++;
        } else if (coins[start] < amount){
            count += change(amount - coins[start], coins, start + 1, dp);
        }

        dp[start][amount - 1] = count;
        return count;
    }

    public static void main(String[] args) {
        test(5, new int[] {1,2,5});
//        test(10, new int[] {10});
//        test(3, new int[] {2});
    }

    private static void test(int amount, int[] coins) {
        Q00518_CoinChange2 q = new Q00518_CoinChange2();
        System.out.printf("amount=%d, coins=%s: %d\n", amount, Arrays.toString(coins), q.change(amount, coins));
    }
}
