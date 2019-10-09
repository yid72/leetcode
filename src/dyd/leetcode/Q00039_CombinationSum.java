package dyd.leetcode;

import java.util.*;

/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
public class Q00039_CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> sums = internalCombinationSum(candidates, target);

        Map<String, List<Integer>> map = new HashMap<>();
        for (List<Integer> sum : sums) {
            Collections.sort(sum);
            String key = makeKey(sum);
            if (!map.containsKey(key)) {
                map.put(key, sum);
            }
        }

        sums = new ArrayList<>();
        for (List<Integer> sum : map.values()) {
            sums.add(sum);
        }
        return sums;
    }

    private List<List<Integer>> internalCombinationSum(int[] candidates, int target) {
        List<List<Integer>> sums = new ArrayList<>();

        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] == target) {
                List<Integer> sum = new ArrayList<>();
                sum.add(candidates[i]);
                sums.add(sum);
            } else if (candidates[i] < target) {
                List<List<Integer>> subSums = internalCombinationSum(candidates, target - candidates[i]);
                for (List<Integer> sum: subSums) {
                    sum.add(candidates[i]);
                    sums.add(sum);
                }
            }
        }

        return sums;
    }

    private String makeKey(List<Integer> sum) {
        Collections.sort(sum);
        return sum.toString();
    }

    public static void main(String[] args) {
        test(new int[] {2,3,6,7}, 7);
        test(new int[] {2,3,5}, 8);
    }

    private static void test(int[] candidates, int target) {
        Q00039_CombinationSum q = new Q00039_CombinationSum();
        System.out.println("Candidates=" + Arrays.toString(candidates) + ", target=" + target);
        System.out.println(q.combinationSum(candidates, target));
    }

}
