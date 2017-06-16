package dyd.leetcode.q215;

import dyd.leetcode.common.PrintUtil;

/**
 * 
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 <= k <= array's length.

 * @author dyd
 *
 */
public class Q215_KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
    	return findKthLargest(nums, 0, nums.length -1, k);
    }
    
    private int findKthLargest(int[] nums, int lo, int hi, int k) {
    	int pivot = partition(nums, lo, hi);
    	if (hi - pivot + 1 == k) {
    		return nums[pivot];
    	}
    	else if (hi - pivot + 1 > k) {
    		return findKthLargest(nums, pivot, hi, k);
    	}
    	else {
    		return findKthLargest(nums, lo, pivot - 1, k - (hi - lo + 1));
    	}
    }
    
    private int partition(int[] nums, int lo, int hi) {
    	int pivot = nums[hi];
    	int i = lo - 1;
    	for (int j = lo; j < hi; j++) {
    		if (nums[j] <= pivot) {
    			i ++;
    			if (i != j) {
    				swap(nums, i, j);
    			}
    		}
    	}
    	swap(nums, i + 1, hi);
    	return i + 1;
    }
    
    private void swap(int[] nums, int i, int j) {
    	int temp = nums[j];
    	nums[j] = nums[i];
    	nums[i] = temp;
    }
    
    private static void test(int[] nums, int k) {
    	Q215_KthLargestElementInArray q = new Q215_KthLargestElementInArray();
    	PrintUtil.printArray(nums);
    	System.out.printf("K = %d, %d", k, q.findKthLargest(nums, k));
    }
    
    public static void main(String[] args) {
//    	test(new int[] {3, 2, 1, 5, 6, 4}, 2);
    	test(new int[] {-1, -1}, 2);
    }
}
