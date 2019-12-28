package dyd.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 179. Largest Number -- Medium
 *
 * Given a list of non negative integers, arrange them such that they form the largest number.
 *
 * Example 1:
 *
 * Input: [10,2]
 * Output: "210"
 * Example 2:
 *
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class Q00179_LargestNumber {
    public String largestNumber(int[] nums) {
        if (nums.length == 0) {
            return "";
        }

        List<String> strNums = Arrays.stream(nums)
                .mapToObj(num -> Integer.toString(num))
                .collect(Collectors.toList());
        Collections.sort(strNums, (s1, s2) ->  (s2 + s1).compareTo(s1 + s2));
        String number = String.join("", strNums);
        return (number.charAt(0) == '0') ? "0" : number;
    }

    public static void main(String[] args) {
        test(new int[] {10,2});
        test(new int[] {3,30,34,5,9});
        test(new int[] {0,0});
        test(new int[] {0,0,1});
    }

    private static void test(int[] nums) {
        Q00179_LargestNumber q = new Q00179_LargestNumber();
        System.out.printf("nums=%s\n", Arrays.toString(nums));
        System.out.printf("largest number=%s\n", q.largestNumber(nums));
    }
}
