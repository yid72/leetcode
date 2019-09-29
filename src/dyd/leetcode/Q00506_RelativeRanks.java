package dyd.leetcode;

import java.util.*;

/**
 * Given scores of N athletes, find their relative ranks and the people with the top three highest scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".
 *
 * Example 1:
 * Input: [5, 4, 3, 2, 1]
 * Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal".
 * For the left two athletes, you just need to output their relative ranks according to their scores.
 * Note:
 * N is a positive integer and won't exceed 10,000.
 * All the scores of athletes are guaranteed to be unique.
 */
public class Q00506_RelativeRanks {
    class MyObj implements Comparable<MyObj> {
        int num;
        int index;

        public MyObj(int num, int index) {
            this.num = num;
            this.index = index;
        }

        @Override
        public int compareTo(MyObj obj) {
            if (num == obj.num) {
                return 0;
            } else if (num < obj.num) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    private static final Map<Integer, String> RANK_NAMES = new HashMap<>();
    static {
        RANK_NAMES.put(1, "Gold Medal");
        RANK_NAMES.put(2, "Silver Medal");
        RANK_NAMES.put(3, "Bronze Medal");
    }

    public String[] findRelativeRanks(int[] nums) {
        List<MyObj> objs = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            objs.add(new MyObj(nums[i], i));
        }

        Collections.sort(objs, Comparator.reverseOrder());

        String[] ranks = new String[nums.length];
        for (int i = 0; i < ranks.length; i++) {
            if (i < 3) {
                ranks[objs.get(i).index] = RANK_NAMES.get(i+1);
            } else {
                ranks[objs.get(i).index] = Integer.toString(i+1);
            }
        }
        return ranks;
    }

    public static void main(String[] args) {
        test(new int[] {5, 4, 3, 2, 1});
        test(new int[] {5, 1, 4, 2, 3});
        test(new int[] {});
    }

    private static void test(int[] nums) {
        System.out.println(Arrays.toString(nums));

        Q00506_RelativeRanks q = new Q00506_RelativeRanks();
        String[] ranks = q.findRelativeRanks(nums);
        System.out.println(Arrays.toString(ranks));
    }
}
