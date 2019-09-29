package dyd.leetcode;

import java.util.*;

/**
 * Given two sentences words1, words2 (each represented as an array of strings), and a list of similar word pairs pairs, determine if two sentences are similar.
 *
 * For example, "great acting skills" and "fine drama talent" are similar, if the similar word pairs are pairs = [["great", "fine"], ["acting","drama"], ["skills","talent"]].
 *
 * Note that the similarity relation is not transitive. For example, if "great" and "fine" are similar, and "fine" and "good" are similar, "great" and "good" are not necessarily similar.
 *
 * However, similarity is symmetric. For example, "great" and "fine" being similar is the same as "fine" and "great" being similar.
 *
 * Also, a word is always similar with itself. For example, the sentences words1 = ["great"], words2 = ["great"], pairs = [] are similar, even though there are no specified similar word pairs.
 *
 * Finally, sentences can only be similar if they have the same number of words. So a sentence like words1 = ["great"] can never be similar to words2 = ["doubleplus","good"].
 *
 * Note:
 *
 * The length of words1 and words2 will not exceed 1000.
 * The length of pairs will not exceed 2000.
 * The length of each pairs[i] will be 2.
 * The length of each words[i] and pairs[i][j] will be in the range [1, 20].
 */
public class Q00734_SentenceSimilarity {
    private Map<String, Set<String>> similarWords;

    public boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1 == null || words2 == null || words1.length != words2.length) {
            return false;
        }

        similarWords = new HashMap<>();
        for (List<String> pair : pairs) {
            Set<String> set = similarWords.get(pair.get(0));
            if (set == null) {
                set = new HashSet<>();
                similarWords.put(pair.get(0), set);
            }
            set.add(pair.get(1));
        }

        for (int i = 0; i < words1.length; i++) {
            if (!isSimilar(words1[i], words2[i])) {
                return false;
            }
        }

        return true;
    }

    private boolean isSimilar(String word1, String word2) {
        return word1.equals(word2)
                || similarWords.containsKey(word1) && similarWords.get(word1).contains(word2)
                || similarWords.containsKey(word2) && similarWords.get(word2).contains(word1);
    }

    public static void main(String[] args) {
        Q00734_SentenceSimilarity q = new Q00734_SentenceSimilarity();

        String[] words1 = {"great", "acting", "skills"};
        String[] words2 = {"fine", "drama", "talent"};
        List<List<String>> pairs = new ArrayList<>();
        pairs.add(Arrays.asList("great", "fine"));
        pairs.add(Arrays.asList("acting", "drama"));
        pairs.add(Arrays.asList("skills", "talent"));
        System.out.println(q.areSentencesSimilar(words1, words2, pairs));

        words1 = new String[] {"great"};
        words2 = new String[] {"great"};
        pairs = new ArrayList<>();
        System.out.println(q.areSentencesSimilar(words1, words2, pairs));

        words1 = new String[] {"great"};
        words2 = new String[] {"great", "teacher"};
        pairs = new ArrayList<>();
        System.out.println(q.areSentencesSimilar(words1, words2, pairs));
    }
}
