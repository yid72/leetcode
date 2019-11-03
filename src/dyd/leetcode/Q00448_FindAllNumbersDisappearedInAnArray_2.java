package dyd.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q00448_FindAllNumbersDisappearedInAnArray_2 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = 0 - nums[index];
            }
        }

        List<Integer> missedNums = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                missedNums.add(i + 1);
            }
        }
        return missedNums;
    }

    public static void main(String[] args) {
        test(new int[] {4,3,2,7,8,2,3,1});
    }

    private static void test(int[] nums) {
        Q00448_FindAllNumbersDisappearedInAnArray_2 q = new Q00448_FindAllNumbersDisappearedInAnArray_2();
        System.out.println(Arrays.toString(nums) + ": " + q.findDisappearedNumbers(nums));
    }
}