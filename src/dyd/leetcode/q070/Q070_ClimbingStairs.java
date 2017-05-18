package dyd.leetcode.q070;

public class Q070_ClimbingStairs {
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
    
    public static void main(String[] args) {
    	Q070_ClimbingStairs q = new Q070_ClimbingStairs();
    	
    	for (int n = 1; n < 11; n++) {
    		System.out.println("c(" + n + ") = " + q.climbStairs(n));
    	}
    }
}
