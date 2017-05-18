package dyd.leetcode.q283;

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
public class Q283_MoveZeros {
    public void moveZeroes(int[] nums) {
    	if (nums.length <= 1) {
    		return;
    	}
    	
    	int maxNonZero = nums.length - 1;
    	while (maxNonZero >= 0 && nums[maxNonZero] == 0) {
    		maxNonZero --;
    	}
    	
    	int i = 0;
    	while (i < maxNonZero) {
    		if (nums[i] == 0) {
    			for (int j = i+1; j <= maxNonZero; j++) {
    				nums[j-1] = nums[j];
    				nums[j] = 0;
    			}
    			maxNonZero --;
    		}
    		else {
    			i ++;
    		}
    	}
    }
    
    public static void main(String[] args) {
    	Q283_MoveZeros q = new Q283_MoveZeros();
    	
    	int[] nums = {0, 1, 0, 3, 12};
    	q.moveZeroes(nums);
    	PrintUtil.printArray(nums);
    	
    	nums = new int[] {0, 0, 1};
    	q.moveZeroes(nums);
    	PrintUtil.printArray(nums);
    }
}
