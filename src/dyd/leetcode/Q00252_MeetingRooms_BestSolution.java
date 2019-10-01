package dyd.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Q00252_MeetingRooms_BestSolution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i-1][1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        test(new int[][] {{0, 30}, {5, 10}, {15, 20}});
        test(new int[][] {{7,10},{2,4}});
    }

    private static void test(int[][] intervals) {
        Q00252_MeetingRooms_BestSolution q = new Q00252_MeetingRooms_BestSolution();
        System.out.println(Arrays.deepToString(intervals));
        System.out.println(q.canAttendMeetings(intervals));
    }
}