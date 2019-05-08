package dyd.leetcode;

import dyd.leetcode.common.PrintUtil;

/**
 * Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days
 * you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.
 *
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be
 * [1, 1, 4, 2, 1, 1, 0, 0].
 *
 * Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the
 * range [30, 100].
 */
public class Q00739_M_DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int[] temperatures = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            for (int j = i + 1; j < T.length; j++) {
                if (T[j] > T[i]) {
                    temperatures[i] = j - i;
                    break;
                }
            }
        }
        return temperatures;
    }

    public static void main(String[] args) {
        Q00739_M_DailyTemperatures q = new Q00739_M_DailyTemperatures();
        int[] T = new int[] {73, 74, 75, 71, 69, 72, 76, 73};
        PrintUtil.printArray("T", T);
        PrintUtil.printArray("Warmer temperatures", q.dailyTemperatures(T));
    }
}
