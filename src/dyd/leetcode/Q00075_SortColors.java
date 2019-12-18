package dyd.leetcode;

import dyd.leetcode.common.PrintUtil;

/**
 * 75. Sort Colors
 *
 * Medium
 *
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note:
 *
 * You are not suppose to use the library's sort function for this problem.
 *
 * Example:
 *
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Follow up:
 *
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then
 * 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 *
 */
public class Q00075_SortColors {
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
    	Q00075_SortColors q = new Q00075_SortColors();
    	
    	int[] nums = new int[] {0, 1, 0, 2, 1, 0};
    	q.sortColors(nums);
    	PrintUtil.printArray(nums);
    }
}
