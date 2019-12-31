package dyd.leetcode;

import java.util.*;

/**
 * 269. Alien Dictionary -- Hard
 *
 * There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You
 * receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this
 * new language. Derive the order of letters in this language.
 *
 * Example 1:
 *
 * Input:
 * [
 *   "wrt",
 *   "wrf",
 *   "er",
 *   "ett",
 *   "rftt"
 * ]
 *
 * Output: "wertf"
 * Example 2:
 *
 * Input:
 * [
 *   "z",
 *   "x"
 * ]
 *
 * Output: "zx"
 * Example 3:
 *
 * Input:
 * [
 *   "z",
 *   "x",
 *   "z"
 * ]
 *
 * Output: ""
 *
 * Explanation: The order is invalid, so return "".
 * Note:
 *
 * You may assume all letters are in lowercase.
 * You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
 * If the order is invalid, return an empty string.
 * There may be multiple valid order of letters, return any one of them is fine.
 */
public class Q00269_AlienDictionary {
    private static final int MAX_NUMBER = 26;

    private Map<Integer, List<Integer>> adjacentLists;
    private boolean[] visited;
    private Stack<Integer> paths;

    public Q00269_AlienDictionary() {
        adjacentLists = new HashMap<>();
        paths = new Stack<>();
        visited = new boolean[MAX_NUMBER];
    }

    public String alienOrder(String[] words) {
        if (words.length == 0) {
            return "";
        }

        addWord(words[0]);

        for (int i = 1; i < words.length; i++) {
            addRelation(words[i - 1], words[i]);
        }

        for (int i : adjacentLists.keySet()) {
            if (!visited[i] && !dfs(i, new ArrayList<>())) {
                return "";
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!paths.isEmpty()) {
            sb.append((char) (paths.pop() + 'a'));
        }
        return sb.toString();
    }

    private void addRelation(String word1, String word2) {
        addWord(word1);
        addWord(word2);

        int i = 0;
        for (; i < Math.min(word1.length(), word2.length()); i++) {
            char ch1 = word1.charAt(i);
            char ch2 = word2.charAt(i);
            if (ch1 != ch2) {
                adjacentLists.putIfAbsent(ch1 - 'a', new ArrayList<>());
                adjacentLists.get(ch1 - 'a').add(ch2 - 'a');
                return;
            }
        }
    }

    private void addWord(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (!adjacentLists.containsKey(word.charAt(i) - 'a')) {
                adjacentLists.put(word.charAt(i) - 'a', new ArrayList<>());
            }
        }
    }

    private boolean dfs(int i, List<Integer> currentPath) {
        if (visited[i]) {
            return true;
        }

        visited[i] = true;

        if (adjacentLists.containsKey(i)) {
            currentPath.add(i);
            for (int j : adjacentLists.get(i)) {
                if (currentPath.contains(j)) {
                    return false;
                } else if (!dfs(j, currentPath)) {
                    return false;
                }
            }
            currentPath.remove(currentPath.size() - 1);
        }

        paths.push(i);
        return true;
    }

    public static void main(String[] args) {
        test(new String[] {"wrt", "wrf", "er", "ett", "rftt"});
        test(new String[] {"z", "x"});
        test(new String[] {"z", "x", "z"});
        test(new String[] {"z", "z"});
        test(new String[] {"wnlb"});
    }

    private static void test(String[] words) {
        Q00269_AlienDictionary q = new Q00269_AlienDictionary();
        System.out.printf("words=%s: %s\n", Arrays.toString(words), q.alienOrder(words));
    }
}
