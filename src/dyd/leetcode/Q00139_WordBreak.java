package dyd.leetcode;

import java.util.*;

/**
 * 139. Word Break -- Medium
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be
 * segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 *              Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 */
public class Q00139_WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, 0, new HashSet(wordDict), new Boolean[s.length()]);
    }

    private boolean wordBreak(String s, int start, Set<String> dict, Boolean[] memo) {
        if (start >= s.length()) {
            return true;
        }

        if (memo[start] != null) {
            return memo[start];
        }

        for (int end = start + 1; end <= s.length(); end ++) {
            if (dict.contains(s.substring(start, end)) && wordBreak(s, end, dict, memo)) {
                memo[start] = true;
                return true;
            }
        }
        memo[start] = false;
        return false;
    }

    public static void main(String[] args) {
        test("leetcode", Arrays.asList("leet", "code"));
        test("applepenapple", Arrays.asList("apple", "pen"));
        test("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"));
        test("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"));
    }

    private static void test(String s, List<String> wordDict) {
        System.out.printf("s=%s, dictionary=%s: ", s, wordDict);
        Q00139_WordBreak q = new Q00139_WordBreak();
        System.out.println(q.wordBreak(s, wordDict));
    }
}
