package dyd.leetcode;

/**
 * 96. Unique Binary Search Trees -- Medium
 *
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 *
 * Example:
 *
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class Q00096_UniqueBSTs {
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
    	Q00096_UniqueBSTs q = new Q00096_UniqueBSTs();
    	System.out.printf("f(%d) = %d\n", n, q.numTrees(n));
    }
    
    public static void main(String[] args) {
    	test(1);
    	test(2);
    	test(3);
    	test(19);
    }
}
