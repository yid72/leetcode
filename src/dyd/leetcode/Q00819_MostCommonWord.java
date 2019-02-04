package dyd.leetcode;

import java.util.*;

/**
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
 *
 * Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.
 *
 * Example:
 *
 * Input:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * Output: "ball"
 * Explanation:
 * "hit" occurs 3 times, but it is a banned word.
 * "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
 * Note that words in the paragraph are not case sensitive,
 * that punctuation is ignored (even if adjacent to words, such as "ball,"),
 * and that "hit" isn't the answer even though it occurs more because it is banned.
 *
 *
 * Note:
 *
 * 1 <= paragraph.length <= 1000.
 * 1 <= banned.length <= 100.
 * 1 <= banned[i].length <= 10.
 * The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
 * paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
 * There are no hyphens or hyphenated words.
 * Words only consist of letters, never apostrophes or other punctuation symbols.
 *
 * Results:
 * 9ms (85.55%), 261.MB (82.07%)
 */
public class Q00819_MostCommonWord {
    private static final String PUNCTUATIONS = "!?',;.";

    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedWords = new HashSet<>();
        bannedWords.addAll(Arrays.asList(banned));

        HashMap<String, Integer> wordCounts = new HashMap<>();
        List<String> words = splitLowercaseWords(paragraph);
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

    private List<String> splitLowercaseWords(String paragraph) {
        List<String> words = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < paragraph.length(); i++) {
            char ch = paragraph.charAt(i);
            if (ch == ' ' || PUNCTUATIONS.indexOf(ch) >=  0) {
                if (sb.length() > 0) {
                    words.add(sb.toString().toLowerCase());
                    sb = new StringBuilder();
                }
            } else {
                sb.append(ch);
            }
        }

        if (sb.length() > 0) {
            words.add(sb.toString().toLowerCase());
        }

        return words;
    }

    public static void main(String[] args) {
        Q00819_MostCommonWord w = new Q00819_MostCommonWord();
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        System.out.println(w.mostCommonWord(paragraph, banned));
    }
}
