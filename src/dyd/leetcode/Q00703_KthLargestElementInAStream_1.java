package dyd.leetcode;

import java.util.PriorityQueue;

public class Q00703_KthLargestElementInAStream_1 {
    private int k;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public Q00703_KthLargestElementInAStream_1(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }

    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int k = 3;
        int[] arr = {4, 5, 8, 2};
        Q00703_KthLargestElementInAStream_1 q = new Q00703_KthLargestElementInAStream_1(k, arr);
        System.out.println(q.add(3));   // returns 4
        System.out.println(q.add(5));   // returns 5
        System.out.println(q.add(10));   // returns 5
        System.out.println(q.add(9));   // returns 8
        System.out.println(q.add(4));   // returns 8
    }
}
