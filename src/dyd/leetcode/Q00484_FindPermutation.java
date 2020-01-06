package dyd.leetcode;

import java.util.Arrays;

/**
 * By now, you are given a secret signature consisting of character 'D' and 'I'. 'D' represents a decreasing
 * relationship between two numbers, 'I' represents an increasing relationship between two numbers. And our secret
 * signature was constructed by a special integer array, which contains uniquely all the different number from 1 to n
 * (n is the length of the secret signature plus 1). For example, the secret signature "DI" can be constructed by array
 * [2,1,3] or [3,1,2], but won't be constructed by array [3,2,4] or [2,1,3,4], which are both illegal constructing
 * special string that can't represent the "DI" secret signature.
 *
 * On the other hand, now your job is to find the lexicographically smallest permutation of [1, 2, ... n] could refer to
 * the given secret signature in the input.
 *
 * Example 1:
 * Input: "I"
 * Output: [1,2]
 * Explanation: [1,2] is the only legal initial spectial string can construct secret signature "I", where the number 1
 * and 2 construct an increasing relationship.
 * Example 2:
 * Input: "DI"
 * Output: [2,1,3]
 * Explanation: Both [2,1,3] and [3,1,2] can construct the secret signature "DI",
 * but since we want to find the one with the smallest lexicographical permutation, you need to output [2,1,3]
 * Note:
 *
 * The input string will only contain the character 'D' and 'I'.
 * The length of input string is a positive integer and will not exceed 10,000
 */
public class Q00484_FindPermutation {
    public int[] findPermutation(String s) {
        int[] perm = new int[s.length() + 1];
        int n = s.length();
        int curNum = 1;
        int startD = 0;
        int startI = 0;
        while (startI < n) {
            while (startI < n && s.charAt(startI) == 'D') {
                startI++;
            }

            for (int i = startI - 1; i >= startD; i--) {
                perm[i] = curNum ++;
            }

            perm[startI] = curNum ++;

            while (startI < n && s.charAt(startI) == 'I') {
                perm[startI ++] = curNum ++;
            }

            startD = startI;
        }
        return perm;
    }

    public static void main(String[] args) {
        test("I");
    }

    private static void test(String s) {
        System.out.println(s);
        Q00484_FindPermutation q = new Q00484_FindPermutation();
        System.out.println(Arrays.toString(q.findPermutation(s)));
    }
}
