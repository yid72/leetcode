package dyd.leetcode;

import java.util.Stack;

/**
 * 227. Basic Calculator II -- Medium
 *
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer
 * division should truncate toward zero.
 *
 * Example 1:
 *
 * Input: "3+2*2"
 * Output: 7
 * Example 2:
 *
 * Input: " 3/2 "
 * Output: 1
 * Example 3:
 *
 * Input: " 3+5 / 2 "
 * Output: 5
 * Note:
 *
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 */
public class Q00227_BasicCalculator2 {
    private Stack<Integer> operands;
    private Stack<Character> operators;

    public int calculate(String s) {
        operands = new Stack<>();
        operators = new Stack<>();

        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int j = i + 1;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    j ++;
                }
                int operand = Integer.parseInt(s.substring(i, j));
                operands.push(operand);
                i = j;
                continue;
            } else if (ch == '+' || ch == '-') {
                calculateAll();
                operators.push(ch);
            } else if (ch == '*' || ch == '/') {
                if (!operators.isEmpty()) {
                    char prevOperator = operators.peek();
                    if (prevOperator == '*' || prevOperator == '/') {
                        calculateTop();
                    }
                }
                operators.push(ch);
            }

            i ++;
        }

        calculateAll();

        return operands.pop();
    }

    private void calculateAll() {
        while (!operators.isEmpty()) {
            calculateTop();
        }
    }

    private void calculateTop() {
        if (operators.isEmpty()) {
            return;
        }

        int op2 = operands.pop();
        int op1 = operands.pop();
        int result = 0;
        switch (operators.pop()) {
            case '+':
                result = op1 + op2;
                break;

            case '-':
                result = op1 - op2;
                break;

            case '*':
                result = op1 * op2;
                break;

            case '/':
                result = op1/op2;
                break;
        }

        operands.push(result);
    }

    public static void main(String[] args) {
//        test("1+1");
//        test("1-1");g
//        test("3+2*2/2");
//        test(" 3 / 2");
//        test(" 3+5 / 2 ");
        test("1*2-3/4+5*6-7*8+9/10");
    }

    private static void test(String s) {
        Q00227_BasicCalculator2 q = new Q00227_BasicCalculator2();
        System.out.printf("s=%s: %s\n", s, q.calculate(s));
    }
}
