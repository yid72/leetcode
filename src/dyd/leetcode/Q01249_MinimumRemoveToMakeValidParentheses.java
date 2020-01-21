package dyd.leetcode;

/**
 * 1249. Minimum Remove to Make Valid Parentheses -- Medium
 *
 * Given a string s of '(' , ')' and lowercase English characters.
 *
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.
 *
 * Formally, a parentheses string is valid if and only if:
 *
 * It is the empty string, contains only lowercase characters, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 *
 *
 * Example 1:
 *
 * Input: s = "lee(t(c)o)de)"
 * Output: "lee(t(c)o)de"
 * Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
 * Example 2:
 *
 * Input: s = "a)b(c)d"
 * Output: "ab(c)d"
 * Example 3:
 *
 * Input: s = "))(("
 * Output: ""
 * Explanation: An empty string is also valid.
 * Example 4:
 *
 * Input: s = "(a(b(c)d)"
 * Output: "a(b(c)d)"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 10^5
 * s[i] is one of  '(' , ')' and lowercase English letters.
 */
public class Q01249_MinimumRemoveToMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                left ++;
            } else if (ch == ')') {
                if (left == 0) {
                    // remove the right parenthese
                    continue;
                } else {
                    left --;
                }
            }
            sb.append(ch);
        }

        String newS = sb.toString();
        if (left == 0) {
            return newS;
        }

        sb = new StringBuilder();
        left = 0;
        int right = 0;
        for (int i = newS.length() - 1; i >= 0; i --) {
            char ch = newS.charAt(i);
            if (ch == ')') {
                right ++;
            } else if (ch == '(') {
                if (left == right) {
                    continue;
                } else {
                    left ++;
                }
            }
            sb.append(ch);
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        test("())");
        test("(()");
        test("(()))(");
    }

    private static void test(String s) {
        Q01249_MinimumRemoveToMakeValidParentheses q = new Q01249_MinimumRemoveToMakeValidParentheses();
        System.out.printf("%s > %s\n", s, q.minRemoveToMakeValid(s));
    }
}
