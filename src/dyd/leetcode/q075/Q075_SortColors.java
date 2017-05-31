package dyd.leetcode.q075;

import dyd.leetcode.common.PrintUtil;

/**
 *

Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

 * @author dyd
 *
 */
public class Q075_SortColors {
	private static int COLOR_COUNT = 3;
    public void sortColors(int[] nums) {
        int[] count = new int[COLOR_COUNT];
        for (int i = 0; i < nums.length; i++) {
        	count[nums[i]] ++;
        }
        
        int pos = 0;
        for (int i = 0; i < count.length; i++) {
        	for (int j = 0; j < count[i]; j++) {
        		nums[pos ++] = i;
        	}
        }
    }
    
    public static void main(String[] args) {
    	Q075_SortColors q = new Q075_SortColors();
    	
    	int[] nums = new int[] {0, 1, 0, 2, 1, 0};
    	q.sortColors(nums);
    	PrintUtil.printArray(nums);
    }
}
