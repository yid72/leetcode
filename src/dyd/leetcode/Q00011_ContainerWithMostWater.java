package dyd.leetcode;

import java.util.Arrays;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 */
public class Q00011_ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, area);
            if (height[left] <= height[right]) {
                left ++;
            } else {
                right --;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        test(new int[] {1, 3, 5, 3, 8});
        test(new int[] {1,8,6,2,5,4,8,3,7});
    }

    private static void test(int[] height) {
        Q00011_ContainerWithMostWater q = new Q00011_ContainerWithMostWater();
        System.out.println(Arrays.toString(height) + ": " + q.maxArea(height));
    }
}
