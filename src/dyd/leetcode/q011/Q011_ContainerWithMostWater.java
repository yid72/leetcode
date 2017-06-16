package dyd.leetcode.q011;

/**
 * 
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

 * @author dyd
 *
 */
public class Q011_ContainerWithMostWater {
    public int maxArea(int[] height) {
    	int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
        	for (int j = i + 1; j < height.length; j++) {
        		max = Math.max(max, computeArea(height, i, j));
        	}
        }
        return max;
    }
    
    private int computeArea(int[] height, int i, int j) {
    	return Math.min(height[i], height[j]) * (j - i);
    }
}
