package dyd.leetcode;

import dyd.leetcode.common.PrintUtil;

import java.util.Arrays;

/**
 * Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains initial elements from the stream. For each call to the method KthLargest.add, return the element representing the kth largest element in the stream.
 *
 * Example:
 *
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 */
public class Q00703_KthLargestElementInAStream {
    private int[] sortedNums;
    private int k;

    public Q00703_KthLargestElementInAStream(int k, int[] nums) {
        this.k = k;
        Arrays.sort(nums);
        this.sortedNums = nums;
        System.out.print("Sorted: ");
        PrintUtil.printArray(sortedNums);
    }

    public int add(int val) {
        int[] newNums = new int[sortedNums.length + 1];
        int index = Arrays.binarySearch(sortedNums, val);
        if (index < 0) {
            index = -(index + 1);
        }

        System.arraycopy(sortedNums, 0, newNums, 0, index);
        newNums[index] = val;
        System.arraycopy(sortedNums, index, newNums, index + 1, sortedNums.length - index);
        sortedNums = newNums;
        PrintUtil.printArray(sortedNums);
        return sortedNums[sortedNums.length - k];
    }

    public static void main(String[] args) {
        int k = 3;
        int[] arr = {4,5,8,2};
        Q00703_KthLargestElementInAStream q = new Q00703_KthLargestElementInAStream(k, arr);
        System.out.println(q.add(3));   // returns 4
        System.out.println(q.add(5));   // returns 5
        System.out.println(q.add(10));   // returns 5
        System.out.println(q.add(9));   // returns 8
        System.out.println(q.add(4));   // returns 8
    }
}
