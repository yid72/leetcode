package dyd.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 299. Bulls and Cows  -- Easy
 *
 * You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to
 * guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in
 * said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the
 * secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to
 * eventually derive the secret number.
 *
 * Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and
 * B to indicate the cows.
 *
 * Please note that both secret number and friend's guess may contain duplicate digits.
 *
 * Example 1:
 *
 * Input: secret = "1807", guess = "7810"
 *
 * Output: "1A3B"
 *
 * Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
 * Example 2:
 *
 * Input: secret = "1123", guess = "0111"
 *
 * Output: "1A1B"
 *
 * Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.
 * Note: You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.
 */
public class Q00299_BullsAndCows {
    public String getHint(String secret, String guess) {
        Map<Character, Set<Integer>> secretIndices = count(secret);
        Map<Character, Set<Integer>> guessIndices = count(guess);

        int bulls = 0;
        int cows = 0;
        for (Map.Entry<Character, Set<Integer>> entry : guessIndices.entrySet()) {
            Set<Integer> secretIndex = secretIndices.get(entry.getKey());
            if (secretIndex != null) {
                int curBulls = 0;
                for (int guessIndex : entry.getValue()) {
                    if (secretIndex.contains(guessIndex)) {
                        curBulls ++;
                    }
                }

                int curCows = Math.min(secretIndex.size(), entry.getValue().size()) - curBulls;

                bulls += curBulls;
                cows += curCows;
            }
        }

        return String.format("%dA%dB", bulls, cows);
    }

    private Map<Character, Set<Integer>> count(String s) {
        Map<Character, Set<Integer>> indexMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            Set<Integer> indices = indexMap.get(ch);
            if (indices == null) {
                indices = new HashSet<>();
                indexMap.put(ch, indices);
            }
            indices.add(i);
        }
        return indexMap;
    }

    public static void main(String[] args) {
        test("1807", "7810");
        test("1123", "0111");
    }

    private static void test(String secret, String guess) {
        Q00299_BullsAndCows q = new Q00299_BullsAndCows();
        System.out.printf("secret=%s, guess=%s: %s\n", secret, guess, q.getHint(secret, guess));
    }
}
