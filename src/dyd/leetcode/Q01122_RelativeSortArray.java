package dyd.leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * 1122. Relative Sort Array
 *
 * Easy
 *
 * Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
 *
 * Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.  Elements that
 * don't appear in arr2 should be placed at the end of arr1 in ascending order.
 *
 *
 *
 * Example 1:
 *
 * Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * Output: [2,2,2,1,4,3,3,9,6,7,19]
 *
 *
 * Constraints:
 *
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * Each arr2[i] is distinct.
 * Each arr2[i] is in arr1.
 */
public class Q01122_RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        if (arr1.length == 0 || arr2.length == 0) {
            return arr1;
        }

        int[] ret = new int[arr1.length];

        Map<Integer, Integer> numCounts = new TreeMap();
        for (int num : arr1) {
            int count = numCounts.getOrDefault(num, 0);
            numCounts.put(num, count + 1);
        }

        int i = 0;
        for (int num : arr2) {
            int count = numCounts.get(num);
            for (int j = 0; j < count; j++) {
                ret[i ++] = num;
            }
            numCounts.remove(num);
        }

        for (Map.Entry<Integer, Integer> entry : numCounts.entrySet()) {
            for (int j = 0; j < entry.getValue(); j++) {
                ret[i++] = entry.getKey();
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        test(new int[] {2,3,1,3,2,4,6,7,9,2,19}, new int[] {2,1,4,3,9,6});
    }

    private static void test(int[] arr1, int[] arr2) {
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        Q01122_RelativeSortArray q = new Q01122_RelativeSortArray();
        System.out.println("result: " + Arrays.toString(q.relativeSortArray(arr1, arr2)));
    }
}
