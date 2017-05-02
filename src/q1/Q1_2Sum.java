package q1;

import java.util.HashMap;

public class Q1_2Sum {
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
		int[] result = new Q1_2Sum().twoSum(nums, 9);
		System.out.println(result[0] + " " + result[1]);
	}
}
