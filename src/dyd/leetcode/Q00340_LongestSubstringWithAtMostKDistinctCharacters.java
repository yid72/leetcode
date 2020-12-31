package dyd.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 340. Longest Substring with At Most K Distinct Characters -- Medium
 *
 * Given a string s and an integer k, return the length of the longest substring of s that contains at most k distinct characters.
 *
 * Example 1:
 *
 * Input: s = "eceba", k = 2
 * Output: 3
 * Explanation: The substring is "ece" with length 3.
 * Example 2:
 *
 * Input: s = "aa", k = 1
 * Output: 2
 * Explanation: The substring is "aa" with length 2.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 5 * 104
 * 0 <= k <= 50
 */
public class Q00340_LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k <= 0) {
            return 0;
        }

        if (k >= s.length()) {
            return s.length();
        }

        Map<Character, Integer> indices = new HashMap<>();
        int maxLength = 0;
        int curStart = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (indices.size() == k && !indices.containsKey(ch)) {
                char startCh = s.charAt(curStart);
                int end = indices.get(startCh);
                for (int j = curStart; j <= end; j++) {
                    char curCh = s.charAt(j);
                    if (j == indices.get(curCh)) {
                        indices.remove(curCh);
                    }
                    if (indices.size() < k) {
                        curStart = j + 1;
                        break;
                    }
                }
            }
            indices.put(ch, i);
            maxLength = Math.max(maxLength, i - curStart + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        test("eceba", 2);
        test("a", 0);
        test("aba", 1);
        test("abaccc", 2);
    }

    private static void test(String s, int k) {
        Q00340_LongestSubstringWithAtMostKDistinctCharacters q = new Q00340_LongestSubstringWithAtMostKDistinctCharacters();
        System.out.printf("s=%s, k=%d: %d\n", s, k, q.lengthOfLongestSubstringKDistinct(s, k));
    }
}
