package dyd.leetcode.contests.p20191012;

import java.util.*;

public class Q4 {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        List<Set<Character>> uniqueChars = new ArrayList();
        for (int i = 0; i < words.length; i++) {
            uniqueChars.add(uniqueChars(words[i]));
        }
        return 0;
    }

    private Set<Character> uniqueChars(String words) {
        Set<Character> chars = new HashSet<>();
        for (int i = 0; i < words.length(); i++) {
            char ch = words.charAt(i);
            if (chars.contains(ch)) {
                return chars;
            }
            chars.add(ch);
        }
        return chars;
    }

    public List<List<Set<Character>>> combinations(List<Set<Character>> words, int pos) {
        return null;
    }

    private boolean overlap(Set<Character> word1, Set<Character> word2) {
        for (Character ch : word1) {
            if (word2.contains(ch)) {
                return true;
            }
        }

        for (Character ch : word2) {
            if (word1.contains(ch)) {
                return true;
            }
        }

        return false;
    }
}
