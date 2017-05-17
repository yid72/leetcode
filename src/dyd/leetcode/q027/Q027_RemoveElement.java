package dyd.leetcode.q027;

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
    
}
