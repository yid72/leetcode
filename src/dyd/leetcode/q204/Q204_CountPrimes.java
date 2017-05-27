package dyd.leetcode.q204;

/**
 * Count the number of prime numbers less than a non-negative number, n.
 * 
 * @author dyd
 *
 */
public class Q204_CountPrimes {
    public int countPrimes(int n) {
    	int count = 0;
        for (int i = 1; i < n; i++) {
        	if (isPrime(i)) {
        		count ++;
        	}
        }
        return count;
    }
    
    private boolean isPrime(int n) {
    	if (n <= 1) {
    		return false;
    	}
    	
    	for (int i = 2; i*i <= n; i++) {
    		if (n % i == 0) {
    			return false;
    		}
    	}
    	
    	return true;
    }
    
    public static void main(String[] args) {
    	Q204_CountPrimes q = new Q204_CountPrimes();
    	System.out.println(q.countPrimes(1500000));
    }
}
