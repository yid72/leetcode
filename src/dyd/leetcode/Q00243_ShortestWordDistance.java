package dyd.leetcode;

import java.util.Arrays;

/**
 * 243. Shortest Word Distance -- Easy
 *
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the
 * list.
 *
 * Example:
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 *
 * Input: word1 = “coding”, word2 = “practice”
 * Output: 3
 * Input: word1 = "makes", word2 = "coding"
 * Output: 1
 * Note:
 * You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */
public class Q00243_ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int minDistance = Integer.MAX_VALUE;
        int index1 = -1;
        int index2 = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                index1 = i;
            } else if (words[i].equals(word2)) {
                index2 = i;
            }

            if (index1 != -1 && index2 != -1) {
                minDistance = Math.min(minDistance, Math.abs(index1 - index2));
            }
        }
        return minDistance;
    }

    public static void main(String[] args) {
        String[] words = new String[] {"practice", "makes", "perfect", "coding", "makes"};
        test(words, "coding", "practice");
        test(words, "makes", "coding");
    }

    private static void test(String[] words, String word1, String word2) {
        Q00243_ShortestWordDistance q = new Q00243_ShortestWordDistance();
        System.out.printf("words=%s\n", Arrays.toString(words));
        System.out.printf("word1=%s, word2=%s: %d\n", word1, word2, q.shortestDistance(words, word1, word2));
    }
}
