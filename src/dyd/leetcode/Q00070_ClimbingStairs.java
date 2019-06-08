package dyd.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Note: Given n will be a positive integer.
 *
 * Example 1:
 *
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
public class Q00070_ClimbingStairs {
    public int climbStairs(int n) {
    	if (n <= 0) {
    		throw new IllegalArgumentException("Wrong argument: " + n);
    	}
    	
        if (n == 1) {
        	return 1;
        }
        else if (n == 2) {
        	return 2;
        }
        
        int a = 1;
        int b = 2;
        int ret = 0;
        for (int i = 3; i <= n; i++) {
        	ret = a + b;
        	a = b;
        	b = ret;
        }
        return ret;
    }

    @Test
    public void test() {
    	Q00070_ClimbingStairs q = new Q00070_ClimbingStairs();

    	assertEquals(1, q.climbStairs(1));
    	assertEquals(2, q.climbStairs(2));
        assertEquals(3, q.climbStairs(3));
        assertEquals(5, q.climbStairs(4));
        assertEquals(8, q.climbStairs(5));
        assertEquals(13, q.climbStairs(6));
        assertEquals(21, q.climbStairs(7));
        assertEquals(34, q.climbStairs(8));
        assertEquals(55, q.climbStairs(9));
        assertEquals(89, q.climbStairs(10));
    }
}
