package dyd.leetcode;

import dyd.leetcode.common.PrintUtil;

/**
 * 289. Game of Life -- Medium
 *
 * According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 *
 * The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 *
 * Any live cell with fewer than two live neighbors dies as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population.
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.
 *
 * Example 1:
 * Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
 * Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
 *
 * Example 2:
 * Input: board = [[1,1],[1,0]]
 * Output: [[1,1],[1,1]]
 *
 * Constraints:
 *
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 25
 * board[i][j] is 0 or 1.
 */
public class Q00289_GameOfLife {
    private int[][] board;
    private int m;
    private int n;

    public void gameOfLife(int[][] board) {
        // 2 means 0 -> 1
        // 3 means 1 -> 0
        this.board = board;
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = live(i - 1, j - 1) + live(i - 1, j) + live(i - 1, j + 1) + live(i, j - 1) + live(i, j + 1) + live(i + 1, j - 1) + live(i + 1, j) + live(i + 1, j + 1);
                if (board[i][j] == 1) {
                    if (count < 2 || count > 3) {
                        board[i][j] = 3;
                    }
                } else {
                    if (count == 3) {
                        board[i][j] = 2;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                } else if (board[i][j] == 3) {
                    board[i][j] = 0;
                }
            }
        }
    }

    private int live(int i, int j) {
        if (i >= 0 && i < m && j >= 0 && j < n) {
            return (board[i][j] == 1 || board[i][j] == 3) ? 1 : 0;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int[][] board = new int[][]{
                {0,1,0},{0,0,1},{1,1,1},{0,0,0}
        };
        PrintUtil.printArray("input", board);

        Q00289_GameOfLife q = new Q00289_GameOfLife();
        q.gameOfLife(board);
        PrintUtil.printArray("result=", board);
    }
}
