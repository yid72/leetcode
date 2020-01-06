package dyd.leetcode;

import java.util.Arrays;

/**
 * Sort colors with one pass.
 */
public class Q00075_SortColors_2 {
    private static final int RED = 0;
    private static final int BLUE = 2;

    public void sortColors(int[] nums) {
        int red = 0;
        int blue = nums.length - 1;

        while (nums[red] == RED && red < nums.length) {
            red++;
        }

        while (nums[blue] == BLUE && blue >= red) {
            blue--;
        }

        for (int i = red; i < blue; i++) {
            if (nums[i] == RED) {
                nums[i] = nums[red];
                i --;
                nums[red ++] = RED;
            } else if (nums[i] == BLUE) {
                nums[i] = nums[blue];
                i --;
                nums[blue --] = BLUE;
            }
        }
    }

    public static void main(String[] args) {
        test(new int[] {0, 1, 0, 2, 1, 0});
    }

    private static void test(int[] nums) {
        System.out.println(Arrays.toString(nums));
        Q00075_SortColors_2 q = new Q00075_SortColors_2();
        q.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}