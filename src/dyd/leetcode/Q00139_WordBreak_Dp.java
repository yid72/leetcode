package dyd.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * DP
 */
public class Q00139_WordBreak_Dp {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length()];
        dp[0] = dict.contains(s.substring(0, 1));
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j + 1, i + 1))
                        || dict.contains(s.substring(0, i + 1))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length() - 1];
    }

    public static void main(String[] args) {
        test("a", Arrays.asList("a"));
        test("leetcode", Arrays.asList("leet", "code"));
        test("applepenapple", Arrays.asList("apple", "pen"));
        test("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"));
        test("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"));
    }

    private static void test(String s, List<String> wordDict) {
        System.out.printf("s=%s, dictionary=%s: ", s, wordDict);
        Q00139_WordBreak_Dp q = new Q00139_WordBreak_Dp();
        System.out.println(q.wordBreak(s, wordDict));
    }
}
