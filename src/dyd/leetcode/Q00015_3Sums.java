package dyd.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 15. 3Sum
 *
 * Medium
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique
 * triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class Q00015_3Sums {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
        Map<String, List<Integer>> sums = new HashMap();

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int c = -nums[i] - nums[j];
                int index = Arrays.binarySearch(nums, j+1, nums.length, c);
                if (index >= 0) {
                    List<Integer> sum = new ArrayList<>();
                	sum.add(nums[i]);
                	sum.add(nums[j]);
                	sum.add(nums[index]);
                	sums.put(i + "_" + j + "_" + index, sum);
                }
            }
        }

        return sums.values().stream().collect(Collectors.toList());
    }
    
    public static void main(String[] args) {
    	Q00015_3Sums q = new Q00015_3Sums();
    	List<List<Integer>> result = q.threeSum(new int[] {-1, 0, 1, 2, -1, -4});
    	for (List<Integer> list : result){
    		for (int a : list) {
    			System.out.print(a + " ");
    		}
    		System.out.println();
    	}
    }
}
