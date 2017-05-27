package dyd.companies.snapchat;

import java.util.ArrayList;
import java.util.List;

/**
 *
Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
Each element is either an integer, or a list -- whose elements may also be integers or other lists.
Given the list [1,[4,[6]]], return 27. (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27)

 * @author dyd
 *
 */
public class WeightedIntegerSum {
	public int compute(List<Object> list) {
		return compute(list, 1);
	}
	
	private int compute(List<Object> list, int level) {
		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) instanceof Integer) {
				sum += level * ((Integer) list.get(i));
			}
			else if (list.get(i) instanceof List) {
				sum += compute((List<Object>) list.get(i), level + 1);
			}
			else {
				throw new IllegalArgumentException("Unknown element: " + list.get(i));
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		List<Object> l1 = new ArrayList<Object>();
		l1.add(6);
		List<Object> l2 = new ArrayList<Object>();
		l2.add(4);
		l2.add(l1);
		List<Object> list = new ArrayList<Object>();
		list.add(1);
		list.add(l2);
		WeightedIntegerSum sum = new WeightedIntegerSum();
		System.out.println(sum.compute(list));
	}
}
