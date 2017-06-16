package dyd.leetcode.q050;

public class Q050_Pow_x_n {
    public double myPow(double x, int n) {
    	if (x == 0 && n == 0) {
    		throw new IllegalArgumentException("Invalid input");
    	}
    	
    	if (n == 0) {
    		return 1;
    	}
    	else if (n == 1) {
    		return x;
    	}
    	else if (n < 0) {
    		return myPow(1/x, -n);
    	}
    	
    	double temp = myPow(x, n/2);
        if (n % 2 == 0) {
        	return temp * temp;
        }
        else {
        	return x * temp * temp;
        }
    }
    
    public static void main(String[] args) {
    	test(2, 0);
    	test(1, 3);
    	test(1.5, 2);
    	test(2, 2);
    	test(2, -2);
    	test(1, -2147483648);
    }
    
    private static void test(double x, int n) {
    	Q050_Pow_x_n q = new Q050_Pow_x_n();
    	System.out.printf("pow(%5.2f, %d) = %5.2f\n", x, n, q.myPow(x, n));
    }
}
