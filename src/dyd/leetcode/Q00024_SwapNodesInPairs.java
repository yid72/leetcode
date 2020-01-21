package dyd.leetcode;

import dyd.leetcode.common.ListNode;
import dyd.leetcode.common.ListUtil;
import dyd.leetcode.common.PrintUtil;

/**
 * 24. Swap Nodes in Pairs -- Medium
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example:
 *
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 */
public class Q00024_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
    	if (head == null || head.next == null) {
    		return head;
    	}
    	
    	ListNode start = new ListNode(0);
    	start.next = head;
    	
    	ListNode p1 = start;
    	ListNode p2 = p1.next;
    	ListNode p3 = p2.next;
    	
    	while (p2 != null && p3 != null) {
    		ListNode temp = p3.next;
    		p1.next = p3;
    		p2.next = temp;
    		p3.next = p2;
    		
    		p1 = p2;
    		p2 = temp;
    		if (p2 != null) {
    			p3 = p2.next;
    		}
    	}
    	
    	head = start.next;
    	start.next = null;
    	return head;
    }
    
    public static void main(String[] args) {
    	Q00024_SwapNodesInPairs q = new Q00024_SwapNodesInPairs();
    	
    	ListNode head = ListUtil.createList(new int[] {1, 2, 3, 4});
    	PrintUtil.printList(head);
    	System.out.println("=>");
    	PrintUtil.printList(q.swapPairs(head));
    	
    	System.out.println();
    	head = ListUtil.createList(new int[] {1, 2, 3});
    	PrintUtil.printList(head);
    	System.out.println("=>");    	
    	PrintUtil.printList(q.swapPairs(head));
    	
    	System.out.println();
    	head = ListUtil.createList(new int[] {1, 2});
    	PrintUtil.printList(head);
    	System.out.println("=>");    	
    	PrintUtil.printList(q.swapPairs(head));
    	
    	System.out.println();
    	head = ListUtil.createList(new int[] {1});
    	PrintUtil.printList(head);
    	System.out.println("=>");    	
    	PrintUtil.printList(q.swapPairs(head));    	
    }
}
