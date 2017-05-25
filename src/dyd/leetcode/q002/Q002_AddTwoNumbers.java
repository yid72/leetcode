package dyd.leetcode.q002;

import dyd.leetcode.common.ListNode;

/**
 * 
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

 * @author dyd
 *
 */
public class Q002_AddTwoNumbers {
	private ListNode head;
	private ListNode curr;
	private int carry;
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return new ListNode(0);
		}
		
		if (l1 == null) {
			l1 = new ListNode(0);
		}
		
		if (l2 == null) {
			l2 = new ListNode(0);
		}
		
		head = null;
		curr = null; 
		carry = 0;
		
		while (l1 != null & l2 != null) {
			add(l1.val, l2.val);
			l1 = l1.next;
			l2 = l2.next;
		}
		
		while (l1 != null) {
			add(l1.val, 0);
			l1 = l1.next;
		}
		
		while (l2 != null) {
			add(0, l2.val);
			l2 = l2.next;
		}
		
		if (carry != 0) {
		    ListNode newNode = new ListNode(carry);
		    if (head == null) {
		        head = newNode;
		    }
		    else {
		        curr.next = newNode;
		    }
		}
		
		return head;
		
	}
	
	private void add(int n1, int n2) {
		int newValue = n1 + n2 + carry;
		int digit = newValue % 10;
		carry = newValue / 10;
		
		ListNode newNode = new ListNode(digit);
		if (curr == null) {
			head = newNode;
			curr = newNode;
		}
		else {
			curr.next = newNode;
			curr = curr.next;
		}
	}
}
