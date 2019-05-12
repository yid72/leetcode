package dyd.leetcode;

/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 *
 * For example:
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * Example 1:
 *
 * Input: "A"
 * Output: 1
 * Example 2:
 *
 * Input: "AB"
 * Output: 28
 * Example 3:
 *
 * Input: "ZY"
 * Output: 701
 */
public class Q00171_ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int number = 0;
        for (int i = 0; i < s.length(); i++) {
            number = number * 26 + s.charAt(i) - 'A' + 1;
        }
        return number;
    }

    public static void main(String[] args) {
        Q00171_ExcelSheetColumnNumber q = new Q00171_ExcelSheetColumnNumber();
        System.out.println(q.titleToNumber("A"));
        System.out.println(q.titleToNumber("AB"));
        System.out.println(q.titleToNumber("ZY"));
    }
}
