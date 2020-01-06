package dyd.leetcode;

/**
 * 91. Decode Ways -- Medium
 *
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 *
 * Example 1:
 *
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * Example 2:
 *
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */
public class Q00091_DecodeWays {

    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        } else if (s.length() == 1) {
            return isValid1Character(s, 0) ? 1 : 0;
        }

        int dp1 = 0;
        int dp2 = 0;
        if (s.length() >= 1) {
            dp1 = isValid1Character(s, 0) ? 1 : 0;
        }
        if (s.length() >= 2) {
            dp2 = num2CharacterLetter(s, 0);
        }

        for (int i = 2; i < s.length(); i++) {
            int num = 0;
            int temp = num2CharacterLetter(s, i - 1);
            if (temp == 2) {
                num = temp;
            } else if (temp == 1) {

            }
            if (isValid1Character(s, i)) {
                num += dp2;
            }

            if (num2CharacterLetter(s, i - 1) == 2) {
                num += dp1;
            }

            dp1 = dp2;
            dp2 = num;
        }
        return dp2;
    }

    private boolean isValid1Character(String s, int pos) {
        return s.charAt(pos) > '0' && s.charAt(pos) <= '9';
    }

    private int num2CharacterLetter(String s, int pos) {
        char ch1 = s.charAt(pos);
        char ch2 = s.charAt(pos + 1);
        if (ch1 <= '2' && ch1 > '0' && ch2 <= '6' && ch2 >= '0') {
            return ch2 > '0' ? 2 : 1;
        } else {
            return (ch1 == '0' || ch2 == '0') ? 0 : 1;
        }
    }

    public static void main(String[] args) {
//        test("0");
//        test("1");
//        test("10");
//        test("12");
//        test("226");
        test("110");
    }

    private static void test(String s) {
        Q00091_DecodeWays q = new Q00091_DecodeWays();
        System.out.println(s + ": " + q.numDecodings(s));
    }
}
