package dyd.leetcode.q350;

import java.util.ArrayList;
import java.util.HashSet;

public class Q350_IntersectionTwoArrays2 {
    public int[] intersection(int[] nums1, int[] nums2) {
    	HashSet<Integer> set = new HashSet<Integer>();
    	
    	for (int num : nums1) {
    		set.add(num);
    	}
    	
    	ArrayList<Integer>  retList = new ArrayList<Integer>();
    	
    	for (int num : nums2) {
    		if (set.contains(num)) {
    			retList.add(num);
    		}
    	}
    	
    	int[] ret = new int[retList.size()];
    	int i = 0;
    	for (int num : retList) {
    		ret[i++] = num;
    	}
    	
    	return ret;
    }
    
    public static void main(String[] args) {
    	Q350_IntersectionTwoArrays2 q = new Q350_IntersectionTwoArrays2();
    	int[] ret = q.intersection(new int[] {1, 2, 2, 1, 3}, new int[] {2, 2});
    	for (int i = 0; i < ret.length; i++) {
    		System.out.print(ret[i] + " ");
    	}
    }

}
