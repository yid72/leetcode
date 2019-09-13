package dyd.leetcode;

import dyd.leetcode.common.PrintUtil;

import java.util.*;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * Example:
 *
 * Input: [1,1,2]
 * Output:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 */
public class Q00047_PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> perms = new ArrayList<>();
        Map<String, List<Integer>> permMap = permute(nums, 0);
        for (List<Integer> permSet : permMap.values()) {
            perms.add(permSet);
        }
        return perms;
    }

    private Map<String, List<Integer>> permute(int[] nums, int pos) {
        Map<String, List<Integer>> perms = new HashMap();
        if (nums.length == 0) {
            return perms;
        }

        if (pos == nums.length - 1) {
            List<Integer> perm = new ArrayList<>();
            perm.add(nums[pos]);
            perms.put(makeKey(perm), perm);
            return perms;
        }

        Map<String, List<Integer>> subPerms = permute(nums, pos + 1);
        for (Map.Entry<String, List<Integer>> subPerm : subPerms.entrySet()) {
            for (int i = 0; i <= subPerm.getValue().size(); i++) {
                List<Integer> perm = new ArrayList<>();
                perm.addAll(subPerm.getValue());
                perm.add(i, nums[pos]);
                perms.put(makeKey(perm), perm);
            }
        }

        return perms;
    }

    private String makeKey(List<Integer> perm) {
        StringBuilder sb = new StringBuilder();
        for (Integer num : perm) {
            sb.append(num);
            sb.append("_");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        test(new int[] {});
        test(new int[] {1, 1, 2});
    }

    private static void test(int[] ints) {
        Q00047_PermutationsII permutations = new Q00047_PermutationsII();
        PrintUtil.printArray("Input", ints);
        List<List<Integer>> perms = permutations.permuteUnique(ints);
        System.out.println("Permutations (size=" + perms.size() + ")=");
        System.out.println(perms);
    }
}
