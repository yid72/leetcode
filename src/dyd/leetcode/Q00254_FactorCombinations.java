package dyd.leetcode;

import java.util.*;

/**
 * 254. Factor Combinations -- Medium
 *
 * Numbers can be regarded as product of its factors. For example,
 *
 * 8 = 2 x 2 x 2;
 *   = 2 x 4.
 * Write a function that takes an integer n and return all possible combinations of its factors.
 *
 * Note:
 *
 * You may assume that n is always positive.
 * Factors should be greater than 1 and less than n.
 * Example 1:
 *
 * Input: 1
 * Output: []
 * Example 2:
 *
 * Input: 37
 * Output:[]
 * Example 3:
 *
 * Input: 12
 * Output:
 * [
 *   [2, 6],
 *   [2, 2, 3],
 *   [3, 4]
 * ]
 * Example 4:
 *
 * Input: 32
 * Output:
 * [
 *   [2, 16],
 *   [2, 2, 8],
 *   [2, 2, 2, 4],
 *   [2, 2, 2, 2, 2],
 *   [2, 4, 4],
 *   [4, 8]
 * ]
 */
public class Q00254_FactorCombinations {
    private Set<List<Integer>> res;

    public List<List<Integer>> getFactors(int n) {
        res = new HashSet<>();
        helper(n, new LinkedList<>());
        return new ArrayList<>(res);
    }

    private void helper(int n, LinkedList<Integer> factors) {
        if (n <= 1) {
            if (factors.size() > 1) {
                List<Integer> sortedFactors = new ArrayList<>(factors);
                Collections.sort(sortedFactors);
                res.add(sortedFactors);
            }
            return;
        }

        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                factors.add(i);
                helper(n / i, factors);
                factors.removeLast();
            }
        }
    }

    private static void test(int n) {
        Q00254_FactorCombinations q = new Q00254_FactorCombinations();
        List<List<Integer>> res = q.getFactors(n);
        System.out.printf("n=%d (%d): %s\n", n, res.size(), res);
    }

    public static void main(String[] args) {
        test(1);
        test(8);
        test(37);
        test(12);
        test(32);
    }
}
