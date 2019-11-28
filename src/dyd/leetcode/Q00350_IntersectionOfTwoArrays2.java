package dyd.leetcode;

import java.util.*;

/**
 * 350. Intersection of Two Arrays II -- Easy
 *
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Note:
 *
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Follow up:
 *
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into
 * the memory at once?
 */
public class Q00350_IntersectionOfTwoArrays2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[] {};
        }

        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        Map<Integer, Integer> counts = new HashMap();
        for (int num : nums1) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        List<Integer> intersects = new ArrayList();
        for (int num : nums2) {
            if (counts.containsKey(num)) {
                intersects.add(num);

                int count = counts.get(num);
                if (count > 1) {
                    counts.put(num, count - 1);
                } else {
                    counts.remove(num);
                }
            }
        }

        int[] ret = new int[intersects.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = intersects.get(i);
        }
        return ret;
    }

    public static void main(String[] args) {
        test(new int[] {1,2,2,1}, new int[] {2,2});
        test(new int[] {4,9,5}, new int[] {9,4,9,8,4});
    }

    private static void test(int[] nums1, int[] nums2) {
        System.out.println("nums1=" + Arrays.toString(nums1));
        System.out.println("nums2=" + Arrays.toString(nums2));
        Q00350_IntersectionOfTwoArrays2 q = new Q00350_IntersectionOfTwoArrays2();
        System.out.println(Arrays.toString(q.intersect(nums1, nums2)));
        System.out.println();
    }
}
