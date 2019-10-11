package dyd.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * n an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The
 * order of the alphabet is some permutation of lowercase letters.
 *
 * Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if
 * the given words are sorted lexicographicaly in this alien language.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 * Example 2:
 *
 * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * Output: false
 * Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
 * Example 3:
 *
 * Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * Output: false
 * Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to
 * lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less
 * than any other character (More info).
 *
 *
 * Note:
 *
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * order.length == 26
 * All characters in words[i] and order are english lowercase letters.
 */
public class Q00953_VerifyingAnAlienDictionary {
    private Map<Character, Integer> characterOrders = new HashMap<>();

    public boolean isAlienSorted(String[] words, String order) {
        characterOrders.clear();
        for (int i = 0; i < order.length(); i++) {
            characterOrders.put(order.charAt(i), i);
        }

        for (int i = 1; i < words.length; i++) {
            if (compare(words[i], words[i-1]) < 0) {
                return false;
            }
        }

        return true;
    }

    private int compare(String word1, String word2) {
        if (word1.length() == 0 && word2.length() == 0) {
            return 0;
        }

        int minSize = Math.min(word1.length(), word2.length());
        for (int i = 0; i < minSize; i++) {
            int index1 = characterOrders.get(word1.charAt(i));
            int index2 = characterOrders.get(word2.charAt(i));
            if (index1 < index2) {
                return -1;
            } else if (index1 > index2) {
                return 1;
            }
        }

        return word1.length() > word2.length() ? 1 : -1;
    }

    public static void main(String[] args) {
        test(new String[] {"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz");
        test(new String[] {"word","world","row"}, "worldabcefghijkmnpqstuvxyz");
        test(new String[] {"apple","app"}, "abcdefghijklmnopqrstuvwxyz");
    }

    private static void test(String[] words, String order) {
        System.out.println(Arrays.toString(words));
        System.out.println("Order: " + order);
        Q00953_VerifyingAnAlienDictionary q = new Q00953_VerifyingAnAlienDictionary();
        System.out.println(q.isAlienSorted(words, order));
    }
}
