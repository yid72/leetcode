package dyd.leetcode.q121;

import dyd.leetcode.common.PrintUtil;

public class Q121_BuySellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
        	return 0;
        }
        
        int buy = prices[0];
        int sell = -1;
        int maxProfit = -1;
        for (int i = 1; i < prices.length; i++) {
        	if (sell == -1) {
        		if (prices[i] > buy) {
        			sell = prices[i];
        		}
        		else {
        			buy = prices[i];
        		}
        	}
        	else if (prices[i] > sell) {
        		sell = prices[i];
        	}
        	else if (prices[i] < buy) {
        		maxProfit = Math.max(maxProfit, sell - buy);
        		buy = prices[i];
        		sell = -1;
        	}
        }
        
		maxProfit = Math.max(maxProfit, sell - buy);
        return (maxProfit < 0) ? 0 : maxProfit;
    }
    
    public static void main(String[] args) {
    	Q121_BuySellStock q = new Q121_BuySellStock();
    	
    	test(new int[] {2, 4, 1});
    	test(new int[] {7, 1, 5, 3, 6, 4});
    }
    
    private static void test(int[] prices) {
    	Q121_BuySellStock q = new Q121_BuySellStock();
    	PrintUtil.printArray(prices);
    	System.out.println(q.maxProfit(prices));   	
    }
}
