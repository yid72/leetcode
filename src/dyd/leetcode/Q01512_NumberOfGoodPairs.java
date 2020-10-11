package dyd.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 1512. Number of Good Pairs - Easy
 *
 * Given an array of integers nums.
 *
 * A pair (i,j) is called good if nums[i] == nums[j] and i < j.
 *
 * Return the number of good pairs.
 */
public class Q01512_NumberOfGoodPairs {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> countsByValue = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            countsByValue.put(nums[i], countsByValue.getOrDefault(nums[i], 0) + 1);
        }
        return countsByValue.values().stream().mapToInt(i -> i*(i-1)/2).sum();
    }

    public static void main(String[] args) {
        test(new int[] {1,2,3,1,1,3});
    }

    private static void test(int[] nums) {
        Q01512_NumberOfGoodPairs q = new Q01512_NumberOfGoodPairs();
        System.out.println(q.numIdenticalPairs(nums));
    }
}
