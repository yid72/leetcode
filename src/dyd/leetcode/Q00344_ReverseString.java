package dyd.leetcode;

public class Q00344_ReverseString {
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length/2; i++) {
            char tempChar = s[i];
            s[i] = s[s.length-1-i];
            s[s.length-1-i] = tempChar;
        }
    }

    public static void main(String[] args) {
        Q00344_ReverseString solution = new Q00344_ReverseString();
        String s1 = "hello";
        char[] chars = s1.toCharArray();
        solution.reverseString(chars);
        System.out.println(new String(chars));

        String s2 = "hannah";
        chars = s2.toCharArray();
        solution.reverseString(chars);
        System.out.println(new String(chars));
    }
}
