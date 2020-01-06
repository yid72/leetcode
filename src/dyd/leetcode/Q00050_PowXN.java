package dyd.leetcode;

public class Q00050_PowXN {
	private double halfPow(double x, int n) {
		if (n == 1) {
			return x;
		} else if (n == 0) {
			return 1;
		}

		double half = halfPow(x, n/2);
		if (n % 2 == 0) {
			return half * half;
		} else {
			return half * half * x;
		}
	}

    public double myPow(double x, int n) {
    	if (x == 0 && n == 0) {
    		throw new IllegalArgumentException("Invalid input");
    	}
    	
    	if (n < 0) {
    		x = 1/x;
    		n = -n;
    	}

    	return halfPow(x, n);
    }
    
    public static void main(String[] args) {
    	test(2, 0);
    	test(1, 3);
    	test(1.5, 2);
    	test(2, 2);
    	test(3, 4);
    	test(2, -2);
    	test(1, -2147483648);
    }
    
    private static void test(double x, int n) {
    	Q00050_PowXN q = new Q00050_PowXN();
    	System.out.printf("pow(%5.2f, %d) = %5.2f\n", x, n, q.myPow(x, n));
    }
}
