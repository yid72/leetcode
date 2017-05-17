package dyd.leetcode.q015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Q15_3Sums {
    private static class Triplet {
        private int a;
        private int b;
        private int c;
        
        Triplet(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        
        @Override
        public int hashCode() {
            return (a + "_" + b + "_" + c).hashCode();
        }
        
        @Override
        public boolean equals(Object o) {
            if (o == null || !(o instanceof Triplet)) {
                return false;
            }
            
            if (this == o) {
                return true;
            }
            
            Triplet that = (Triplet) o;
            if (a == that.a && b == that.b && c == that.c) {
                return true;
            }
            else {
                return false;
            }
        }
        
        public List<Integer> toList() {
            List<Integer> list = new ArrayList<Integer>(3);
            list.add(a);
            list.add(b);
            list.add(c);
            return list;
        }
    }
    
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
        HashSet<Triplet> set = new HashSet<Triplet>();
        
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int c = -nums[i] - nums[j];
                int index = Arrays.binarySearch(nums, j+1, nums.length, c);
                if (index >= 0) {
                	set.add(new Triplet(nums[i], nums[j], nums[index]));
                }
            }
        }
        
        List<List<Integer>> results = new ArrayList<List<Integer>>(set.size());
        for (Triplet triplet : set) {
        	results.add(triplet.toList());
        }
        
        return results;
    }
    
    public static void main(String[] args) {
    	Q15_3Sums q = new Q15_3Sums();
    	List<List<Integer>> result = q.threeSum(new int[] {-1, 0, 1, 2, -1, -4});
    	for (List<Integer> list : result){
    		for (int a : list) {
    			System.out.print(a + " ");
    		}
    		System.out.println();
    	}
    }
}
