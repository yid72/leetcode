package dyd.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Given two strings s and t which consist of only lowercase letters.
 *
 * String t is generated by random shuffling string s and then add one more letter at a random position.
 *
 * Find the letter that was added in t.
 *
 * Example:
 *
 * Input:
 * s = "abcd"
 * t = "abcde"
 *
 * Output:
 * e
 *
 * Explanation:
 * 'e' is the letter that was added.
 */
public class Q00389_FindTheDifference {
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> characterCounts = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            int curCount = characterCounts.getOrDefault(ch, 0);
            characterCounts.put(ch, curCount + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!characterCounts.containsKey(ch)) {
                return ch;
            }
            int curCount = characterCounts.get(ch);
            if (curCount == 1) {
                characterCounts.remove(ch);
            } else {
                characterCounts.put(ch, curCount - 1);
            }
        }

        return characterCounts.keySet().iterator().next();
    }

    public static void main(String[] args) {
        test("abcd", "abcde");
        test("abcd", "abccd");
    }

    private static void test(String s, String t) {
        Q00389_FindTheDifference q = new Q00389_FindTheDifference();
        System.out.println(s);
        System.out.println(t);
        System.out.println(q.findTheDifference(s, t));
    }
}