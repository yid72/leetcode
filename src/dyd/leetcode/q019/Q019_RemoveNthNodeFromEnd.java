package dyd.leetcode.q019;

import dyd.leetcode.common.ListNode;
import dyd.leetcode.common.ListUtil;
import dyd.leetcode.common.PrintUtil;

/**
 * 
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.

 * @author dyd
 *
 */
public class Q019_RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	if (head == null) {
    		return null;
    	}
    	
    	ListNode start = new ListNode(0);
    	start.next = head;
    	
        ListNode p1 = start;
        ListNode p2 = start.next;
        
        for (int i = 1; i < n; i++) {
        	p2 = p2.next;
        }
        
        while (p2.next != null) {
        	p2 = p2.next;
        	p1 = p1.next;
        }
        
        ListNode temp = p1.next.next;
        p1.next.next = null;
        p1.next = temp;
      
        return start.next;
    }
    
    public static void main(String[] args) {
    	Q019_RemoveNthNodeFromEnd q = new Q019_RemoveNthNodeFromEnd();
    	
    	ListNode head = ListUtil.createList(new int[] {1, 2, 3, 4, 5});
    	PrintUtil.printList(head);
    	q.removeNthFromEnd(head, 1);
    	PrintUtil.printList(head);
    	
    	head = ListUtil.createList(new int[] {1, 2, 3, 4, 5});
    	PrintUtil.printList(head);
    	q.removeNthFromEnd(head, 2);
    	PrintUtil.printList(head);   	
    }
}
