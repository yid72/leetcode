package dyd.leetcode;

import java.util.*;

/**
 * Results: 24ms(51.01%), 29.1MB (6.2%)
 */
public class Q00819_MostCommonWord_2 {
    private static final String REGX_PUNCTUATIONS = "[\\!\\?\\'\\,\\;\\.]";
    private static final String REGX_SPACES = "\\s+";

    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedWords = new HashSet<>();
        bannedWords.addAll(Arrays.asList(banned));

        paragraph = paragraph.replaceAll(REGX_PUNCTUATIONS, " ").replaceAll(REGX_SPACES, " ");
        HashMap<String, Integer> wordCounts = new HashMap<>();
        String[] words = paragraph.split(" ");
        for (String word : words) {
            String lowercaseWord = word.toLowerCase();
            if (!bannedWords.contains(lowercaseWord)) {
                int count = 0;
                if (wordCounts.containsKey(lowercaseWord)) {
                    count = wordCounts.get(lowercaseWord);
                }
                wordCounts.put(lowercaseWord, count + 1);
            }
        }

        int max = 0;
        String mostCommonWord = "";
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                mostCommonWord = entry.getKey();
            }
        }

        return mostCommonWord;
    }

    public static void main(String[] args) {
        Q00819_MostCommonWord_2 w = new Q00819_MostCommonWord_2();
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        System.out.println(w.mostCommonWord(paragraph, banned));
    }
}
