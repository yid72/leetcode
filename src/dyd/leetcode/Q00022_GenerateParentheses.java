package dyd.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 22. Generate Parentheses -- Medium
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class Q00022_GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        return new ArrayList<>(helper(n));
    }

    private Set<String> helper(int n) {
        Set<String> ret = new HashSet<>();
        if (n <= 0) {
            return ret;
        } else if (n == 1) {
            ret.add("()");
            return ret;
        }

        Set<String> subs = helper(n - 1);
        for (String sub : subs) {
            ret.add("()" + sub);
            ret.add(sub + "()");
            for (int i = 1; i < sub.length(); i++) {
                ret.add("(" + sub.substring(0, i) + ")" + sub.substring(i));
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        test(0);
        test(1);
        test(2);
        test(3);
    }

    private static void test(int n) {
        Q00022_GenerateParentheses q = new Q00022_GenerateParentheses();
        System.out.printf("n=%d: %s\n", n, q.generateParenthesis(n));
    }
}
