package dyd.leetcode;

/**
 * Balanced strings are those who have equal quantity of 'L' and 'R' characters.
 *
 * Given a balanced string s split it in the maximum amount of balanced strings.
 *
 * Return the maximum amount of splitted balanced strings.
 *
 * Example 1:
 *
 * Input: s = "RLRRLLRLRL"
 * Output: 4
 * Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
 * Example 2:
 *
 * Input: s = "RLLLLRRRLR"
 * Output: 3
 * Explanation: s can be split into "RL", "LLLRRR", "LR", each substring contains same number of 'L' and 'R'.
 * Example 3:
 *
 * Input: s = "LLLLRRRR"
 * Output: 1
 * Explanation: s can be split into "LLLLRRRR".
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s[i] = 'L' or 'R'
 */
public class Q01221_SplitAStringInBalancedString {
    public int balancedStringSplit(String s) {
        if (s.length() <= 1) {
            return 0;
        }

        int count = 0;
        int num = s.charAt(0) == 'L' ? 1 : -1;
        for (int i = 1; i < s.length(); i++) {
            num += (s.charAt(i) == 'L' ? 1 : -1);
            if (num == 0) {
                count ++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Q01221_SplitAStringInBalancedString q = new Q01221_SplitAStringInBalancedString();
        System.out.println(q.balancedStringSplit("RLRRLLRLRL"));
        System.out.println(q.balancedStringSplit("RLLLLRRRLR"));
        System.out.println(q.balancedStringSplit("LLLLRRRR"));
    }
}
