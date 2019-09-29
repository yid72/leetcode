package dyd.leetcode;

import java.util.*;

/**
 * Same as 734. Except that:
 * Note that the similarity relation is transitive. For example, if "great" and "good" are similar, and "fine"
 * and "good" are similar, then "great" and "fine" are similar
 */
public class Q00737_SentenceSimilarity2_dfs {
    Map<String, Set<String>> ajacents;

    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1 == null || words2 == null || words1.length != words2.length) {
            return false;
        }

        ajacents = new HashMap<>();
        for (List<String> pair : pairs) {
            addEntry(ajacents, pair.get(0), pair.get(1));
            addEntry(ajacents, pair.get(1), pair.get(0));
        }

        for (int i = 0; i < words1.length; i++) {
            if (!isSimilar(words1[i], words2[i])) {
                return false;
            }
        }

        return true;
    }

    private void addEntry(Map<String, Set<String>> ajacents, String word1, String word2) {
        Set<String> set = ajacents.get(word1);
        if (set == null) {
            set = new HashSet<>();
            ajacents.put(word1, set);
        }
        set.add(word2);
    }

    private boolean isSimilar(String word1, String word2) {
        Set<String> visited = new HashSet<>();
        return dfs(word1, word2, visited);
    }

    private boolean dfs(String word1, String word2, Set<String> visited) {
        if (word1.equals(word2)) {
            return true;
        }

        visited.add(word1);

        if (ajacents.containsKey(word1)) {
            for (String neighbour : ajacents.get(word1)) {
                if (!visited.contains(neighbour)) {
                    if (dfs(neighbour, word2, visited)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Q00737_SentenceSimilarity2_dfs q = new Q00737_SentenceSimilarity2_dfs();

        String[] words1 = {"great", "acting", "skills"};
        String[] words2 = {"fine", "drama", "talent"};
        List<List<String>> pairs = new ArrayList<>();
        pairs.add(Arrays.asList("great", "fine"));
        pairs.add(Arrays.asList("acting", "drama"));
        pairs.add(Arrays.asList("skills", "talent"));
        System.out.println(q.areSentencesSimilarTwo(words1, words2, pairs));

        words1 = new String[] {"great"};
        words2 = new String[] {"great"};
        pairs = new ArrayList<>();
        System.out.println(q.areSentencesSimilarTwo(words1, words2, pairs));

        words1 = new String[] {"great"};
        words2 = new String[] {"great", "teacher"};
        pairs = new ArrayList<>();
        System.out.println(q.areSentencesSimilarTwo(words1, words2, pairs));

        words1 = new String[] {"great", "acting", "skills"};
        words2 = new String[] {"fine", "drama", "talent"};
        pairs = new ArrayList<>();
        pairs.add(Arrays.asList("great", "good"));
        pairs.add(Arrays.asList("fine", "good"));
        pairs.add(Arrays.asList("acting", "drama"));
        pairs.add(Arrays.asList("skills", "talent"));
        System.out.println(q.areSentencesSimilarTwo(words1, words2, pairs));
    }

}
