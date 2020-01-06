package dyd.leetcode;

/**
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 *
 * Example 1:
 * Input: "aba"
 * Output: True
 * Example 2:
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 * Note:
 * The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 */
public class Q00680 {
    public boolean validPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }

        if (isPalindrome(s)) {
            return true;
        }

        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder(s.substring(0, i));
            sb.append(s.substring(i + 1));
            if (isPalindrome(sb.toString())) {
                return true;
            }
        }

        return false;
    }

    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i ++;
            j --;
        }
        return true;
    }

    public static void main(String[] args) {
        test("aba");
        test("abca");
        test("abcda");
    }

    private static void test(String s) {
        Q00680 q = new Q00680();
        System.out.println(s + ": " + q.validPalindrome(s));
    }
}
