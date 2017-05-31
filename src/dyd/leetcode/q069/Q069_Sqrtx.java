package dyd.leetcode.q069;

public class Q069_Sqrtx {
    public int mySqrt(int x) {
    	if (x < 0) {
    		throw new IllegalArgumentException("Invalid x: " + x);
    	}
    	
    	if (x == 0 || x == 1) {
    		return x;
    	}
    	
    	int low = 1;
    	int high = x;
    	while (low <= high) {
    		int mid = low + (high - low)/2;
    		int s = x/mid;
    		if (mid < s) {
    			low = mid + 1;
    		}
    		else if (mid > s) {
    			high = mid - 1;
    		}
    		else {
    			return mid;
    		}
    	}
    	
    	return high;
    }
    
    public static void main(String[] args) {
    	Q069_Sqrtx q = new Q069_Sqrtx();

    	System.out.println(q.mySqrt(2147395599));
    	System.out.println(q.mySqrt(3));
    	System.out.println(q.mySqrt(4));
    	System.out.println(q.mySqrt(5));
    	System.out.println(q.mySqrt(6));
    	System.out.println(q.mySqrt(7));    	
    	System.out.println(q.mySqrt(8));    	
    	System.out.println(q.mySqrt(9));
    	System.out.println(q.mySqrt(16));    	
    	System.out.println(q.mySqrt(25));
    	System.out.println(q.mySqrt(2147395599));
    	
    }
}
