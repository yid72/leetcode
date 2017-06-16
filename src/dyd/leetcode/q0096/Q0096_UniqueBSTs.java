package dyd.leetcode.q0096;

/**
 * 
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   
 * @author dyd
 *
 */
public class Q0096_UniqueBSTs {
    public int numTrees(int n) {
    	if (n <= 1) {
    		return 1;
    	}
    	
    	int[] nums = new int[n+1];
    	nums[0] = nums[1] = 1;
    	
        for (int i = 2; i <= n; i++) {
        	nums[i] = 0;
        	for (int j = 1; j <= i; j++) {
        		nums[i] += nums[j-1] * nums[i - j];
        	}
        }

        return nums[n];
    }
    
    private static void test(int n) {
    	Q0096_UniqueBSTs q = new Q0096_UniqueBSTs();
    	System.out.printf("f(%d) = %d\n", n, q.numTrees(n));
    }
    
    public static void main(String[] args) {
    	test(1);
    	test(2);
    	test(3);
    	test(19);
    }
}
