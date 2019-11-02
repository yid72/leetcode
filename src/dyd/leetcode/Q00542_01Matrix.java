package dyd.leetcode;

import java.util.Arrays;

/**
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
 *
 * The distance between two adjacent cells is 1.
 *
 *
 *
 * Example 1:
 *
 * Input:
 * [[0,0,0],
 *  [0,1,0],
 *  [0,0,0]]
 *
 * Output:
 * [[0,0,0],
 *  [0,1,0],
 *  [0,0,0]]
 * Example 2:
 *
 * Input:
 * [[0,0,0],
 *  [0,1,0],
 *  [1,1,1]]
 *
 * Output:
 * [[0,0,0],
 *  [0,1,0],
 *  [1,2,1]]
 *
 *
 * Note:
 *
 * The number of elements of the given matrix will not exceed 10,000.
 * There are at least one 0 in the given matrix.
 * The cells are adjacent in only four directions: up, down, left and right.
 */
public class Q00542_01Matrix {
    private int[][] dist;
    private int m;
    private int n;

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0][0];
        }

        m = matrix.length;
        n = matrix[0].length;

        dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], -1);
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    dist[i][j] = 0;
                }
            }
        }

        updateMatrixHelper(matrix);
        return dist;
    }

    private void updateMatrixHelper(int[][] matrix) {
        int val = 0;
        while (true) {
            boolean finished = true;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (dist[i][j] == val) {
                        setNeigbourDist(i, j, val+1);
                        finished = false;
                    }
                }
            }
            if (finished) {
                return;
            }
            val ++;
        }
    }

    private void setNeigbourDist(int i, int j, int val) {
        if (i > 0 && dist[i - 1][j] == -1) {
            dist[i - 1][j] = val;
        }

        if (i < m - 1 && dist[i + 1][j] == -1) {
            dist[i + 1][j] = val;
        }

        if (j > 0 && dist[i][j - 1] == -1) {
            dist[i][ j - 1] = val;
        }

        if (j < n - 1 && dist[i][j + 1] == -1) {
            dist[i][ j + 1] = val;
        }
    }

    public static void main(String[] args) {
        test(new int[][] {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        });

        test(new int[][] {
                {0,0,0},
                {0,1,0},
                {1,1,1}
        });
    }

    private static void test(int[][] matrix) {
        System.out.println(Arrays.deepToString(matrix));
        Q00542_01Matrix q = new Q00542_01Matrix();
        System.out.println(Arrays.deepToString(q.updateMatrix(matrix)));
    }
}
