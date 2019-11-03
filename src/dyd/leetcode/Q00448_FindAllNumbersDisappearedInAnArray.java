package dyd.leetcode;

import java.util.*;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 *
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 *
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra
 * space.
 *
 * Example:
 *
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [5,6]
 */
public class Q00448_FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> foundNums = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            foundNums.add(nums[i]);
        }

        List<Integer> missedNums = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (!foundNums.contains(i)) {
                missedNums.add(i);
            }
        }

        return missedNums;
    }

    public static void main(String[] args) {
        test(new int[] {4,3,2,7,8,2,3,1});
    }

    private static void test(int[] nums) {
        Q00448_FindAllNumbersDisappearedInAnArray q = new Q00448_FindAllNumbersDisappearedInAnArray();
        System.out.println(Arrays.toString(nums) + ": " + q.findDisappearedNumbers(nums));
    }
}
