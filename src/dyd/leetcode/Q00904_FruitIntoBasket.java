package dyd.leetcode;

import java.util.Arrays;

/**
 * 904. Fruit Into Baskets -- Medium
 *
 * In a row of trees, the i-th tree produces fruit with type tree[i].
 *
 * You start at any tree of your choice, then repeatedly perform the following steps:
 *
 * Add one piece of fruit from this tree to your baskets.  If you cannot, stop.
 * Move to the next tree to the right of the current tree.  If there is no tree to the right, stop.
 * Note that you do not have any choice after the initial choice of starting tree: you must perform step 1, then step 2, then back to step 1, then step 2, and so on until you stop.
 *
 * You have two baskets, and each basket can carry any quantity of fruit, but you want each basket to only carry one type of fruit each.
 *
 * What is the total amount of fruit you can collect with this procedure?
 *
 * Example 1:
 *
 * Input: [1,2,1]
 * Output: 3
 * Explanation: We can collect [1,2,1].
 * Example 2:
 *
 * Input: [0,1,2,2]
 * Output: 3
 * Explanation: We can collect [1,2,2].
 * If we started at the first tree, we would only collect [0, 1].
 * Example 3:
 *
 * Input: [1,2,3,2,2]
 * Output: 4
 * Explanation: We can collect [2,3,2,2].
 * If we started at the first tree, we would only collect [1, 2].
 * Example 4:
 *
 * Input: [3,3,3,1,2,1,1,2,3,3,4]
 * Output: 5
 * Explanation: We can collect [1,2,1,1,2].
 * If we started at the first tree or the eighth tree, we would only collect 4 fruits.
 *
 *
 * Note:
 *
 * 1 <= tree.length <= 40000
 * 0 <= tree[i] < tree.length
 */
public class Q00904_FruitIntoBasket {
    public int totalFruit(int[] tree) {
        if (tree.length <= 2) {
            return tree.length;
        }

        int type0 = tree[0];
        int recentType0 = 0;
        int type1 = 0;
        int recentType1 = -1;
        if (tree[1] != type0) {
            type1 = tree[1];
            recentType1 = 1;
        } else {
            recentType0 = 1;
        }
        int total = 2;
        int maxTotal = total;
        for (int i = 2; i < tree.length; i ++) {
            if (tree[i] == type0) {
                recentType0 = i;
                total ++;
            } else if (recentType1 == -1) {
                type1 = tree[i];
                recentType1 = i;
                total ++;
            } else if (tree[i] == type1) {
                recentType1 = i;
                total ++;
            } else if (recentType0 < recentType1) {
                total = i - recentType0;
                type0 = tree[i];
                recentType0 = i;
            } else {
                total = i - recentType1;
                type1 = tree[i];
                recentType1 = i;
            }
            maxTotal = Math.max(maxTotal, total);
        }

        return maxTotal;
    }

    public static void main(String[] args) {
        test(new int[] {1, 2, 1});
        test(new int[] {0,1,2,2});
        test(new int[] {1,2,3,2,2});
        test(new int[] {3,3,3,1,2,1,1,2,3,3,4});
        test(new int[] {0,0,1,1});
        test(new int[] {1,1,4,0,4});
    }

    private static void test(int[] tree) {
        Q00904_FruitIntoBasket q = new Q00904_FruitIntoBasket();
        System.out.println("tree=" + Arrays.toString(tree) + ": " + q.totalFruit(tree));
    }
}
