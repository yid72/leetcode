package dyd.leetcode;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 *
 * For example:
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 * Example 1:
 *
 * Input: 1
 * Output: "A"
 * Example 2:
 *
 * Input: 28
 * Output: "AB"
 * Example 3:
 *
 * Input: 701
 * Output: "ZY"
 */
public class Q00168_ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append((char) ('A' + (n - 1) % 26));
            n = (n - 1) / 26;
        }
        String reverse = sb.toString();
        StringBuilder result = new StringBuilder();
        for (int i = reverse.length() - 1; i >= 0; i--) {
            result.append(reverse.charAt(i));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Q00168_ExcelSheetColumnTitle q = new Q00168_ExcelSheetColumnTitle();
        System.out.println(q.convertToTitle(1));
        System.out.println(q.convertToTitle(26));
        System.out.println(q.convertToTitle(28));
        System.out.println(q.convertToTitle(701));
    }
}
