package dyd.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1160. Find Words That Can Be Formed by Characters -- Easy
 *
 * You are given an array of strings words and a string chars.
 *
 * A string is good if it can be formed by characters from chars (each character can only be used once).
 *
 * Return the sum of lengths of all good strings in words.
 *
 * Example 1:
 *
 * Input: words = ["cat","bt","hat","tree"], chars = "atach"
 * Output: 6
 * Explanation:
 * The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
 * Example 2:
 *
 * Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * Output: 10
 * Explanation:
 * The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
 *
 *
 * Note:
 *
 * 1 <= words.length <= 1000
 * 1 <= words[i].length, chars.length <= 100
 * All strings contain lowercase English letters only.
 */
public class Q01160_FindWordsThatCanBeFormedByCharacters {
    private Map<Character, Integer> countChars;

    public int countCharacters(String[] words, String chars) {
        countChars = counts(chars);

        int totalLength = 0;
        for (String word : words) {
            if (isGood(word)) {
                totalLength += word.length();
            }
        }
        return totalLength;
    }

    private Map<Character, Integer> counts(String str) {
        Map<Character, Integer> counts = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            counts.put(ch, counts.getOrDefault(ch, 0) + 1);
        }
        return counts;
    }

    private boolean isGood(String str) {
        Map<Character, Integer> counts = counts(str);
        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            if (!countChars.containsKey(entry.getKey()) || countChars.get(entry.getKey()) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        test(new String[] {"cat","bt","hat","tree"}, "atach");
        test(new String[] {"hello","world","leetcode"}, "welldonehoneyr");
    }

    private static void test(String[] words, String chars) {
        System.out.println(Arrays.toString(words));
        System.out.println(chars);
        Q01160_FindWordsThatCanBeFormedByCharacters q = new Q01160_FindWordsThatCanBeFormedByCharacters();
        System.out.println(q.countCharacters(words, chars));
    }
}
