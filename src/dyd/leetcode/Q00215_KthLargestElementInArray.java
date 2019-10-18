package dyd.leetcode;

import java.util.Arrays;

/**
 * 
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the
 kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 <= k <= array's length.

 * @author dyd
 *
 */
public class Q00215_KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
    	return findKthLargest(nums, 0, nums.length - 1, k);
    }
    
    private int findKthLargest(int[] nums, int lo, int hi, int k) {
    	int pivot = partition(nums, lo, hi);
    	if (hi - pivot + 1 == k) {
    		return nums[pivot];
    	} else if (hi - pivot + 1 > k) {
    		return findKthLargest(nums, pivot + 1, hi, k);
    	} else {
    		return findKthLargest(nums, lo, pivot - 1, k - (hi - pivot + 1));
    	}
    }
    
    private int partition(int[] nums, int lo, int hi) {
    	int pivot = nums[lo];
    	int i = lo;
    	int j = hi + 1;
    	while (true) {
    		while (++i < j && nums[i] < pivot);
    		while (--j > i && nums[j] >= pivot);

    		if (i >= j) {
    			break;
			}

    		swap(nums, i, j);
		}
    	swap(nums, lo, i - 1);
    	return i - 1;
    }
    
    private void swap(int[] nums, int i, int j) {
    	int temp = nums[j];
    	nums[j] = nums[i];
    	nums[i] = temp;
    }
    
    private static void test(int[] nums, int k) {
    	System.out.printf("nums=%s, K=%d\n", Arrays.toString(nums), k);
    	Q00215_KthLargestElementInArray q = new Q00215_KthLargestElementInArray();
    	System.out.printf("result=%d\n", q.findKthLargest(nums, k));
    }
    
    public static void main(String[] args) {
    	test(new int[] {3, 2, 1, 5, 6, 4}, 2);
    	test(new int[] {3, 2, 3, 1, 2, 4, 5, 5, 6}, 4);
    	test(new int[] {-1, -1}, 2);
		test(new int[] {2, 1}, 2);
    }
}
