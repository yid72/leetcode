package dyd.leetcode;

import dyd.leetcode.common.PrintUtil;

/**
 *
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * 
 * @author dyd
 */
public class Q00283_MoveZeros {
    public void moveZeroes(int[] nums) {
    	if (nums.length <= 1) {
    		return;
    	}
    	
    	int j = 0;
    	for (int i = 0; i < nums.length; i++) {
    		if (nums[i] != 0) {
				nums[j++] = nums[i];
			}
		}

    	for (; j < nums.length; j++) {
    		nums[j] = 0;
		}
    }
    
    public static void main(String[] args) {
    	Q00283_MoveZeros q = new Q00283_MoveZeros();
    	
    	int[] nums = {0, 1, 0, 3, 12};
    	q.moveZeroes(nums);
    	PrintUtil.printArray(nums);
    	
    	nums = new int[] {0, 0, 1};
    	q.moveZeroes(nums);
    	PrintUtil.printArray(nums);
    }
}
