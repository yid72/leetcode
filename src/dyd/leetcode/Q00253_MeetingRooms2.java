package dyd.leetcode;

import java.util.*;

/**
 * 253. Meeting Rooms II -- Medium
 *
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the
 * minimum number of conference rooms required.
 *
 * Example 1:
 *
 * Input: [[0, 30],[5, 10],[15, 20]]
 * Output: 2
 * Example 2:
 *
 * Input: [[7,10],[2,4]]
 * Output: 1
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method
 * signature.
 */
public class Q00253_MeetingRooms2 {
    public int minMeetingRooms(int[][] intervals) {
        int[] startTimes = new int[intervals.length];
        int[] endTimes = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int maxRooms = 0;
        int curRooms = 0;
        int i = 0;
        int j = 0;
        while (i < intervals.length && j < intervals.length) {
            if (startTimes[i] < endTimes[j]) {
                curRooms ++;
                maxRooms = Math.max(curRooms, maxRooms);
                i ++;
            } else {
                curRooms --;
                j ++;
            }
        }

        return maxRooms;
    }

    public static void main(String[] args) {
        test(new int[][] {
                {0, 30},{5, 10},{15, 20}
        });

        test(new int[][] {
                {7,10},{2,4}
        });

        test(new int[][] {
                {13,15}, {1,13}
        });
    }

    private static void test(int[][] intervals) {
        Q00253_MeetingRooms2 q = new Q00253_MeetingRooms2();
        System.out.printf("intervals=%s: %d\n", Arrays.deepToString(intervals), q.minMeetingRooms(intervals));
    }
}
