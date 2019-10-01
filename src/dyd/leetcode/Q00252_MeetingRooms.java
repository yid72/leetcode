package dyd.leetcode;

import java.util.*;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * determine if a person could attend all meetings.
 *
 * Example 1:
 *
 * Input: [[0,30],[5,10],[15,20]]
 * Output: false
 * Example 2:
 *
 * Input: [[7,10],[2,4]]
 * Output: true
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method
 * signature.
 */
public class Q00252_MeetingRooms {
    class Interval {
        int startTime;
        int endTime;

        public Interval(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    class StartTimeComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval i1, Interval i2) {
            if (i1.startTime == i2.startTime) {
                return 0;
            } else if (i1.startTime < i2.startTime) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    public boolean canAttendMeetings(int[][] intervals) {
        List<Interval> intervalList = new ArrayList();
        for (int i = 0; i < intervals.length; i++) {
            intervalList.add(new Interval(intervals[i][0], intervals[i][1]));
        }

        Collections.sort(intervalList, new StartTimeComparator());

        Interval prevInterval = intervalList.get(0);
        for (int i = 1; i < intervalList.size(); i ++) {
            if (intervalList.get(i).startTime < prevInterval.endTime) {
                return false;
            }
            prevInterval = intervalList.get(i);
        }

        return true;
    }

    public static void main(String[] args) {
        test(new int[][] {{0, 30}, {5, 10}, {15, 20}});
        test(new int[][] {{7,10},{2,4}});
    }

    private static void test(int[][] intervals) {
        Q00252_MeetingRooms q = new Q00252_MeetingRooms();
        System.out.println(Arrays.deepToString(intervals));
        System.out.println(q.canAttendMeetings(intervals));
    }
}
