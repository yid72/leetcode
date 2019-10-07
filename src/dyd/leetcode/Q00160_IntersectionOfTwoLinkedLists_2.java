package dyd.leetcode;

import dyd.leetcode.common.ListNode;
import dyd.leetcode.common.ListUtil;
import dyd.leetcode.common.PrintUtil;

public class Q00160_IntersectionOfTwoLinkedLists_2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        int sizeA = getSize(headA);
        int sizeB = getSize(headB);
        ListNode nodeA = (sizeA > sizeB) ? advance(headA, sizeA - sizeB) : headA;
        ListNode nodeB = (sizeB > sizeA) ? advance(headB, sizeB - sizeA) : headB;
        while (nodeA != nodeB && nodeA != null && nodeB != null) {
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return nodeA;
    }

    private int getSize(ListNode head) {
        int size = 0;
        ListNode node = head;
        while (node != null) {
            size ++;
            node = node.next;
        }
        return size;
    }

    private ListNode advance(ListNode head, int n) {
        ListNode node = head;
        for (int i = 0; i < n && node != null; i++) {
            node = node.next;
        }
        return node;
    }

    public static void main(String[] args) {
        // A:      4 -> 1 -> 8 -> 4 -> 5
        // B: 5 -> 0 -> 1 -> ..
        ListNode headA = ListUtil.createList(new int[] {4, 1, 8, 4, 5});
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(0);
        headB.next.next = new ListNode(1);
        headB.next.next.next = headA.next.next;
        test(headA, headB);

        // A: 0 -> 9 -> 1 -> 2 -> 4
        // B:           3 -> ..
        headA = ListUtil.createList(new int[] {0, 9, 1, 2, 4});
        headB = new ListNode(3);
        headB.next = headA.next.next.next;
        test(headA, headB);

        // A: 2 -> 6 -> 4
        // B: 1 -> 5
        headA = ListUtil.createList(new int[] {2, 6, 4});
        headB = new ListNode(1);
        headB.next = new ListNode(5);
        test(headA, headB);
    }

    private static void test(ListNode headA, ListNode headB) {
        System.out.print("A: ");
        PrintUtil.printList(headA);

        System.out.print("B: ");
        PrintUtil.printList(headB);

        Q00160_IntersectionOfTwoLinkedLists_2 q = new Q00160_IntersectionOfTwoLinkedLists_2();
        ListNode intersection = q.getIntersectionNode(headA, headB);
        System.out.println("Intersection: " + ((intersection != null) ? intersection.val : null));
    }

}