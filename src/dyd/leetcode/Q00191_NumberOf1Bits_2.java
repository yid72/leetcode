package dyd.leetcode;

public class Q00191_NumberOf1Bits_2 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

    public static void main(String[] args) {
        test(1);
        test(2);
        test(3);
        test(-3);
    }

    private static void test(int n) {
        Q00191_NumberOf1Bits_2 q = new Q00191_NumberOf1Bits_2();
        System.out.printf("n=%d, hamming weight=%d\n", n, q.hammingWeight(n));
    }
}