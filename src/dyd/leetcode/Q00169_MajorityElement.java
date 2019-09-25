package dyd.leetcode;

import dyd.leetcode.common.PrintUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Example 1:
 *
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 */
public class Q00169_MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num: nums) {
            int count = counts.containsKey(num) ? counts.get(num) : 0;
            counts.put(num, count + 1);
        }
        int maxCount = 0;
        int majorityNum = 0;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (maxCount < entry.getValue()) {
                maxCount = entry.getValue();
                majorityNum = entry.getKey();
            }
        }
        return majorityNum;
    }

    public static void main(String[] args) {
        test(new int[] {3,2,3});
        test(new int[] {2,2,1,1,1,2,2});
    }

    private static void test(int[] nums) {
        Q00169_MajorityElement q = new Q00169_MajorityElement();
        PrintUtil.printArray(nums);
        System.out.println("Majority element: " + q.majorityElement(nums));
    }
}
