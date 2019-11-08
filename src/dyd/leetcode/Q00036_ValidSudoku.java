package dyd.leetcode;

import java.util.Arrays;

/**
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following
 * rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 * A partially filled sudoku which is valid.
 *
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 *
 * Example 1:
 *
 * Input:
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: true
 * Example 2:
 *
 * Input:
 * [
 *   ["8","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being
 *     modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 * Note:
 *
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 * The given board contain only digits 1-9 and the character '.'.
 * The given board size is always 9x9.
 */
public class Q00036_ValidSudoku {
    char[][] board;
    int[] count;

    public boolean isValidSudoku(char[][] board) {
        if  (board.length != 9 || board[0].length != 9) {
            return false;
        }

        this.board = board;
        count = new int[9];

        for (int i = 0; i < board.length; i++) {
            if (!validRow(i)) {
                return false;
            }
        }

        for (int j = 0; j < board[0].length; j++) {
            if (!validColumn(j)) {
                return false;
            }
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!validSubBox(i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean validRow(int row) {
        Arrays.fill(count, 0);
        for (int i = 0; i < 9; i ++) {
            if (board[row][i] == '.') {
                continue;
            }

            int index = board[row][i] - '1';
            if (count[index] > 0) {
                return false;
            }

            count[index] ++;
        }
        return true;
    }

    private boolean validColumn(int col) {
        Arrays.fill(count, 0);
        for (int i = 0; i < 9; i ++) {
            if (board[i][col]== '.') {
                continue;
            }

            int index = board[i][col] - '1';
            if (count[index] > 0) {
                return false;
            }

            count[index] ++;
        }
        return true;
    }

    private boolean validSubBox(int row, int col) {
        Arrays.fill(count, 0);
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                int index = board[i][j] - '1';
                if (count[index] > 0) {
                    return false;
                }

                count[index] ++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        test(new char[][] {{}});
        test(new char[][] {{'1', '2'}});
        test(new char[][] {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        });
        test(new char[][] {
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        });
    }

    private static void test(char[][] board) {
        Q00036_ValidSudoku q = new Q00036_ValidSudoku();
        System.out.println(Arrays.deepToString(board));
        System.out.println("Is sudoku? " + q.isValidSudoku(board));
    }
}
