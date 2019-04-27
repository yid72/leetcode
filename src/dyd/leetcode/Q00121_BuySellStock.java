package dyd.leetcode;

import dyd.leetcode.common.PrintUtil;

public class Q00121_BuySellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
        	return 0;
        }
        
        int buy = prices[0];
        int sell = buy;
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
        	if (prices[i] > sell) {
        		sell = prices[i];
        	} else if (prices[i] < buy) {
        		buy = prices[i];
        		sell = buy;
        	}
        	maxProfit = Math.max(maxProfit, sell - buy);
        }
        
        return maxProfit;
    }
    
    public static void main(String[] args) {
    	Q00121_BuySellStock q = new Q00121_BuySellStock();
    	
    	test(new int[] {2, 4, 1});
    	test(new int[] {7, 1, 5, 3, 6, 4});
		test(new int[] {3, 6, 2, 7, 2, 5});
		test(new int[] {7, 6, 4, 3, 1});
    }
    
    private static void test(int[] prices) {
    	Q00121_BuySellStock q = new Q00121_BuySellStock();
    	PrintUtil.printArray(prices);
    	System.out.println(q.maxProfit(prices));   	
    }
}
