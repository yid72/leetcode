package dyd.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. Combination Sum III -- Medium
 *
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be
 * used and each combination should be a unique set of numbers.
 *
 * Note:
 *
 * All numbers will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Example 2:
 *
 * Input: k = 3, n = 9
 * Output: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class Q00216_CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        return helper(1, k, n);
    }

    private List<List<Integer>> helper(int start, int k, int n) {
        List<List<Integer>> res = new ArrayList();
        if (k <= 0 || n < start || start > 9) {
            return res;
        } else if (k == 1 && n == start) {
            List<Integer> comb = new ArrayList<>();
            comb.add(n);
            res.add(comb);
            return res;
        }

        List<List<Integer>> subComb1 = helper(start + 1, k, n);
        res.addAll(subComb1);

        List<List<Integer>> subComb2 = helper(start + 1, k - 1, n - start);
        for (List<Integer> comb : subComb2) {
            comb.add(start);
            res.add(comb);
        }
        return res;
    }

    public static void main(String[] args) {
        test(3, 7);
        test(3, 9);
    }

    private static void test(int k, int n) {
        Q00216_CombinationSum3 q = new Q00216_CombinationSum3();
        System.out.printf("k=%d, n=%d: %s\n", k, n, q.combinationSum3(k, n));
    }
}
