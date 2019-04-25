package dyd.leetcode;

public class Q00461_HammingDistance {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x^y);
    }

    public static void main(String[] args) {
        Q00461_HammingDistance q = new Q00461_HammingDistance();
        System.out.println(q.hammingDistance(1, 4));
    }
}
