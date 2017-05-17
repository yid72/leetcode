package dyd.leetcode.q024;

import dyd.leetcode.ListNode;

public class Q24_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
    	if (head == null || head.next == null) {
    		return head;
    	}
    	
    	head = head.next;
    	
    	ListNode p1 = head;
    	ListNode p2 = head.next;
    	while (p1 != null && p2 != null) {
    		
    	}
    	
    	return head;
    }
}
