package dyd.leetcode;

public class Q00043_MultipleStrings_2 {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        int[] results = new int[num1.length() + num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                results[(num1.length() - 1 - i) + (num2.length() - 1 - j)]
                        += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }

        for (int i = 1; i < results.length; i++) {
            results[i] += results[i - 1]/10;
            results[i - 1] = results[i - 1] % 10;
        }

        int highest = results.length - 1;
        for (; highest >= 0 && results[highest] == 0; highest --);

        StringBuilder sb = new StringBuilder();
        for (int i = highest; i >= 0; i--) {
            sb.append(results[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        test("2", "3");
        test("23", "9");
        test("123", "456");
        test("0", "12345");
    }

    private static void test(String num1, String num2) {
        Q00043_MultipleStrings_2 q = new Q00043_MultipleStrings_2();
        System.out.printf("num1=%s, num2=%s: %s\n", num1, num2, q.multiply(num1, num2));
    }
}