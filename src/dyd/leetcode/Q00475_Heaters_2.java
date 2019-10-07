package dyd.leetcode;

import java.util.Arrays;

public class Q00475_Heaters_2 {
    public int findRadius(int[] houses, int[] heaters) {
        if (houses.length == 0 || heaters.length == 0) {
            return 0;
        }

        Arrays.sort(houses);
        Arrays.sort(heaters);
        int max = 0;
        for (int i = 0; i < houses.length; i++) {
            int pos = Arrays.binarySearch(heaters, houses[i]);
            if (pos < 0) {
                pos = -pos - 1;
                int r;
                if (pos == 0) {
                    r = Math.abs(houses[i] - heaters[0]);
                } else if (pos > heaters.length - 1) {
                    r = Math.abs(houses[i] - heaters[heaters.length - 1]);
                } else {
                    r = Math.min(Math.abs(houses[i] - heaters[pos]), Math.abs(houses[i] - heaters[pos - 1]));
                }
                max = Math.max(max, r);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        test(new int[] {1, 2, 3}, new int[] {2});
        test(new int[] {1, 2, 3, 4}, new int[] {1, 4});
    }

    private static void test(int[] houses, int[] heaters) {
        System.out.println("Houses: " + Arrays.toString(houses));
        System.out.println("Heaters: " + Arrays.toString(heaters));
        Q00475_Heaters_2 q = new Q00475_Heaters_2();
        System.out.println("Radius: " + q.findRadius(houses, heaters));
    }
}
