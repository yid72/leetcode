package dyd.leetcode;

import java.util.*;

/**
 * 244. Shortest Word Distance II -- Medium
 *
 * Design a class which receives a list of words in the constructor, and implements a method that takes two words word1
 * and word2 and return the shortest distance between these two words in the list. Your method will be called repeatedly
 * many times with different parameters.
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
public class Q00244_ShortestWordDistance2 {
    private Map<String, List<Integer>> indices;

    public Q00244_ShortestWordDistance2(String[] words) {
        indices = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            indices.putIfAbsent(words[i], new ArrayList<>());
            indices.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> indices1 = indices.get(word1);
        List<Integer> indices2 = indices.get(word2);
        int i = 0;
        int j = 0;
        int minDistance = Integer.MAX_VALUE;
        while (i < indices1.size() && j < indices2.size()) {
            int index1 = indices1.get(i);
            int index2 = indices2.get(j);
            minDistance = Math.min(Math.abs(index1 - index2), minDistance);
            if (index1 < index2) {
                i ++;
            } else {
                j ++;
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
        Q00244_ShortestWordDistance2 q = new Q00244_ShortestWordDistance2(words);
        System.out.printf("words=%s\n", Arrays.toString(words));
        System.out.printf("word1=%s, word2=%s: %d\n", word1, word2, q.shortest(word1, word2));
    }
}
