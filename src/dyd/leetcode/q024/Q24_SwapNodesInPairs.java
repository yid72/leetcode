package dyd.leetcode.q024;

import dyd.leetcode.common.ListNode;
import dyd.leetcode.common.ListUtil;
import dyd.leetcode.common.PrintUtil;

/**
 * 
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

 * @author dyd
 *
 */
public class Q24_SwapNodesInPairs {
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
    	Q24_SwapNodesInPairs q = new Q24_SwapNodesInPairs();
    	
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
