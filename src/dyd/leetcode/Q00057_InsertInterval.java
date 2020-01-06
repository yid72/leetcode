package dyd.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Example 2:
 *
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method
 * signature.
 */
public class Q00057_InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int index = binarySearch(intervals, newInterval);

        int right = index;
        for (; right < intervals.length; right ++) {
            if (intervals[right][0] > newInterval[1]) {
                break;
            }
        }

        List<int[]> ret = new ArrayList();
        for (int i = 0; i < index; i++) {
            ret.add(intervals[i]);
        }

        for (int i = index; i < intervals.length; i++) {

        }
        return null;
    }

    private int binarySearch(int[][] intervals, int[] newInterval) {
        int lo = 0;
        int hi = intervals.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo)/2;
            if (intervals[mid][0] == newInterval[0]) {
                return mid;
            } else if (intervals[mid][0] < newInterval[0]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return Math.min(lo, intervals.length - 1);
    }
}
