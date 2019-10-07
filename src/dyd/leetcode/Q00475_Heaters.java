package dyd.leetcode;

import java.util.Arrays;

/**
 * Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm
 * all the houses.
 *
 * Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius of heaters so that
 * all houses could be covered by those heaters.
 *
 * So, your input will be the positions of houses and heaters seperately, and your expected output will be the minimum
 * radius standard of heaters.
 *
 * Note:
 *
 * Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
 * Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
 * As long as a house is in the heaters' warm radius range, it can be warmed.
 * All the heaters follow your radius standard and the warm radius will the same.
 *
 *
 * Example 1:
 *
 * Input: [1,2,3],[2]
 * Output: 1
 * Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses
 * can be warmed.
 *
 *
 * Example 2:
 *
 * Input: [1,2,3,4],[1,4]
 * Output: 1
 * Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all the houses
 * can be warmed.
 */
public class Q00475_Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        if (heaters.length == 0) {
            return 0;
        }

        Arrays.sort(houses);
        Arrays.sort(heaters);
        int max = 0;
        for (int i = 0; i < houses.length; i++) {
            max = Math.max(max, findRadius(houses[i], heaters));
        }
        return max;
    }

    private int findRadius(int house, int[] heaters) {
        int low = 0;
        int high = heaters.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (heaters[mid] == house) {
                return 0;
            } else if (heaters[mid] < house) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (low > heaters.length - 1) {
            low = heaters.length - 1;
        }
        if (high < 0 ) {
            high = 0;
        }

        return Math.min(Math.abs(heaters[low] - house), Math.abs(heaters[high] - house));
    }

    public static void main(String[] args) {
        test(new int[] {1, 2, 3}, new int[] {2});
        test(new int[] {1, 2, 3, 4}, new int[] {1, 4});
    }

    private static void test(int[] houses, int[] heaters) {
        System.out.println("Houses: " + Arrays.toString(houses));
        System.out.println("Heaters: " + Arrays.toString(heaters));
        Q00475_Heaters q = new Q00475_Heaters();
        System.out.println("Radius: " + q.findRadius(houses, heaters));
    }
}
