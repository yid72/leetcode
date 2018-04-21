package dyd.leetcode;

import dyd.leetcode.common.PrintUtil;

import java.util.HashMap;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class Q00001_2Sum {
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i]))
			{
				return new int[] {i, map.get(target - nums[i])};
			}
			else {
				map.put(nums[i], i);
			}
		}
		
		return new int[] {0, 0};
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 5, 2, 9, 7, 4, 6};
		PrintUtil.printArray(nums);

		int[] result = new Q00001_2Sum().twoSum(nums, 9);
		System.out.println(result[0] + " " + result[1]);
	}
}
