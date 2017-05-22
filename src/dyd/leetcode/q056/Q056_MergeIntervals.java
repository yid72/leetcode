package dyd.leetcode.q056;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

import dyd.leetcode.common.Interval;
import dyd.leetcode.common.PrintUtil;

/**
	Given a collection of intervals, merge all overlapping intervals.

	For example,
	Given [1,3],[2,6],[8,10],[15,18],
	return [1,6],[8,10],[15,18].
 * 
 * @author dyd
 *
 */
public class Q056_MergeIntervals {
	class IntervalComparator implements Comparator<Interval> {
		@Override
		public int compare(Interval o1, Interval o2) {
			if (o1.start < o2.start) {
				return -1;
			}
			else if (o1.start > o2.start) {
				return 1;
			}
			else {
				return 0;
			}
		}
	}
	
    public List<Interval> merge(List<Interval> intervals) {
    	List<Interval> ret = new ArrayList<Interval>();
    	if (intervals == null || intervals.size() == 0) {
    		return ret;
    	}
    	
    	Collections.sort(intervals, new IntervalComparator());
    	ret.add(intervals.get(0));
    	
    	for (int i = 1; i < intervals.size(); i++) {
    		Interval prev = ret.get(ret.size() - 1);
    		Interval cur = intervals.get(i);
    		if (prev.end >= cur.start) {
    			mergeWithPrevious(prev, cur);
    		}
    		else {
    			ret.add(cur);
    		}
    	}
    	
    	return ret;
    }
    
    private void mergeWithPrevious(Interval prev, Interval cur) {
    	if (prev.end < cur.end) {
    		prev.end = cur.end;
    	}
    }
    
    public static void main(String[] args) {
    	Q056_MergeIntervals q = new Q056_MergeIntervals();
    	
    	List<Interval> intervals = new ArrayList<Interval>();
    	intervals.add(new Interval(1, 3));
    	intervals.add(new Interval(2, 6));
    	intervals.add(new Interval(8, 10));
    	intervals.add(new Interval(15, 18));
    	intervals = q.merge(intervals);
    	for (int i = 0; i < intervals.size(); i++) {
    		PrintUtil.printInterval(intervals.get(i));
    	}
    	
    	System.out.println();
    	intervals.clear();
    	intervals.add(new Interval(1, 4));
    	intervals.add(new Interval(1, 4));
    	intervals = q.merge(intervals);
    	for (int i = 0; i < intervals.size(); i++) {
    		PrintUtil.printInterval(intervals.get(i));
    	}    	
    }
}
