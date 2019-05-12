package dyd.leetcode;

import dyd.leetcode.common.ListNode;
import dyd.leetcode.common.ListUtil;
import dyd.leetcode.common.PrintUtil;

/**
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 *
 * Given linked list -- head = [4,5,1,9], which looks like following:
 *
 * Example 1:
 *
 * Input: head = [4,5,1,9], node = 5
 * Output: [4,1,9]
 * Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
 * Example 2:
 *
 * Input: head = [4,5,1,9], node = 1
 * Output: [4,5,9]
 * Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
 *
 *
 * Note:
 *
 * The linked list will have at least two elements.
 * All of the nodes' values will be unique.
 * The given node will not be the tail and it will always be a valid node of the linked list.
 * Do not return anything from your function.
 */
public class Q00237_DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        ListNode nextNode = node.next;
        node.next = nextNode.next;
        nextNode.next = null;
    }

    public static void main(String[] args) {
        Q00237_DeleteNodeInALinkedList q = new Q00237_DeleteNodeInALinkedList();

        ListNode head = ListUtil.createList(new int[] {4, 5, 1, 9});
        System.out.println("List");
        PrintUtil.printList(head);
        ListNode node = head.next;
        q.deleteNode(node);
        System.out.println("After 5 is deleted");
        PrintUtil.printList(head);

        ListNode head1 = ListUtil.createList(new int[] {4, 5, 1, 9});
        System.out.println("List");
        PrintUtil.printList(head1);
        ListNode node1 = head1.next.next;
        q.deleteNode(node1);
        System.out.println("After 1 is deleted");
        PrintUtil.printList(head1);
    }
}
