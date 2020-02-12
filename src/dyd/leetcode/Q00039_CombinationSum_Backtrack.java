package dyd.leetcode;

import java.util.*;

public class Q00039_CombinationSum_Backtrack {
    private Set<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new HashSet<>();
        helper(candidates, target, new LinkedList<>());
        return new ArrayList<>(res);
    }

    private void helper(int[] candidates, int target, LinkedList<Integer> curr) {
        if (target == 0) {
            List<Integer> newCurr = new ArrayList<>(curr);
            Collections.sort(newCurr);
            res.add(newCurr);
            return;
        } else if (target < 0) {
            return;
        }

        for (int i = 0; i < candidates.length; i++) {
            curr.add(candidates[i]);
            helper(candidates, target - candidates[i], curr);
            curr.removeLast();
        }
    }

    public static void main(String[] args) {
        test(new int[] {2,3,6,7}, 7);
        test(new int[] {2,3,5}, 8);
    }

    private static void test(int[] candidates, int target) {
        Q00039_CombinationSum_Backtrack q = new Q00039_CombinationSum_Backtrack();
        System.out.printf("candidates=%s, target=%d\n", Arrays.toString(candidates), target);
        System.out.println(q.combinationSum(candidates, target));
    }
}