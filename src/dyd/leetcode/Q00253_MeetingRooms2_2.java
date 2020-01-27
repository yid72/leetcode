package dyd.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q00253_MeetingRooms2_2 {
    class Element implements Comparable<Element> {
        int sign;
        int time;

        public Element(int sign, int time) {
            this.sign = sign;
            this.time = time;
        }

        @Override
        public int compareTo(Element el) {
            return Integer.compare(time, el.time);
        }
    }

    public int minMeetingRooms(int[][] intervals) {
        List<Element> els = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            els.add(new Element(1, intervals[i][0]));
            els.add(new Element(-1, intervals[i][1]));
        }

        Collections.sort(els);

        int maxRooms = 0;
        int curRooms = 0;
        for (Element el : els) {
            if (el.sign > 0) {
                curRooms ++;
                maxRooms = Math.max(maxRooms, curRooms);
            } else {
                curRooms --;
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
        Q00253_MeetingRooms2_2 q = new Q00253_MeetingRooms2_2();
        System.out.printf("intervals=%s: %d\n", Arrays.deepToString(intervals), q.minMeetingRooms(intervals));
    }
}
