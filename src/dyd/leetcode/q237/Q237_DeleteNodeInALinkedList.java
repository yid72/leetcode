package dyd.leetcode.q237;

import dyd.leetcode.common.ListNode;

public class Q237_DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        if (node == null) {
        	return;
        }
        
        if (node.next == null) {
        	throw new IllegalArgumentException("the give node is the tail. cannot be deleted");
        }
        
        ListNode nextNode = node.next.next;
        node.next.next = null;
        
        node.val = node.next.val;
        node.next = nextNode;
    }
}
