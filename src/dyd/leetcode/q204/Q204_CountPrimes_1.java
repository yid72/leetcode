package dyd.leetcode.q204;

public class Q204_CountPrimes_1 {
    public int countPrimes(int n) {
    	int count = 0;
    	boolean[] notPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
        	if (notPrime[i] == false) {
        		count ++;
        		for (int j = 2; i*j < n; j++) {
        			notPrime[i*j] = true;
        		}
        	}
        }
        return count;
    }
    
    public static void main(String[] args) {
    	Q204_CountPrimes_1 q = new Q204_CountPrimes_1();
    	System.out.println(q.countPrimes(1500000));
    }    
}
