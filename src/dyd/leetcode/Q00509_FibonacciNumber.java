package dyd.leetcode;

/**
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), for N > 1.
 * Given N, calculate F(N).
 *
 *
 *
 * Example 1:
 *
 * Input: 2
 * Output: 1
 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 * Example 2:
 *
 * Input: 3
 * Output: 2
 * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 * Example 3:
 *
 * Input: 4
 * Output: 3
 * Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 *
 *
 * Note:
 *
 * 0 ≤ N ≤ 30.
 */
public class Q00509_FibonacciNumber {
    public int fib(int N) {
        if (N == 0) {
            return 0;
        } else if (N == 1) {
            return 1;
        }

        int a = 0;
        int b = 1;
        int f = 0;
        for (int i = 2; i <= N; i++) {
            f = a + b;
            a = b;
            b = f;
        }
        return f;
    }

    public static void main(String[] args) {
        Q00509_FibonacciNumber q = new Q00509_FibonacciNumber();
        System.out.println("f(0)=" + q.fib(0));
        System.out.println("f(1)=" + q.fib(1));
        System.out.println("f(2)=" + q.fib(2));
        System.out.println("f(3)=" + q.fib(3));
        System.out.println("f(4)=" + q.fib(4));
        System.out.println("f(5)=" + q.fib(5));
        System.out.println("f(6)=" + q.fib(6));
        System.out.println("f(7)=" + q.fib(7));
        System.out.println("f(8)=" + q.fib(8));
        System.out.println("f(9)=" + q.fib(9));
        System.out.println("f(10)=" + q.fib(10));
    }
}
