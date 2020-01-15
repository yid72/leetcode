package dyd.leetcode;

import java.util.Stack;

/**
 * 921. Minimum Add to Make Parentheses Valid -- Medium
 *
 * Given a string S of '(' and ')' parentheses, we add the minimum number of parentheses ( '(' or ')', and in any
 * positions ) so that the resulting parentheses string is valid.
 *
 * Formally, a parentheses string is valid if and only if:
 *
 * It is the empty string, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 * Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.
 *
 * Example 1:
 *
 * Input: "())"
 * Output: 1
 * Example 2:
 *
 * Input: "((("
 * Output: 3
 * Example 3:
 *
 * Input: "()"
 * Output: 0
 * Example 4:
 *
 * Input: "()))(("
 * Output: 4
 *
 *
 * Note:
 *
 * S.length <= 1000
 * S only consists of '(' and ')' characters.
 */
public class Q00921_MinimumAddToMakeParenthesesValid {
    public int minAddToMakeValid(String S) {
        int minAdd = 0;
        int left = 0;
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (ch == '(') {
                left ++;
            } else {
                if (left > 0) {
                    left --;
                } else {
                    minAdd ++;
                }
            }
        }
        return minAdd + left;
    }

    public static void main(String[] args) {
        test("())");
        test("(((");
        test("()");
        test("()))((");
    }

    private static void test(String S) {
        Q00921_MinimumAddToMakeParenthesesValid q = new Q00921_MinimumAddToMakeParenthesesValid();
        System.out.printf("S=%s, minAdd=%d\n", S, q.minAddToMakeValid(S));
    }
}
