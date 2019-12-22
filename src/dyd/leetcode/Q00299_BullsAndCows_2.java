package dyd.leetcode;

/**
 * Faster.
 */
public class Q00299_BullsAndCows_2 {
    public String getHint(String secret, String guess) {
        int[] digitCounts = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            digitCounts[secret.charAt(i) - '0'] ++;
        }

        int bulls = 0;
        for (int i = 0; i < guess.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls ++;
                digitCounts[guess.charAt(i) - '0'] --;
            }
        }

        int cows = 0;
        for (int i = 0; i < guess.length(); i++) {
            if (secret.charAt(i) != guess.charAt(i) && digitCounts[guess.charAt(i) - '0'] > 0) {
                cows ++;
                digitCounts[guess.charAt(i) - '0'] --;
            }
        }

        return String.format("%dA%dB", bulls, cows);
    }

    public static void main(String[] args) {
        test("1807", "7810");
        test("1123", "0111");
        test("1122", "1222");
    }

    private static void test(String secret, String guess) {
        Q00299_BullsAndCows_2 q = new Q00299_BullsAndCows_2();
        System.out.printf("secret=%s, guess=%s: %s\n", secret, guess, q.getHint(secret, guess));
    }
}