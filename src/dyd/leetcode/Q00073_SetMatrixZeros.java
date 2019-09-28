package dyd.leetcode;

import java.util.HashSet;

import dyd.leetcode.common.PrintUtil;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * Example 1:
 *
 * Input:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * Output:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * Example 2:
 *
 * Input:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * Output:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 * Follow up:
 *
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 *
 */
public class Q00073_SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
    	if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
    		return;
    	}
    	
        HashSet<Integer> zeroRows = new HashSet<Integer>();
        HashSet<Integer> zeroColumns = new HashSet<Integer>();
        for (int i = 0; i < matrix.length; i++) {
        	for (int j = 0; j < matrix[0].length; j++) {
        		if (matrix[i][j] == 0) {
        			zeroRows.add(i);
        			zeroColumns.add(j);
        		}
        	}
        }
        
        for (int row : zeroRows) {
        	setZeroRow(matrix, row);
        }
        
        for (int col : zeroColumns) {
        	setZeroColumn(matrix, col);
        }
    }
    
    private void setZeroRow(int[][] matrix, int row) {
    	for (int j = 0; j < matrix[0].length; j++) {
    		matrix[row][j] = 0;
    	}
    }
    
    private void setZeroColumn(int[][] matrix, int col) {
    	for (int i = 0; i < matrix.length; i++) {
    		matrix[i][col] = 0;
    	}
    }
    
    public static void main(String[] args) {
    	Q00073_SetMatrixZeros q = new Q00073_SetMatrixZeros();
    	
    	int[][] matrix = new int[][] {
    		{1, 2, 3, 4},
    		{1, 0, 1, 5}
    	};
    	q.setZeroes(matrix);
    	PrintUtil.printArray(matrix);
    }
}
