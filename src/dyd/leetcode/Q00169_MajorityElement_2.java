package dyd.leetcode;

import dyd.leetcode.common.PrintUtil;

public class Q00169_MajorityElement_2 {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer majority = null;
        for (int i = 0; i < nums.length; i ++) {
            if (count == 0) {
                majority = nums[i];
            }

            count += (nums[i] == majority) ? 1 : -1;
        }
        return (majority != null) ? majority : 0;
    }

    public static void main(String[] args) {
        test(new int[] {3,2,3});
        test(new int[] {2,2,1,1,1,2,2});
    }

    private static void test(int[] nums) {
        Q00169_MajorityElement_2 q = new Q00169_MajorityElement_2();
        PrintUtil.printArray(nums);
        System.out.println("Majority element: " + q.majorityElement(nums));
    }

}