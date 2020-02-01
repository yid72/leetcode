package dyd.leetcode;

import java.util.Arrays;

/**
 * 735. Asteroid Collision -- Medium
 *
 * We are given an array asteroids of integers representing asteroids in a row.
 *
 * For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning
 * right, negative meaning left). Each asteroid moves at the same speed.
 *
 * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If
 * both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
 *
 * Example 1:
 * Input:
 * asteroids = [5, 10, -5]
 * Output: [5, 10]
 * Explanation:
 * The 10 and -5 collide resulting in 10.  The 5 and 10 never collide.
 * Example 2:
 * Input:
 * asteroids = [8, -8]
 * Output: []
 * Explanation:
 * The 8 and -8 collide exploding each other.
 * Example 3:
 * Input:
 * asteroids = [10, 2, -5]
 * Output: [10]
 * Explanation:
 * The 2 and -5 collide resulting in -5.  The 10 and -5 collide resulting in 10.
 * Example 4:
 * Input:
 * asteroids = [-2, -1, 1, 2]
 * Output: [-2, -1, 1, 2]
 * Explanation:
 * The -2 and -1 are moving left, while the 1 and 2 are moving right.
 * Asteroids moving the same direction never meet, so no asteroids will meet each other.
 * Note:
 *
 * The length of asteroids will be at most 10000.
 * Each asteroid will be a non-zero integer in the range [-1000, 1000]..
 */
public class Q00735_AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        int len = asteroids.length;
        while (true) {
            boolean collided = false;
            int j = 0;
            for (int i = 0; i < len; i++) {
                if (i < len - 1 && asteroids[i] > 0 && asteroids[i + 1] < 0) {
                    int collide = collide(asteroids[i], asteroids[i + 1]);
                    if (collide != 0) {
                        asteroids[j ++] = collide;
                    }
                    collided = true;
                    i ++;
                } else {
                    asteroids[j ++] = asteroids[i];
                }
            }
            len = j;

            if (len == 0 || !collided) {
                break;
            }
        }

        int[] ret = new int[len];
        System.arraycopy(asteroids, 0, ret, 0, len);
        return ret;
    }

    private int collide(int a1, int a2) {
        if (a1 == Math.abs(a2)) {
            return 0;
        } else if (a1 > Math.abs(a2)) {
            return a1;
        } else {
            return a2;
        }
    }

    public static void main(String[] args) {
        test(new int[] {5, 10, -5});
        test(new int[] {5, 10, -5, 5});
        test(new int[] {-2, -1, 1, 2});
        test(new int[] {10, 2, -5});
        test(new int[] {8, -8});
    }

    private static void test(int[] asteroids) {
        System.out.println("asteroids: " + Arrays.toString(asteroids));
        Q00735_AsteroidCollision q = new Q00735_AsteroidCollision();
        System.out.println("result: " + Arrays.toString(q.asteroidCollision(asteroids)));
    }
}
