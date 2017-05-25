package dyd.leetcode.q027;

import dyd.leetcode.common.PrintUtil;

public class Q027_RemoveElement {
    public int removeElement(int[] nums, int val) {
        int j = 0;
        int i = 0;
        while (i < nums.length) {
        	if (nums[i] == val) {
        		i ++;
        	}
        	else {
        		nums[j ++] = nums[i ++]; 
        	}
        }
        return j;
    }
    
    public static void main(String[] args) {
    	Q027_RemoveElement q = new Q027_RemoveElement();
    	
    	int[] nums = new int[] {3, 2, 3, 2};
    	int len = q.removeElement(nums, 3);
    	PrintUtil.printArray(nums, 0, len);
    }
}
