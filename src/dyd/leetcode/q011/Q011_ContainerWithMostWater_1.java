package dyd.leetcode.q011;

public class Q011_ContainerWithMostWater_1 {
    public int maxArea(int[] height) {
    	
    }
    
    private int computeArea(int[] height, int i, int j) {
    	return Math.min(height[i], height[j]) * (j - i);
    }    
}
