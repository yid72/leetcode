package dyd.interviews.companies.fb.mianjing;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings. Check whether an anagram of the second string is a sub string of the first string. If it is,
 * returns the start position of the sub string.
 */
public class SubstringAnagram {
    public int subStringAnagram(String s1, String s2) {
        final Map<Character, Integer> characterCounts = countCharacters(s2);
        return 0;
    }

    private Map<Character, Integer> countCharacters(String s) {
        final Map<Character, Integer> characterCounts = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            final char ch = s.charAt(i);
            if (characterCounts.containsKey(ch)) {
                characterCounts.put(ch, characterCounts.get(ch) + 1);
            } else {
                characterCounts.put(ch, 1);
            }
        }
        return null;
    }
}
