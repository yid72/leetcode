package dyd.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 90. Subsets II -- Medium
 *
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: [1,2,2]
 * Output:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 */
public class Q00090_SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        HashMap<String, List<Integer>> map = subsetsWithDup(nums, nums.length - 1);
        return map.values().stream().collect(Collectors.toList());
    }

    private HashMap<String, List<Integer>> subsetsWithDup(int[] nums, int end) {
        HashMap<String, List<Integer>> ret = new HashMap<>();
        if (end < 0) {
            List<Integer> subset = new ArrayList<>();
            ret.put("e", subset);
            return ret;
        }

        HashMap<String, List<Integer>> subSubsets = subsetsWithDup(nums, end - 1);
        ret.putAll(subSubsets);

        for (Map.Entry<String, List<Integer>> entry : subSubsets.entrySet()) {
            String newKey = String.join("_", entry.getKey(), Integer.toString(nums[end]));
            List<Integer> newSet = new ArrayList<>();
            newSet.addAll(entry.getValue());
            newSet.add(nums[end]);
            ret.put(newKey, newSet);
        }

        return ret;
    }

    public static void main(String[] args) {
        test(new int[] {1, 2, 3});
        test(new int[] {1, 2, 2});
    }

    private static void test(int[] nums) {
        System.out.println(Arrays.toString(nums));
        Q00090_SubsetsII q = new Q00090_SubsetsII();
        System.out.println(q.subsetsWithDup(nums));
    }
}
