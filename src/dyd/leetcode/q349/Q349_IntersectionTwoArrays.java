package dyd.leetcode.q349;

import java.util.HashSet;

public class Q349_IntersectionTwoArrays {
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
    	Q349_IntersectionTwoArrays q = new Q349_IntersectionTwoArrays();
    	int[] ret = q.intersection(new int[] {1, 2, 2, 1, 3}, new int[] {2, 2});
    	for (int i = 0; i < ret.length; i++) {
    		System.out.println(ret[i] + " ");
    	}
    }
}
