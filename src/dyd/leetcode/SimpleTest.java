package dyd.leetcode;

import java.util.HashMap;

public class SimpleTest {
	public static void main(String[] args) {
		HashMap<Integer, Object> map = new HashMap<Integer, Object>();
		Object obj = map.get(null);
		System.out.print(obj);
		
		map.put(null, new Object());
		System.out.print(map.get(null));
	}
}
