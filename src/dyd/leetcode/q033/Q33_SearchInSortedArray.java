package dyd.leetcode.q033;

public class Q33_SearchInSortedArray {
    public int search(int[] nums, int target) {
    	if (nums.length == 0) {
    		return -1;
    	}
    	
        return search(nums, 0, nums.length-1, target);
    }
    
    private int search(int[] nums, int start, int end, int target) {
    	if (start > end) {
    		return -1;
    	}
    	else if (start == end) {
    		if (nums[start] == target) {
    			return start;
    		}
    		else {
    			return -1;
    		}
    	}
    	
		if (nums[start] <= nums[end]) {
			return binarySearch(nums, start, end, target);
		}
		else {
			int middle = (start + end) / 2;
			if (nums[middle] == target) {
				return middle;
			}
			int result = search(nums, start, middle-1, target);
			if (result == -1) {
				result = search(nums, middle + 1, end, target);
			}
			return result;
		}
    }
    
    private int binarySearch(int[] nums, int start, int end, int target) {
    	while (start <= end) {
    		int middle = (start + end) / 2;
    		if (nums[middle] == target) {
    			return middle;
    		}
    		else if (nums[middle] > target) {
    			end = middle - 1;
    		}
    		else {
    			start = middle + 1;
    		}
    	}
    	return -1;
    }
    
    public static void main(String[] args) {
    	Q33_SearchInSortedArray t = new Q33_SearchInSortedArray();
    	int[] nums = new int[] {4, 5, 1, 2, 3};
//    	System.out.println(t.search(nums, 1));
//    	System.out.println(t.search(nums, 2));
//    	System.out.println(t.search(nums, 3));
//    	System.out.println(t.search(nums, 4));
//    	System.out.println(t.search(nums, 5));
//    	
//    	nums = new int[] {1};
//    	System.out.println(t.search(nums, 0));
    	
    	nums = new int[] {3, 1};
    	System.out.println(t.search(nums, 0));
    }
}
