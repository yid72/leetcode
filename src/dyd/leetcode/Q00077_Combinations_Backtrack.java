package dyd.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q00077_Combinations_Backtrack {
    private List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        helper(n, k, 1, new LinkedList<>());
        return res;
    }

    private void helper(int n, int k, int start, LinkedList<Integer> curr) {
        if (curr.size() == k) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i <= n; i ++) {
            curr.add(i);
            helper(n, k, i + 1, curr);
            curr.removeLast();
        }
    }

    private static void test(int n, int k) {
        System.out.printf("n=%d, k=%d\n", n, k);
        Q00077_Combinations_Backtrack q = new Q00077_Combinations_Backtrack();
        List<List<Integer>> res = q.combine(n, k);
        System.out.printf("Combinations (%d): %s\n", res.size(), res);
    }

    public static void main(String[] args) {
        test(4, 2);
    }
}