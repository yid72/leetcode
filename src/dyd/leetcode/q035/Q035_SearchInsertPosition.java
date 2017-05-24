package dyd.leetcode.q035;

public class Q035_SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
    	if (nums.length == 0) {
    		return 0;
    	}
    	
    	int low = 0;
    	int high = nums.length - 1;
    	int mid;
    	while (low <= high) {
    		mid = (low + high)/2;
    		if (nums[mid] > target) {
    			high = mid - 1;
    		}
    		else if (nums[mid] < target) {
    			low = mid + 1;
    		}
    		else {
    			return mid;
    		}
    	}
    	
    	return low;
    }
    
    public static void main(String[] args) {
    	Q035_SearchInsertPosition q = new Q035_SearchInsertPosition();
    	
    	int[] nums = new int[] {1, 3, 5, 6};
    	System.out.println(q.searchInsert(nums, 5));
       	System.out.println(q.searchInsert(nums, 2));
       	System.out.println(q.searchInsert(nums, 7));
        System.out.println(q.searchInsert(nums, 0));
    }
}
