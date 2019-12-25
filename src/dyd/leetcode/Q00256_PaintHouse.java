package dyd.leetcode;

import java.util.Arrays;

/**
 * There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of
 * painting each house with a certain color is different. You have to paint all the houses such that no two adjacent
 * houses have the same color.
 *
 * The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0]
 * is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so
 * on... Find the minimum cost to paint all houses.
 *
 * Note:
 * All costs are positive integers.
 *
 * Example:
 *
 * Input: [[17,2,17],[16,16,5],[14,3,19]]
 * Output: 10
 * Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.
 *              Minimum cost: 2 + 5 + 3 = 10.
 */
public class Q00256_PaintHouse {
    public int minCost(int[][] costs) {
        if (costs.length == 0 || costs[0].length == 0) {
            return 0;
        }

        int[] prevCosts = costs[0];
        int[] curCosts = costs[0];

        for (int i = 1; i < costs.length; i++) {
            curCosts = new int[3];
            curCosts[0] = costs[i][0] + Math.min(prevCosts[1], prevCosts[2]);
            curCosts[1] = costs[i][1] + Math.min(prevCosts[0], prevCosts[2]);
            curCosts[2] = costs[i][2] + Math.min(prevCosts[0], prevCosts[1]);

            prevCosts = curCosts;
        }

        return Math.min(Math.min(curCosts[0], curCosts[1]), curCosts[2]);
    }

    public static void main(String[] args) {
        test(new int[][] {
                {17,2,3},{16,16,5},{14,3,19}
        });
        test(new int[][] {
                {17,3,2},{16,16,5},{14,3,19}
        });
    }

    private static void test(int[][] costs) {
        Q00256_PaintHouse q = new Q00256_PaintHouse();
        System.out.printf("Costs=%s: %d\n", Arrays.deepToString(costs), q.minCost(costs));
    }
}
