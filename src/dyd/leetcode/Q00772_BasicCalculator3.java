package dyd.leetcode;

import java.util.Stack;

/**
 * 772. Basic Calculator III -- Hard
 *
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
 *
 * The expression string contains only non-negative integers, +, -, *, / operators , open ( and closing parentheses ) and empty spaces . The integer division should truncate toward zero.
 *
 * You may assume that the given expression is always valid. All intermediate results will be in the range of [-2147483648, 2147483647].
 *
 * Some examples:
 *
 * "1 + 1" = 2
 * " 6-4 / 2 " = 4
 * "2*(5+5*2)/3+(6/2+8)" = 21
 * "(2+6* 3+5- (3*14/7+2)*5)+3"=-12
 *
 *
 * Note: Do not use the eval built-in library function.
 */
public class Q00772_BasicCalculator3 {
    Stack<Integer> operands = new Stack<>();
    Stack<Character> operators = new Stack<>();

    public int calculate(String s) {
        operands = new Stack<>();
        operators = new Stack<>();

        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int j = i + 1;
                while (j < s.length() && Character.isDigit(j)) {
                    j ++;
                }
                operands.push(Integer.parseInt(s.substring(i, j)));
                i = j;
                continue;
            } else if (ch == '(') {
                operators.push(ch);
            } else if (ch == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    calculateTop();
                }
                if (!operators.isEmpty() && operators.peek() == '(') {
                    operators.pop();
                }
            } else if (ch == '+' || ch == '-') {

            } else if (ch == '*' || ch == '/') {

            }
        }
        return -1;
    }

    private void calculateTop() {
        if (operators.isEmpty()) {
            return;
        }

        int result;
        int op2 = operands.pop();
        int op1 = operands.pop();
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
                result = op1 / op2;
                break;

            default:
                throw new IllegalArgumentException("Unknown operator");
        }
        operands.push(result);
    }
}
