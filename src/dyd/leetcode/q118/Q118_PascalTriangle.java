package dyd.leetcode.q118;

import java.util.ArrayList;
import java.util.List;

import dyd.leetcode.common.PrintUtil;

/**
 * 
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

 * @author dyd
 *
 */
public class Q118_PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> results = new ArrayList<List<Integer>>();
    	
    	List<Integer> prevValues = null;
        for (int i = 1; i <= numRows; i++) {
        	List<Integer> curValues = generateNext(prevValues);
        	results.add(curValues);
        	prevValues = curValues;
        }
        
        return results;
    }
    
    private List<Integer> generateNext(List<Integer> curValues) {
    	List<Integer> nextValues = new ArrayList<Integer>();
    	nextValues.add(1);
    	
    	if (curValues == null || curValues.size() == 0) {
    		return nextValues;
    	}

    	for (int i = 1; i < curValues.size(); i++) {
    		nextValues.add((curValues.get(i-1) + curValues.get(i)));
    	}
    	
    	nextValues.add(1);
    	return nextValues;
    }
    
    private static void test(int n) {
    	Q118_PascalTriangle q = new Q118_PascalTriangle();
    	System.out.println("n = " + n);
    	PrintUtil.printListList(q.generate(n));   	
    }
    
    public static void main(String[] args) {
    	test(5);
    	test(10);
    }
}
