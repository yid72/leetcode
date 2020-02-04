package dyd.leetcode;

/**
 * 365. Water and Jug Problem -- Medium
 *
 * You are given two jugs with capacities x and y litres. There is an infinite amount of water supply available. You
 * need to determine whether it is possible to measure exactly z litres using these two jugs.
 *
 * If z liters of water is measurable, you must have z liters of water contained within one or both buckets by the end.
 *
 * Operations allowed:
 *
 * Fill any of the jugs completely with water.
 * Empty any of the jugs.
 * Pour water from one jug into another till the other jug is completely full or the first jug itself is empty.
 * Example 1: (From the famous "Die Hard" example)
 *
 * Input: x = 3, y = 5, z = 4
 * Output: True
 * Example 2:
 *
 * Input: x = 2, y = 6, z = 5
 * Output: False
 */
public class Q00365_WaterAndJugProblem {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        } else if (x == z || y == z || x + y == z) {
            return true;
        }

        return z % GCD(x, y) == 0;
    }

    private int GCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return a % b == 0 ? b : GCD(b, a % b);
    }

    public static void main(String[] args) {
        test(3, 5, 4);
        test(2, 6, 5);
    }

    private static void test(int x, int y, int z) {
        Q00365_WaterAndJugProblem q = new Q00365_WaterAndJugProblem();
        System.out.printf("x=%d, y=%d, z=%d: %b\n", x, y, z, q.canMeasureWater(x, y, z));
    }
}
