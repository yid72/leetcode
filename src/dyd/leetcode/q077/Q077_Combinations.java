package dyd.leetcode.q077;

import java.util.ArrayList;
import java.util.List;

public class Q077_Combinations {
	public List<List<Integer>> combine(int n, int k) {
		return combine(1, n, k);
	}
	
	  public List<List<Integer>> combine(int m, int n, int k) {
		  List<List<Integer>> results = new ArrayList<List<Integer>>();
		  
		  if (n < k) {
			  return results;
		  }
		  
		  if (k == 0 || n - m + 1 == k) {
			  List<Integer> items = new ArrayList<Integer>();
			  for (int i = m; i <= n; i++) {
				  items.add(i);
			  }
			  results.add(items);
			  return results;
		  }
		  
		  results.addAll(combine(m+1, n, k-1));
		  results.addAll(combine(m+1, n, k));
		  
		  return results;
	  }
  
//    public List<List<Integer>> combine(int n, int k) {
//        if (k == n || k == 0) {
//            List<Integer> row = new LinkedList<>();
//            for (int i = 1; i <= k; ++i) {
//                row.add(i);
//            }
//            return new LinkedList<>(Arrays.asList(row));
//        }
//        
//        List<List<Integer>> result = combine(n - 1, k - 1);
//        result.forEach(e -> e.add(n));
//        result.addAll(this.combine(n - 1, k));
//        return result;
//    }
  
  	public static void main(String[] args) {
  		Q077_Combinations q = new Q077_Combinations();
  		
  		List<List<Integer>> c = q.combine(4, 2);
  		System.out.println(c);
  	}
}
