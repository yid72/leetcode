package dyd.leetcode;

import dyd.leetcode.common.ListNode;
import dyd.leetcode.common.ListUtil;

/**
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 *
 * Example 1:
 *
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * Example 2:
 *
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 */
public class Q00061_RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        int size = size(head);
        if (size <= 1) {
            return head;
        }

        k = k % size;
        if (k == 0) {
            return head;
        }

        ListNode curNode = head;
        for (int i = 0; i < size - k - 1; i++) {
            curNode = curNode.next;
        }

        ListNode newHead = curNode.next;

        curNode.next = null;

        curNode = newHead;
        while (curNode.next != null) {
            curNode = curNode.next;
        }
        curNode.next = head;

        return newHead;
    }

    private int size(ListNode head) {
        int size = 0;
        ListNode curNode = head;
        while (curNode != null) {
            size ++;
            curNode = curNode.next;
        }
        return size;
    }

    public static void main(String[] args) {
        test(ListUtil.createList(new int[] {1, 2, 3, 4, 5}), 2);
        test(ListUtil.createList(new int[] {0, 1, 2}), 4);
    }

    private static void test(ListNode head, int k) {
        ListUtil.printList(head);
        System.out.println("k=" + k);
        Q00061_RotateList q = new Q00061_RotateList();
        ListUtil.printList(q.rotateRight(head, k));
    }
}

