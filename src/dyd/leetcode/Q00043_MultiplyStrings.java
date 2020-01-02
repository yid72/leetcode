package dyd.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also
 * represented as a string.
 *
 * Example 1:
 *
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * Example 2:
 *
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 * Note:
 *
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contain only digits 0-9.
 * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class Q00043_MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.length() == 0 || num2.length() == 0 || num1.charAt(0) == '0' || num2.charAt(0) == '0') {
            return "0";
        }

        List<Integer> numList1 = string2List(num1);
        List<Integer> numList2 = string2List(num2);

        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < numList2.size(); i++) {
            List<Integer> product = multiply(numList1, numList2.get(i), i);
            results = add(results, product);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = results.size() - 1; i >= 0; i--) {
            sb.append(results.get(i));
        }
        return sb.toString();
    }

    private List<Integer> string2List(String num) {
        List<Integer> ret = new ArrayList<>();
        for (int i = num.length() - 1; i >= 0; i--) {
            ret.add(num.charAt(i) - '0');
        }
        return ret;
    }

    private List<Integer> multiply(List<Integer> num, int digit, int shift) {
        List<Integer> product = new ArrayList<>();
        int carry = 0;
        for (int i = 0; i < num.size(); i++) {
            int p = digit * num.get(i) + carry;
            product.add(p % 10);
            carry = p / 10;
        }
        if (carry > 0) {
            product.add(carry);
        }

        for (int i = 0; i < shift; i++) {
            product.add(0, 0);
        }
        return product;
    }

    private List<Integer> add(List<Integer> num1, List<Integer> num2) {
        List<Integer> ret = new ArrayList<>();

        int i = 0;
        int carry = 0;
        for (; i < Math.min(num1.size(), num2.size()); i++) {
            int sum = num1.get(i) + num2.get(i) + carry;
            ret.add(sum % 10);
            carry = sum / 10;
        }

        for (; i < num1.size(); i++) {
            int sum = num1.get(i) + carry;
            ret.add(sum % 10);
            carry = sum / 10;
        }

        for (; i < num2.size(); i++) {
            int sum = num2.get(i) + carry;
            ret.add(sum % 10);
            carry = sum / 10;
        }

        if (carry > 0) {
            ret.add(carry);
        }

        return ret;
    }

    public static void main(String[] args) {
        test("2", "3");
        test("23", "9");
        test("123", "456");
        test("0", "12345");
    }

    private static void test(String num1, String num2) {
        Q00043_MultiplyStrings q = new Q00043_MultiplyStrings();
        System.out.printf("num1=%s, num2=%s: %s\n", num1, num2, q.multiply(num1, num2));
    }
}
