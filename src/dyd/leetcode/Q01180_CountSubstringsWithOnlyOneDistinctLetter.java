package dyd.leetcode;

/**
 * 1180. Count Substrings with Only One Distinct Letter -- Easy
 *
 * Given a string S, return the number of substrings that have only one distinct letter.
 *
 * Example 1:
 *
 * Input: S = "aaaba"
 * Output: 8
 * Explanation: The substrings with one distinct letter are "aaa", "aa", "a", "b".
 * "aaa" occurs 1 time.
 * "aa" occurs 2 times.
 * "a" occurs 4 times.
 * "b" occurs 1 time.
 * So the answer is 1 + 2 + 4 + 1 = 8.
 * Example 2:
 *
 * Input: S = "aaaaaaaaaa"
 * Output: 55
 *
 *
 * Constraints:
 *
 * 1 <= S.length <= 1000
 * S[i] consists of only lowercase English letters.
 */
public class Q01180_CountSubstringsWithOnlyOneDistinctLetter {
    public int countLetters(String S) {
        if (S.length() == 0) {
            return 0;
        }

        int count = 0;

        int start = 0;
        char curChar = S.charAt(0);
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) != curChar) {
                count += count(start, i);
                start = i;
                curChar = S.charAt(i);
            }
        }

        count += count(start, S.length());

        return count;
    }

    private int count(int start, int end) {
        int n = end - start;
        return (n + 1)*n/2;
    }

    public static void main(String[] args) {
        test("aaaba");
        test("aaaaaaaaaa");
    }

    private static void test(String S) {
        Q01180_CountSubstringsWithOnlyOneDistinctLetter q = new Q01180_CountSubstringsWithOnlyOneDistinctLetter();
        System.out.printf("S=%s: %d\n", S, q.countLetters(S));
    }
}
