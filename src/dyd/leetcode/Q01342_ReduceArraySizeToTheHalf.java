package dyd.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1342. Reduce Array Size to The Half -- Medium
 *
 * Given an array arr.  You can choose a set of integers and remove all the occurrences of these integers in the array.
 *
 * Return the minimum size of the set so that at least half of the integers of the array are removed.
 *
 * Example 1:
 *
 * Input: arr = [3,3,3,3,5,5,5,2,2,7]
 * Output: 2
 * Explanation: Choosing {3,7} will make the new array [5,5,5,2,2] which has size 5 (i.e equal to half of the size of the old array).
 * Possible sets of size 2 are {3,5},{3,2},{5,2}.
 * Choosing set {2,7} is not possible as it will make the new array [3,3,3,3,5,5,5] which has size greater than half of the size of the old array.
 * Example 2:
 *
 * Input: arr = [7,7,7,7,7,7]
 * Output: 1
 * Explanation: The only possible set you can choose is {7}. This will make the new array empty.
 * Example 3:
 *
 * Input: arr = [1,9]
 * Output: 1
 * Example 4:
 *
 * Input: arr = [1000,1000,3,7]
 * Output: 1
 * Example 5:
 *
 * Input: arr = [1,2,3,4,5,6,7,8,9,10]
 * Output: 5
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 10^5
 * arr.length is even.
 * 1 <= arr[i] <= 10^5
 */
public class Q01342_ReduceArraySizeToTheHalf {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> frequencyMap = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            int freq = frequencyMap.getOrDefault(arr[i], 0);
            frequencyMap.put(arr[i], freq + 1);
        }

        int[] frequencies = new int[arr.length];
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            frequencies[entry.getValue() - 1] ++;
        }

        int count = 0;
        int sum = 0;
        for (int i = frequencies.length - 1; i >= 0; i--) {
            if (frequencies[i] > 0) {
                for (int j = 0; j < frequencies[i]; j++) {
                    sum += (i + 1);
                    count ++;
                    if (sum >= arr.length/2) {
                        return count;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        test(new int[] {3,3,3,3,5,5,5,2,2,7});
        test(new int[] {7,7,7,7,7,7});
        test(new int[] {1,9});
        test(new int[] {1000,1000,3,7});
        test(new int[] {1,2,3,4,5,6,7,8,9,10});
    }

    private static void test(int[] arr) {
        Q01342_ReduceArraySizeToTheHalf q = new Q01342_ReduceArraySizeToTheHalf();
        System.out.printf("arr=%s: %d\n", Arrays.toString(arr), q.minSetSize(arr));
    }
}
