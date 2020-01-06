package dyd.leetcode.contests.p20191012;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * On an 8x8 chessboard, there can be multiple Black Queens and one White King.
 *
 * Given an array of integer coordinates queens that represents the positions of the Black Queens, and a pair of coordinates king that represent the position of the White King, return the coordinates of all the queens (in any order) that can attack the King.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: queens = [[0,1],[1,0],[4,0],[0,4],[3,3],[2,4]], king = [0,0]
 * Output: [[0,1],[1,0],[3,3]]
 * Explanation:
 * The queen at [0,1] can attack the king cause they're in the same row.
 * The queen at [1,0] can attack the king cause they're in the same column.
 * The queen at [3,3] can attack the king cause they're in the same diagnal.
 * The queen at [0,4] can't attack the king cause it's blocked by the queen at [0,1].
 * The queen at [4,0] can't attack the king cause it's blocked by the queen at [1,0].
 * The queen at [2,4] can't attack the king cause it's not in the same row/column/diagnal as the king.
 * Example 2:
 *
 *
 *
 * Input: queens = [[0,0],[1,1],[2,2],[3,4],[3,5],[4,4],[4,5]], king = [3,3]
 * Output: [[2,2],[3,4],[4,4]]
 * Example 3:
 *
 *
 *
 * Input: queens = [[5,6],[7,7],[2,1],[0,7],[1,6],[5,1],[3,7],[0,3],[4,0],[1,2],[6,3],[5,0],[0,4],[2,2],[1,1],[6,4],[5,4],[0,0],[2,6],[4,5],[5,2],[1,4],[7,5],[2,3],[0,5],[4,2],[1,0],[2,7],[0,1],[4,6],[6,1],[0,6],[4,3],[1,7]], king = [3,4]
 * Output: [[2,3],[1,4],[1,6],[3,7],[4,3],[5,4],[4,5]]
 *
 *
 * Constraints:
 *
 * 1 <= queens.length <= 63
 * queens[0].length == 2
 * 0 <= queens[i][j] < 8
 * king.length == 2
 * 0 <= king[0], king[1] < 8
 * At most one piece is allowed in a cell.
 */
public class Q05223_QueenThatCanAttackTheKing {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> result = new ArrayList<>();

        int topRow = -1;
        int bottomRow = 8;
        int leftCol = -1;
        int rightCol = 8;
        int leftCrossRow1 = -1;
        int leftCrossCol1 = -1;
        int leftCrossRow2 = -1;
        int leftCrossCol2 = -1;
        int rightCrossRow1 = 8;
        int rightCrossCol1 = 8;
        int rightCrossRow2 = 8;
        int rightCrossCol2 = 8;
        for (int i = 0; i < queens.length; i++) {
            int row = queens[i][0];
            int col = queens[i][1];
            if (col == king[1]) {
                if (row < king[0] && row > topRow) {
                    topRow = row;
                } else if (row > king[0] && row < bottomRow) {
                    bottomRow = row;
                }
            }

            if (row == king[0]) {
                if (col < king[1] && col > leftCol) {
                    leftCol = col;
                } else if (col > king[1] && col < rightCol) {
                    rightCol = col;
                }
            }

            if (row < king[0] && king[0]-row==king[1]-col && row > leftCrossRow1) {
                leftCrossRow1 = row;
                leftCrossCol1 = col;
            } else if (row > king[0] && row-king[0]==col-king[1] && row < rightCrossRow1) {
                rightCrossRow1 = row;
                rightCrossCol1 = col;
            }

            if (row < king[0] && king[0]-row==col-king[1] && row > leftCrossRow2) {
                leftCrossRow2 = row;
                leftCrossCol2 = col;
            } else if (row > king[0] && row-king[0]==king[1]-col && row < rightCrossRow2) {
                rightCrossRow2 = row;
                rightCrossCol2 = col;
            }
        }

        if (topRow > -1) {
            add(result, new int[] {topRow, king[1]});
        }

        if (bottomRow < 8) {
            add(result, new int[] {bottomRow, king[1]});
        }

        if (leftCol > -1) {
            add(result, new int[] {king[0], leftCol});
        }

        if (rightCol < 8) {
            add(result, new int[] {king[0], rightCol});
        }

        if (leftCrossRow1 > -1) {
            add(result, new int[] {leftCrossRow1, leftCrossCol1});
        }

        if (rightCrossRow1 < 8) {
            add(result, new int[] {rightCrossRow1, rightCrossCol1});
        }

        if (leftCrossRow2 > -1) {
            add(result, new int[] {leftCrossRow2, leftCrossCol2});
        }

        if (rightCrossRow2 < 8) {
            add(result, new int[] {rightCrossRow2, rightCrossCol2});
        }
        return result;
    }

    private void add(List<List<Integer>> result, int[] q) {
        List<Integer> list = new ArrayList<>();
        list.add(q[0]);
        list.add(q[1]);
        result.add(list);
    }

    public static void main(String[] args) {
        test(new int[][] {{0,1},{1,0},{4,0},{0,4},{3,3},{2,4}}, new int[] {0, 0});
        test(new int[][] {{0,0},{1,1},{2,2},{3,4},{3,5},{4,4},{4,5}}, new int[] {3, 3});
    }

    private static void test(int[][] queens, int[] king) {
        System.out.println("queens: " + Arrays.deepToString(queens));
        System.out.println("king: " + Arrays.toString(king));
        Q05223_QueenThatCanAttackTheKing q = new Q05223_QueenThatCanAttackTheKing();
        System.out.println(q.queensAttacktheKing(queens, king));
    }
}
