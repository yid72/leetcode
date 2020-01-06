package dyd.leetcode;

import dyd.leetcode.common.ListNode;

/**
 * 92. Reverse Linked List II -- Medium
 *
 * Reverse a linked list from position m to n. Do it in one-pass.
 *
 * Note: 1 ≤ m ≤ n ≤ length of list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 */
public class Q00092_ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode node = head;
        for (int i = 1; i < m - 1; i++) {
            node = node.next;
        }

        for (int i = 1; i <= n; i++) {

        }

        return null;
    }
}
