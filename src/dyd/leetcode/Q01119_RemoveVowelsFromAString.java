package dyd.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string S, remove the vowels 'a', 'e', 'i', 'o', and 'u' from it, and return the new string.
 *
 *
 *
 * Example 1:
 *
 * Input: "leetcodeisacommunityforcoders"
 * Output: "ltcdscmmntyfrcdrs"
 * Example 2:
 *
 * Input: "aeiou"
 * Output: ""
 */
public class Q01119_RemoveVowelsFromAString {
    private Set<Character> vowels;

    public Q01119_RemoveVowelsFromAString() {
        vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
    }

    public String removeVowels(String S) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (!vowels.contains(ch)) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        test("leetcodeisacommunityforcoders");
        test("aeiou");
    }

    private static void test(String s) {
        Q01119_RemoveVowelsFromAString q = new Q01119_RemoveVowelsFromAString();
        System.out.println("Input: " + s);
        System.out.println("Output: " + q.removeVowels(s));
    }
}
