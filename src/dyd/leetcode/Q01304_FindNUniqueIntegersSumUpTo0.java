package dyd.leetcode;

import java.util.Arrays;

/**
 * 1304. Find N Unique Integers Sum up to Zero -- Easy
 *
 * Given an integer n, return any array containing n unique integers such that they add up to 0.
 *
 * Example 1:
 *
 * Input: n = 5
 * Output: [-7,-1,1,3,4]
 * Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
 * Example 2:
 *
 * Input: n = 3
 * Output: [-1,0,1]
 * Example 3:
 *
 * Input: n = 1
 * Output: [0]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 1000
 */
public class Q01304_FindNUniqueIntegersSumUpTo0 {
    public int[] sumZero(int n) {
        int[] ret = new int[n];

        int i = 0;
        if (n % 2 == 1) {
            ret[i ++] = 0;
        }

        int j = 1;
        for (; i < n; i++) {
            ret[i ++] = -j;
            ret[i] = j ++;
        }
        return ret;
    }

    public static void main(String[] args) {
        test(5);
        test(4);
        test(3);
        test(1);
    }

    private static void test(int n) {
        Q01304_FindNUniqueIntegersSumUpTo0 q = new Q01304_FindNUniqueIntegersSumUpTo0();
        System.out.println(Arrays.toString(q.sumZero(n)));
    }
}
