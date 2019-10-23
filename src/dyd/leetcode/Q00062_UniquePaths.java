package dyd.leetcode;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right
 * corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 * Note: m and n will be at most 100.
 *
 * Example 1:
 *
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 * Example 2:
 *
 * Input: m = 7, n = 3
 * Output: 28
 */
public class Q00062_UniquePaths {
    private int[][] paths;

    public int uniquePaths(int m, int n) {
        paths = new int[m][n];

        return internalUniquePaths(m - 1, n - 1);
    }

    private int internalUniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 1;
        }

        if (paths[m][n] > 0) {
            return paths[m][n];
        }

        paths[m][n] = internalUniquePaths(m - 1, n ) + internalUniquePaths(m, n - 1);
        return paths[m][n];
    }

    public static void main(String[] args) {
        test(3, 2);
        test(7, 3);
    }

    private static void test(int m, int n) {
        System.out.printf("m=%s, n=%s: ", m, n);
        Q00062_UniquePaths q = new Q00062_UniquePaths();
        System.out.println(q.uniquePaths(m, n));
    }
}
