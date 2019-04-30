package dyd.leetcode;

public class Q00231_IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }

        while (n > 1) {
            if ((n & 1) == 1) {
                return false;
            }
            n /= 2;
        }
        return true;
    }

    public static void main(String[] args) {
        Q00231_IsPowerOfTwo q = new Q00231_IsPowerOfTwo();
        System.out.println(q.isPowerOfTwo(1));  // true
        System.out.println(q.isPowerOfTwo(16));  // true
        System.out.println(q.isPowerOfTwo(3));  // false
        System.out.println(q.isPowerOfTwo(218));  // false
        System.out.println(q.isPowerOfTwo(0));  // false
        System.out.println(q.isPowerOfTwo(-16));  // false
    }
}
