package dyd.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

import dyd.leetcode.common.ListNode;
import dyd.leetcode.common.ListUtil;
import dyd.leetcode.common.PrintUtil;

/**
 * 
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

 * @author dyd
 */
public class Q00023_mergeKSortedLists {
	class ListNodeAscendComparator implements Comparator<ListNode> {
		@Override
		public int compare(ListNode o1, ListNode o2) {
			if (o1.val < o2.val) {
				return -1;
			}
			else if (o1.val > o2.val) {
				return 1;
			}
			else {
				return 0;
			}
		}	
	}
	
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}
		
		ListNode head = null;
		ListNode cur = null;
		
		PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(new ListNodeAscendComparator());
		
		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null) {
				minHeap.add(lists[i]);
			}
		}
		
		while (!minHeap.isEmpty()) {
			ListNode node = minHeap.poll();
			if (node.next != null) {
				minHeap.add(node.next);
			}
			
			node.next = null;
			
			if (head == null) {
				head = node;
				cur = node;
			}
			else {
				cur.next = node;
				cur = cur.next;
			}
		}
		
		return head;
	}
	
	public static void main(String[] args) {
		Q00023_mergeKSortedLists q = new Q00023_mergeKSortedLists();
		
		ListNode[] lists = new ListNode[3];
		lists[0] = ListUtil.createList(new int[] {-1, 1});
		lists[1] = ListUtil.createList(new int[] {-3, 1, 4});
		lists[2] = ListUtil.createList(new int[] {-2, -1, 0, 2});
		
		ListNode merged = q.mergeKLists(lists);
		PrintUtil.printList(merged);
	}
}
