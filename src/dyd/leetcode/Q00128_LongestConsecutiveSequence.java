package dyd.leetcode;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 128. Longest Consecutive Sequence -- Hard
 *
 * * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 *
 * Your algorithm should run in O(n) complexity.
 *
 * Example:
 *
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */
public class Q00128_LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int longest = 0;
        Set<Integer> set =  Arrays.stream(nums).boxed().collect(Collectors.toSet());
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
                int left = num - 1;
                while (set.contains(left)) {
                    set.remove(left --);
                }

                int right = num + 1;
                while (set.contains(right)) {
                    set.remove(right ++);
                }

                longest = Math.max(longest, right - left - 1);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        test(new int[] {100, 4, 200, 1, 3, 2});
    }

    private static void test(int[] nums) {
        Q00128_LongestConsecutiveSequence q = new Q00128_LongestConsecutiveSequence();
        System.out.printf("nums=%s: %d", Arrays.toString(nums), q.longestConsecutive(nums));
    }
}
