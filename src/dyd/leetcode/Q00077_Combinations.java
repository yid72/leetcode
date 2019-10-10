package dyd.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q00077_Combinations {
	public List<List<Integer>> combine(int n, int k) {
		return combine(1, n, k);
	}

	private List<List<Integer>> combine(int m, int n, int k) {
		List<List<Integer>> results = new ArrayList<>();

		if (k == 0 || n < m || (n - m + 1) < k) {
			return results;
		}

		if (k == 1) {
			for (int i = m; i <= n; i++) {
				List<Integer> r = new LinkedList<>();
				r.add(i);
				results.add(r);
			}
			return results;
		}

		List<List<Integer>> subResults1 = combine(m + 1, n, k - 1);
		for (List<Integer> r : subResults1) {
			((LinkedList) r).addFirst(m);
			results.add(r);
		}

		List<List<Integer>> subResults2 = combine(m + 1, n, k);
		results.addAll(subResults2);

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
