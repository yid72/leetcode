package dyd.leetcode;

import java.util.Stack;

/**
 * 394. Decode String
 *
 * Medium
 *
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 *
 * Examples:
 *
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
public class Q00394_DecodeString {
    public String decodeString(String s) {
        if (s.length() == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        int i = 0;
        int repeat = 1;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int start = i;
                while (++ i < s.length() && Character.isDigit(s.charAt(i)));
                repeat = Integer.parseInt(s.substring(start, i));
                continue;
            } else if (ch == '[') {
                Stack<Character> stack = new Stack();
                stack.push('[');
                int start = i + 1;
                while (++ i < s.length()) {
                    if (s.charAt(i) == '[') {
                        stack.push('[');
                    } else if (s.charAt(i) == ']') {
                        stack.pop();
                    }

                    if (stack.empty()) {
                        break;
                    }
                }

                String sub = decodeString(s.substring(start, i));
                for (int j = 0; j < repeat; j ++) {
                    sb.append(sub);
                }

                repeat = 1;
            } else {
                sb.append(ch);
            }

            i ++;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        test("a");
        test("abc");
        test("3[a]2[bc]");
        test("3[a2[c]]");
        test("2[abc]3[cd]ef");
        test("a10[leetcode]f");
    }

    private static void test(String s) {
        Q00394_DecodeString d = new Q00394_DecodeString();
        System.out.printf("%s: %s\n", s, d.decodeString(s));
    }
}
