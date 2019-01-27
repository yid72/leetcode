package dyd.leetcode;

import dyd.leetcode.common.PrintUtil;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 */
public class Q00011_ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = Math.min(height[1], height[0]);

        for (int i = 2; i < height.length; i++) {
            for (int j = 0; j < i; j++) {
                int area = (i - j) * Math.min(height[i], height[j]);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Q00011_ContainerWithMostWater q = new Q00011_ContainerWithMostWater();

        int[] data = {1, 3, 5, 3, 8};
        PrintUtil.printArray(data);

        System.out.println(q.maxArea(data));
    }
}
