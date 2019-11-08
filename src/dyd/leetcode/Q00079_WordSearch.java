package dyd.leetcode;

import java.util.Arrays;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally
 * or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Example:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 */
public class Q00079_WordSearch {
    private char[][] board;
    private String word;
    private boolean [][] visited;

    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0 || word.isEmpty()) {
            return false;
        }

        this.board = board;
        this.word = word;
        visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(i, j, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(int i, int j, int index) {
        if (board[i][j] != word.charAt(index)) {
            return false;
        }

        if (index == word.length() - 1) {
            return true;
        }

        visited[i][j] = true;

        if (i > 0 && !visited[i - 1][j] && dfs(i - 1, j, index + 1)) {
            return true;
        }

        if (i < board.length - 1 && !visited[i + 1][j] && dfs(i + 1, j, index + 1)) {
            return true;
        }

        if (j > 0 && !visited[i][j - 1] && dfs(i, j - 1, index + 1)) {
            return true;
        }

        if (j < board[0].length - 1 && !visited[i][j + 1] && dfs(i, j + 1, index + 1)) {
            return true;
        }

        visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        test(new char[][] {{}}, "A");
        test(new char[][] {{'A'}}, "A");
        test(new char[][] {{'A'}}, "");
        test(new char[][] {{'A'}}, "AB");

        char[][] board = {
                {'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}
        };

        test(board, "ABCCED");
        test(board, "SEE");
        test(board, "ABCB");

        board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        test(board, "ABCESEEEFS");
    }

    private static void test(char[][] board, String word) {
        System.out.print(Arrays.deepToString(board) + ", word=" + word + ": ");
        Q00079_WordSearch q = new Q00079_WordSearch();
        System.out.println(q.exist(board, word));
    }
}
