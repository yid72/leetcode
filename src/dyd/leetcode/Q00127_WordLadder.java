package dyd.leetcode;

import java.util.*;

/**
 * 127. Word Ladder -- Medium
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation
 * sequence from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 *
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output: 5
 *
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Example 2:
 *
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: 0
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
public class Q00127_WordLadder {
    private int[][] matrix;
    private boolean[][] visited;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int endWordIndex = wordList.indexOf(endWord);
        if (endWordIndex == -1) {
            return 0;
        }

        int beginWordIndex = wordList.indexOf(beginWord);
        if (beginWordIndex == endWordIndex) {
            return 0;
        }

        if (beginWordIndex == -1) {
            List<String> newWordList = new ArrayList();
            newWordList.add(beginWord);
            newWordList.addAll(wordList);

            wordList = newWordList;
            beginWordIndex = 0;
            endWordIndex ++;
        }

        buildAjacentMatrix(wordList);
        return bfs(beginWordIndex, endWordIndex);
    }

    private void buildAjacentMatrix(List<String> wordList) {
        int len = wordList.size() + 1;
        matrix = new int[len][len];
        for (int i = 0; i < wordList.size() - 1; i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                int oneDistance = computeDistance(wordList.get(i), wordList.get(j)) == 1 ? 1 : 0;
                matrix[i][j] = oneDistance;
                matrix[j][i] = oneDistance;
            }
        }

        visited = new boolean[len][len];
    }

    private int computeDistance(String word1, String word2) {
        int differences = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                differences ++;
            }
        }
        return differences;
    }

    private int bfs(int startWordIndex, int endWordIndex) {
        Queue<Integer> queue = new LinkedList();
        queue.add(startWordIndex);
        int level = 0;
        while (!queue.isEmpty()) {
            level ++;

            Queue<Integer> nextLevel = new LinkedList();
            while (!queue.isEmpty()) {
                int curWord = queue.poll();
                if (curWord == endWordIndex) {
                    return level;
                }

                for (int i = 0; i < matrix[0].length; i++) {
                    if (matrix[curWord][i] == 1 && !visited[curWord][i]) {
                        nextLevel.add(i);
                        visited[curWord][i] = true;
                    }
                }
            }

            queue = nextLevel;
        }
        return 0;
    }

    public static void main(String[] args) {
        test("hit", "cog", Arrays.asList(new String[] {"hot","dot","dog","lot","log","cog"}));
        test("hit", "cog", Arrays.asList(new String[] {"hot","dot","dog","lot","log"}));
        test("a", "c", Arrays.asList(new String[] {"a","b","c"}));
        test("a", "c", Arrays.asList(new String[] {"a","c","b"}));
        test("a", "c", Arrays.asList(new String[] {"c","b","a"}));
    }

    private static void test(String beginWord, String endWord, List<String> wordList) {
        System.out.println("being=" + beginWord + ", end=" + endWord + ", " + wordList);
        Q00127_WordLadder q = new Q00127_WordLadder();
        System.out.println(q.ladderLength(beginWord, endWord, wordList));
    }
}
