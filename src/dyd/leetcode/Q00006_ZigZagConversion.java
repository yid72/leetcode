package dyd.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q00006_ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 0) {
            return "";
        } else if (numRows == 1) {
            return s;
        }

        List<Character>[] res = new ArrayList[numRows];
        for (int i = 0; i < numRows; i++) {
            res[i] = new ArrayList<>();
        }

        int index = 0;
        while (index < s.length()) {
            int row = 0;
            while (row < numRows && index < s.length()) {
                res[row ++].add(s.charAt(index ++));
            }

            row = numRows - 2;
            while (row > 0 && index < s.length()) {
                for (int i = 0; i < numRows && index < s.length(); i++) {
                    if (i == row) {
                        res[i].add(s.charAt(index ++));
                    } else {
                        res[i].add(' ');
                    }
                }
                row --;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (char ch : res[i]) {
                if (ch != ' ') {
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        test("PAYPALISHIRING", 3);
        test("PAYPALISHIRING", 4);
    }

    private static void test(String s, int numRows) {
        Q00006_ZigZagConversion q = new Q00006_ZigZagConversion();
        System.out.printf("s=%s, numRows=%d: %s\n", s, numRows, q.convert(s, numRows));
    }
}
