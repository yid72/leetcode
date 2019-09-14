package dyd.leetcode;

/**
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 *
 * Note: Do not use any built-in library function such as sqrt.
 *
 * Example 1:
 *
 * Input: 16
 * Output: true
 * Example 2:
 *
 * Input: 14
 * Output: false
 */
public class Q00367_ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num == 0 || num == 1) {
            return true;
        }

        long low = 2;
        long high = num;
        while (low <= high) {
            long mid = (low + high)/2;
            long square = mid * mid;
            if (square == num) {
                return true;
            } else if (square > num) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        test(16);
        test(14);
        test(2147483647);
    }

    private static void test(int num) {
        Q00367_ValidPerfectSquare q = new Q00367_ValidPerfectSquare();
        System.out.println(num + ": " + q.isPerfectSquare(num));
    }
}
