package dyd.leetcode;

import java.util.*;

public class Q00040_CombinationSum2_Backtrack {
    private Set<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new HashSet<>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, new LinkedList<>());
        return new ArrayList<>(res);
    }

    private void helper(int[] candidates, int target, int start, LinkedList<Integer> curr) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        } else if (start >= candidates.length || target < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            curr.add(candidates[i]);
            helper(candidates, target - candidates[i], i + 1, curr);
            curr.removeLast();
        }
    }

    private static void test(int[] candidates, int target) {
        System.out.println("candidates=" + Arrays.toString(candidates) + ", target=" + target);
        Q00040_CombinationSum2_Backtrack q = new Q00040_CombinationSum2_Backtrack();
        System.out.println(q.combinationSum2(candidates, target));
    }

    public static void main(String[] args) {
        test(new int[] {10,1,2,7,6,1,5}, 8);
    }
}