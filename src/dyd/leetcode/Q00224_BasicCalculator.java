package dyd.leetcode;

import java.util.Stack;

public class Q00224_BasicCalculator {
    private Stack<Integer> operatorStack = new Stack<>();
    private Stack<Character> operationStack = new Stack<>();

    public int calculate(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            // Skip spaces
            while (i < s.length() && s.charAt(i) == ' ') {
                i ++;
            }

            // Parse operator
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                sb.append(s.charAt(i ++));
            }

            if (sb.length() > 0) {
                int op = Integer.parseInt(sb.toString());
                sb.delete(0, sb.length());
                operatorStack.push(op);
            }

            // Skip spaces
            while (i < s.length() && s.charAt(i) == ' ') {
                i ++;
            }

            if (i < s.length()) {
                char ch = s.charAt(i);
                if (ch == '(') {
                    operationStack.push(ch);
                } else if (ch == '+' || ch == '-') {
                    calcutelate();
                    operationStack.push(ch);
                } else if (ch == ')') {
                    calcutelate();
                    if (operationStack.peek() == '(') {
                        operationStack.pop();
                    }
                }

                i ++;
            }
        }

        if (operationStack.size() > 0) {
            calcutelate();
        }

        return operatorStack.pop();
    }

    private void calcutelate() {
        if (operationStack.size() == 0 || operatorStack.size() < 2) {
            return;
        }

        char ch = operationStack.peek();
        if (ch == '+' || ch == '-') {
            int op1 = operatorStack.pop();
            int op2 = operatorStack.pop();
            if (ch == '+') {
                operatorStack.push(op2 + op1);
            } else {
                operatorStack.push(op2 - op1);
            }
            operationStack.pop();
        }
    }

    public static void main(String[] args) {
        Q00224_BasicCalculator q = new Q00224_BasicCalculator();
        System.out.println(q.calculate("1 + 1"));
        System.out.println(q.calculate(" 2-1 + 2 "));
        System.out.println(q.calculate(" (((2-1)) + 2) "));
        System.out.println(q.calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
