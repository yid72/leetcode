package dyd.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in
 * candidates where the candidate numbers sums to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */
public class Q00040_CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> sums = combinationSum2(candidates, 0, target);
        return unique(sums);
    }

    private List<List<Integer>> combinationSum2(int[] candidates, int pos, int target) {
        List<List<Integer>> sums = new ArrayList<>();
        if (pos > candidates.length - 1 || target <= 0) {
            return sums;
        }

        if (target == candidates[pos]) {
            List<Integer> subSums = new ArrayList<>();
            subSums.add(target);
            sums.add(subSums);
        } else if (target >= candidates[pos]) {
            List<List<Integer>> subSums = combinationSum2(candidates, pos + 1, target - candidates[pos]);
            for (List<Integer> subSum : subSums) {
                subSum.add(candidates[pos]);
                sums.add(subSum);
            }
        }

        List<List<Integer>> subSums = combinationSum2(candidates, pos + 1, target);
        sums.addAll(subSums);

        return sums;
    }

    private List<List<Integer>> unique(List<List<Integer>> sums) {
        Map<String, List<Integer>> map = new HashMap();
        for (List<Integer> sum : sums) {
            Collections.sort(sum);
            map.put(makeyKey(sum), sum);
        }
        return map.values().stream().collect(Collectors.toList());
    }

    private String makeyKey(List<Integer> nums) {
        StringBuilder sb = new StringBuilder();
        for (Integer num : nums) {
            sb.append(num);
            sb.append('_');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        test(new int[] {10,1,2,7,6,1,5}, 8);
        test(new int[] {2,5,2,1,2}, 5);
    }

    private static void test(int[] candidates, int target) {
        System.out.println(Arrays.toString(candidates) + ", target=" + target);
        Q00040_CombinationSum2 q = new Q00040_CombinationSum2();
        System.out.println(q.combinationSum2(candidates, target));
    }
}
