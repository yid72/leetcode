package dyd.leetcode;

import java.util.Arrays;

public class Q00011_ContainerWithMostWater_2 {
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

    public static void main(String[] args) {
        test(new int[] {1, 3, 5, 3, 8});
        test(new int[] {1,8,6,2,5,4,8,3,7});
    }

    private static void test(int[] height) {
        Q00011_ContainerWithMostWater_2 q = new Q00011_ContainerWithMostWater_2();
        System.out.println(Arrays.toString(height) + ": " + q.maxArea(height));
    }
}
