package dyd.leetcode;

import dyd.leetcode.common.PrintUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 *
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Q00046_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        return permute(nums, 0);
    }

    private List<List<Integer>> permute(int[] nums, int pos) {
        List<List<Integer>> perms = new ArrayList<>();
        if (nums.length == 0) {
            return perms;
        }

        if (pos == nums.length - 1) {
            List<Integer> perm = new ArrayList<>();
            perm.add(nums[pos]);
            perms.add(perm);
            return perms;
        }

        List<List<Integer>> subPerms = permute(nums, pos + 1);
        for (List<Integer> subPerm : subPerms) {
            for (int i = 0; i <= subPerm.size(); i++) {
                ArrayList<Integer> perm = new ArrayList<>();
                perm.addAll(subPerm);
                perm.add(i, nums[pos]);
                perms.add(perm);
            }
        }

        return perms;
    }

    public static void main(String[] args) {
        test(new int[] {});
        test(new int[] {1, 2,});
        test(new int[] {1, 2, 3});
        test(new int[] {1, 2, 3, 4});
    }

    private static void test(int[] ints) {
        Q00046_Permutations permutations = new Q00046_Permutations();
        PrintUtil.printArray("Input", ints);
        List<List<Integer>> perms = permutations.permute(ints);
        System.out.println("Permutations (size=" + perms.size() + ")=");
        System.out.println(perms);
    }
}
