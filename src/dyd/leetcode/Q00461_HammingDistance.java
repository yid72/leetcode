package dyd.leetcode;

public class Q00461_HammingDistance {
    public int hammingDistance(int x, int y) {
        String result = Integer.toBinaryString(x^y);
        int count = 0;
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) == '1') {
                count ++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Q00461_HammingDistance q = new Q00461_HammingDistance();
        System.out.println(q.hammingDistance(1, 4));
    }
}
