package dyd.leetcode;

/**
 * 680. Valid Palindrome II -- Easy
 *
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
public class Q00680_ValidPalindrome2 {
    public boolean validPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }

        return isPalindrome(s, 0, s.length() - 1, 0);
    }

    private boolean isPalindrome(String s, int start, int end, int count) {
        int i = start;
        int j = end;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                if (count == 1) {
                    return false;
                }
                return isPalindrome(s, i + 1, j, 1) || isPalindrome(s, i, j - 1, 1);
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
        Q00680_ValidPalindrome2 q = new Q00680_ValidPalindrome2();
        System.out.println(s + ": " + q.validPalindrome(s));
    }
}
