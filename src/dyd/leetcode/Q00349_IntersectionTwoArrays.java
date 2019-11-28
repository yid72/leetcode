package dyd.leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 349. Intersection of Two Arrays -- Easy
 *
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Note:
 *
 * Each element in the result must be unique.
 * The result can be in any order.
 */
public class Q00349_IntersectionTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
    	HashSet<Integer> set = new HashSet<Integer>();
    	
    	for (int num : nums1) {
    		set.add(num);
    	}
    	
    	HashSet<Integer>  retSet = new HashSet<Integer>();
    	
    	for (int num : nums2) {
    		if (set.contains(num)) {
    			retSet.add(num);
    		}
    	}
    	
    	int[] ret = new int[retSet.size()];
    	int i = 0;
    	for (int num : retSet) {
    		ret[i++] = num;
    	}
    	
    	return ret;
    }

	public static void main(String[] args) {
		test(new int[] {1,2,2,1}, new int[] {2,2});
		test(new int[] {4,9,5}, new int[] {9,4,9,8,4});
	}

	private static void test(int[] nums1, int[] nums2) {
		System.out.println("nums1=" + Arrays.toString(nums1));
		System.out.println("nums2=" + Arrays.toString(nums2));
		Q00349_IntersectionTwoArrays q = new Q00349_IntersectionTwoArrays();
		System.out.println(Arrays.toString(q.intersection(nums1, nums2)));
		System.out.println();
	}
}
