package dyd.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q00077_Combinations {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> results = new ArrayList<>();

		if (k == 0 || n < k) {
			return results;
		}

		if (k == 1) {
			for (int i = 1; i <= n; i++) {
				List<Integer> r = new LinkedList<>();
				r.add(i);
				results.add(r);
			}
			return results;
		}

		List<List<Integer>> subResults2 = combine(n - 1, k);
		results.addAll(subResults2);

		List<List<Integer>> subResults1 = combine(n - 1, k - 1);
		for (List<Integer> r : subResults1) {
			r.add(n);
			results.add(r);
		}

		return results;
	}
	
  	public static void main(String[] args) {
		test(4, 0);
		test(4, 1);
		test(4, 2);
		test(4, 3);
		test(4, 4);
		test(4, 5);
  	}

  	private static void test(int n, int k) {
		Q00077_Combinations q = new Q00077_Combinations();

		List<List<Integer>> c = q.combine(n, k);
		System.out.println("n=" + n + ", k=" + k + ": " + c);
	}
}
