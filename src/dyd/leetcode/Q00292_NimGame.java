package dyd.leetcode;

/**
 * 292. Nim Game -- Easy
 *
 * You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you
 * take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first
 * turn to remove the stones.
 *
 * Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can
 * win the game given the number of stones in the heap.
 *
 * Example:
 *
 * Input: 4
 * Output: false
 * Explanation: If there are 4 stones in the heap, then you will never win the game;
 *              No matter 1, 2, or 3 stones you remove, the last stone will always be
 *              removed by your friend.
 */
public class Q00292_NimGame {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    public static void main(String[] args) {
        test(1);
        test(2);
        test(3);
        test(4);
        test(5);
        test(6);
        test(7);
        test(8);
        test(9);
        test(10);
        test(11);
        test(12);
    }

    private static void test(int n) {
        Q00292_NimGame q = new Q00292_NimGame();
        System.out.println("n=" + n + ": " + q.canWinNim(n));
    }
}
