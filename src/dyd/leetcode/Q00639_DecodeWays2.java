package dyd.leetcode;

import java.util.Arrays;

/**
 * 639. Decode Ways II -- Hard
 *
 * A message containing letters from A-Z is being encoded to numbers using the following mapping way:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Beyond that, now the encoded string can also contain the character '*', which can be treated as one of the numbers from 1 to 9.
 *
 * Given the encoded message containing digits and the character '*', return the total number of ways to decode it.
 *
 * Also, since the answer may be very large, you should return the output mod 109 + 7.
 *
 * Example 1:
 * Input: "*"
 * Output: 9
 * Explanation: The encoded message can be decoded to the string: "A", "B", "C", "D", "E", "F", "G", "H", "I".
 * Example 2:
 * Input: "1*"
 * Output: 9 + 9 = 18
 * Note:
 * The length of the input string will fit in range [1, 105].
 * The input string will only contain the character '*' and digits '0' - '9'.
 */
public class Q00639_DecodeWays2 {
    private static final long MAX = 1000000007L;
    private long[] dp;

    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }

        dp = new long[s.length()];
        Arrays.fill(dp, -1);

        return (int) numDecodings(s, 0);
    }

    private long numDecodings(String s, int start) {
        if (start >= s.length()) {
            return 1;
        }

        if (s.charAt(start) == '0') {
            return 0;
        }

        if (dp[start] != -1) {
            return dp[start];
        }

        if (s.charAt(start) == '*') {
            dp[start] = 9 * numDecodings(s, start + 1);
        } else {
            dp[start] = numDecodings(s, start + 1);
        }
        dp[start] = dp[start] % MAX;

        if (start + 2 <= s.length()) {
            dp[start] += numDecodingsForTwoChars(s.substring(start, start + 2)) * numDecodings(s, start + 2);
        }

        dp[start] = dp[start] % MAX;

        return dp[start];
    }

    private int numDecodingsForTwoChars(String s) {
        if (s.charAt(0) == '*' && s.charAt(1) == '*') {
            return 15;
        } else if (s.charAt(0) == '*') {
            if (s.charAt(1) <= '6') {
                return 2;
            } else {
                return 1;
            }
        } else if (s.charAt(1) == '*') {
            if (s.charAt(0) == '1') {
                return 9;
            } else if (s.charAt(0) == '2') {
                return 6;
            } else {
                return 0;
            }
        } else {
            return Integer.parseInt(s) <= 26 ? 1 : 0;
        }
    }

    public static void main(String[] args) {
        test("*");
        test("1*");
        test("*1");
        test("**");
    }

    private static void test(String s) {
        Q00639_DecodeWays2 q = new Q00639_DecodeWays2();
        System.out.printf("%s: %d\n", s, q.numDecodings(s));
    }
}
