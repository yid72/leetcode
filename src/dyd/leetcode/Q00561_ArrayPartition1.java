package dyd.leetcode;

/**
 * Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 *
 * Example 1:
 * Input: [1,4,3,2]
 *
 * Output: 4
 * Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
 * Note:
 * n is a positive integer, which is in the range of [1, 10000].
 * All the integers in the array will be in the range of [-10000, 10000].
 */
public class Q00561_ArrayPartition1 {
    public int reverse(int x) {
        int sign = x > 0? 1 : -1;
        x = Math.abs(x);
        long z = 0;
        while (x > 0) {
            int tmp = x%10;
            x = x/10;
            z = z*10 + tmp;
        }
        z = sign * z;
        return (z > Integer.MAX_VALUE || z < Integer.MIN_VALUE) ? 0 : (int) z;
    }

    public static void main(String[] args) {
        test(123);
        test(-123);
        test(120);
        test(1534236469);
    }

    private static void test(int x) {
        Q00561_ArrayPartition1 q = new Q00561_ArrayPartition1();
        System.out.println(x + ": " + q.reverse(x));
    }
}
