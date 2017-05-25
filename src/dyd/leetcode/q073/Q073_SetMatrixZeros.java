package dyd.leetcode.q073;

import java.util.HashSet;

import dyd.leetcode.common.PrintUtil;

/**
 * 
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

 * @author dyd
 *
 */
public class Q073_SetMatrixZeros {
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
    	Q073_SetMatrixZeros q = new Q073_SetMatrixZeros();
    	
    	int[][] matrix = new int[][] {
    		{1, 2, 3, 4},
    		{1, 0, 1, 5}
    	};
    	q.setZeroes(matrix);
    	PrintUtil.printArray(matrix);
    }
}
