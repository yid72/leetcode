package dyd.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 229. Majority Element II -- Medium
 *
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 *
 * Note: The algorithm should run in linear time and in O(1) space.
 *
 * Example 1:
 *
 * Input: [3,2,3]
 * Output: [3]
 * Example 2:
 *
 * Input: [1,1,1,3,3,2,2,2]
 * Output: [1,2]
 */
public class Q00229_MajorityElement2 {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0;
        Integer candidate1 = null;
        int count2 = 0;
        Integer candidate2 = null;

        for (int num : nums) {
            if (count1 == 0 && (candidate2 == null || candidate2 != num)) {
                candidate1 = num;
            } else if (count2 == 0 && (candidate1 == null || candidate1 != num)) {
                candidate2 = num;
            }

            if (candidate1 != null && candidate1 == num) {
                count1 ++;
            } else if (candidate2 != null && candidate2 == num) {
                count2 ++;
            } else {
                if (count1 > 0) {
                    count1 --;
                }

                if (count2 > 0) {
                    count2 --;
                }
            }
        }

        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (candidate1 != null && num == candidate1) {
                count1 ++;
            }

            if (candidate2 != null && num == candidate2) {
                count2 ++;
            }
        }

        List<Integer> res = new ArrayList<>();
        if (count1 > nums.length/3) {
            res.add(candidate1);
        }
        if (count2 > nums.length/3) {
            res.add(candidate2);
        }
        return res;
    }

    public static void main(String[] args) {
        test(new int[] {1,2,3,4});
        test(new int[] {3,2,3});
        test(new int[] {1,1,1,3,3,2,2,2});
        test(new int[] {2,2});
        test(new int[] {0,-1,2,-1});
    }

    private static void test(int[] nums) {
        Q00229_MajorityElement2 q = new Q00229_MajorityElement2();
        System.out.println(Arrays.toString(nums) + ": " + q.majorityElement(nums));
    }
}
