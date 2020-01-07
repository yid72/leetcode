package dyd.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 295. Find Median from Data Stream -- Hard
 *
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So
 * the median is the mean of the two middle value.
 *
 * For example,
 * [2,3,4], the median is 3
 *
 * [2,3], the median is (2 + 3) / 2 = 2.5
 *
 * Design a data structure that supports the following two operations:
 *
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 *
 *
 * Example:
 *
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 *
 *
 * Follow up:
 *
 * If all integer numbers from the stream are between 0 and 100, how would you optimize it?
 * If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?
 */
public class Q00295_FindMedianFromDataStream {
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    /** initialize your data structure here. */
    public Q00295_FindMedianFromDataStream() {
        maxHeap = new PriorityQueue<>();
        minHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == 0 && minHeap.size() == 0) {
            return 0;
        }

        return maxHeap.size() > minHeap.size() ? maxHeap.peek() : (maxHeap.peek() + minHeap.peek()) / 2.0;
    }

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        Q00295_FindMedianFromDataStream q = new Q00295_FindMedianFromDataStream();
        System.out.println(q.findMedian());
        q.addNum(1);
        System.out.println(q.findMedian());
        q.addNum(2);
        System.out.println(q.findMedian());
        q.addNum(3);
        System.out.println(q.findMedian());
    }
}
