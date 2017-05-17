package dyd.leetcode.q026;

public class Q026_RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
    	if (nums.length < 2) {
    		return nums.length;
    	}
    	
    	int j = 0;
    	int i = 1;
        while (i < nums.length) {
        	if (nums[i] == nums[j]) {
        		i ++;
        	}
        	else {
        		nums[++j] = nums[i++];
        	}
        }
     
        return j + 1;
    }
    
    public static void main(String[] args) {
    	int[] nums = {1, 1, 2, 3, 3, 6};
    	Q026_RemoveDuplicatesFromSortedArray q = new Q026_RemoveDuplicatesFromSortedArray();
    	int len = q.removeDuplicates(nums);
    	for (int i = 0; i < len; i++) {
    		System.out.println(nums[i]);
    	}
    }
}
