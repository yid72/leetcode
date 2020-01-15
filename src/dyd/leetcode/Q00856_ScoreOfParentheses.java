package dyd.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 856. Score of Parentheses -- Medium
 *
 * Given a balanced parentheses string S, compute the score of the string based on the following rule:
 *
 * () has score 1
 * AB has score A + B, where A and B are balanced parentheses strings.
 * (A) has score 2 * A, where A is a balanced parentheses string.
 *
 *
 * Example 1:
 *
 * Input: "()"
 * Output: 1
 * Example 2:
 *
 * Input: "(())"
 * Output: 2
 * Example 3:
 *
 * Input: "()()"
 * Output: 2
 * Example 4:
 *
 * Input: "(()(()))"
 * Output: 6
 */
public class Q00856_ScoreOfParentheses {
    public int scoreOfParentheses(String S) {
        Stack<Integer> scores = new Stack<>();

        int score = 0;
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (ch == '(') {
                if (!scores.isEmpty() && scores.peek() == 1) {
                    scores.pop();
                    scores.push(0);
                }
                scores.push(1);
            } else if (ch == ')') {
                int curScore = scores.pop();
                if (!scores.isEmpty()) {
                    int parentScore = scores.pop();
                    parentScore += 2 * curScore;
                    scores.push(parentScore);
                } else {
                    score += curScore;
                }
            }
        }
        return score;
    }

    public static void main(String[] args) {
        test("()");
        test("()()");
        test("(())");
        test("(()(()))");
    }

    private static void test(String S) {
        Q00856_ScoreOfParentheses q = new Q00856_ScoreOfParentheses();
        System.out.printf("S=%s, score=%d\n", S, q.scoreOfParentheses(S));
    }
}
