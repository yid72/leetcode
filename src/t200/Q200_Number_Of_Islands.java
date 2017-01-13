package t200;

import java.util.LinkedList;
import java.util.Queue;

public class Q200_Number_Of_Islands {
	private char[][] grid;
	private int m;
	private int n;	
	
	private int[][] flags;
			
    public int numIslands(char[][] grid) {
    	if (grid == null || grid.length == 0) {
    		return 0;
    	}
    	
    	this.grid = grid;
    	this.m = grid.length;
    	this.n = grid[0].length;
    	
    	this.flags = new int[this.m][];
    	for (int i = 0; i < this.m; i++) {
    		this.flags[i] = new int[this.n];
    	}
        
        int curIsland = 0;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (grid[i][j] == '1' && flags[i][j] == 0) {
        			queue.clear();
        			bfs(i, j, ++ curIsland, queue);
        		}
        	}
        }
        
        return curIsland;
    }
    
    private void bfs(int i, int j, int island, Queue<Integer> queue) {
  		queue.add(i * this.n + j);
    	
    	while (!queue.isEmpty()) {
    		int pos = queue.remove();
    		int curI = pos / this.n;
    		int curJ = pos % this.n;
    		this.flags[curI][curJ] = island;
    		
    		addLand(curI - 1, curJ, queue);
    		addLand(curI + 1, curJ, queue);
    		addLand(curI, curJ - 1, queue);
    		addLand(curI, curJ + 1, queue);
    	}
    }
    
    private void addLand(int i, int j, Queue<Integer> queue) {
    	if (i >= 0 && i < this.m && j >= 0 && j < this.n &&
    			this.grid[i][j] == '1' && this.flags[i][j] == 0) {
    		queue.add(i * this.n + j);
    	}
    }
    
    public static void main(String[] args) {
    	char[][] grid = {
    			{'0', '1', '1'},
    			{'1', '0', '1'}
    	};
    	
    	Q200_Number_Of_Islands t = new Q200_Number_Of_Islands();
    	System.out.println(t.numIslands(grid));
    }
}
