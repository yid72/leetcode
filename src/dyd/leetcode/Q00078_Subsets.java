package dyd.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 78. Subsets --  Medium
 *
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Q00078_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        return subsets(nums, nums.length - 1);
    }

    private List<List<Integer>> subsets(int[] nums, int end) {
        List<List<Integer>> ret = new ArrayList<>();
        if (end < 0) {
            List<Integer> subset = new ArrayList<>();
            ret.add(subset);
            return ret;
        }

        List<List<Integer>> subSubsets = subsets(nums, end - 1);
        ret.addAll(subSubsets);

        for (List<Integer> subSubset : subSubsets) {
            List<Integer> newSubset = new ArrayList<>();
            newSubset.addAll(subSubset);
            newSubset.add(nums[end]);
            ret.add(newSubset);
        }

        return ret;
    }

    public static void main(String[] args) {
        test(new int[] {1, 2});
        test(new int[] {1, 2, 3});
    }

    private static void test(int[] nums) {
        System.out.println(Arrays.toString(nums));
        Q00078_Subsets q = new Q00078_Subsets();
        System.out.println(q.subsets(nums));
    }
}
