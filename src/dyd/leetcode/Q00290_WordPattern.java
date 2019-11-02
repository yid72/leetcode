package dyd.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in
 * str.
 *
 * Example 1:
 *
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 * Example 2:
 *
 * Input:pattern = "abba", str = "dog cat cat fish"
 * Output: false
 * Example 3:
 *
 * Input: pattern = "aaaa", str = "dog cat cat dog"
 * Output: false
 * Example 4:
 *
 * Input: pattern = "abba", str = "dog dog dog dog"
 * Output: false
 */
public class Q00290_WordPattern {
    public boolean wordPattern(String pattern, String str) {
        if (pattern.length() == 0 && str.length() == 0) {
            return true;
        } else if (pattern.length() == 0 || str.length() == 0) {
            return false;
        }

        String[] words = str.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> charToWords = new HashMap<>();
        Map<String, Character> wordToChars = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if (charToWords.containsKey(ch)) {
                if (!charToWords.get(ch).equals(words[i])) {
                    return false;
                }
            } else if (wordToChars.containsKey(words[i])) {
                return false;
            } else {
                charToWords.put(ch, words[i]);
                wordToChars.put(words[i], ch);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        test("", "");
        test("abba", "dog cat");
        test("abba", "dog cat cat dog");
        test("abba", "dog cat cat fish");
        test("aaaa", "dog cat cat dog");
        test("abba", "dog dog dog dog");
    }

    private static void test(String pattern, String str) {
        System.out.println("pattern=" + pattern + ", words=" + str);
        Q00290_WordPattern q = new Q00290_WordPattern();
        System.out.println(q.wordPattern(pattern, str));
    }
}
