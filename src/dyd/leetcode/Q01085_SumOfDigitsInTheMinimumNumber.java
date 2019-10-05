package dyd.leetcode;

import java.util.Arrays;

/**
 * Given an array A of positive integers, let S be the sum of the digits of the minimal element of A.
 *
 * Return 0 if S is odd, otherwise return 1.
 *
 *
 *
 * Example 1:
 *
 * Input: [34,23,1,24,75,33,54,8]
 * Output: 0
 * Explanation:
 * The minimal element is 1, and the sum of those digits is S = 1 which is odd, so the answer is 0.
 * Example 2:
 *
 * Input: [99,77,33,66,55]
 * Output: 1
 * Explanation:
 * The minimal element is 33, and the sum of those digits is S = 3 + 3 = 6 which is even, so the answer is 1.
 *
 *
 * Note:
 *
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 */
public class Q01085_SumOfDigitsInTheMinimumNumber {
    public int sumOfDigits(int[] A) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (min > A[i]) {
                min = A[i];
            }
        }

        int sum = 0;
        while (min > 0) {
            sum += min % 10;
            min = min/10;
        }
        return (sum % 2 == 1) ? 0 : 1;
    }

    public static void main(String[] args) {
        test(new int[] {34,23,1,24,75,33,54,8});
        test(new int[] {99,77,33,66,55});
    }

    private static void test(int[] A) {
        System.out.println(Arrays.toString(A));
        Q01085_SumOfDigitsInTheMinimumNumber q = new Q01085_SumOfDigitsInTheMinimumNumber();
        System.out.println(q.sumOfDigits(A));
    }
}
