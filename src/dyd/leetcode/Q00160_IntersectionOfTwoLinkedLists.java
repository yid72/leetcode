package dyd.leetcode;

import dyd.leetcode.common.ListNode;
import dyd.leetcode.common.ListUtil;
import dyd.leetcode.common.PrintUtil;

import java.util.Stack;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 * For example, the following two linked lists:
 *
 *
 * begin to intersect at node c1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * Output: Reference of the node with value = 8
 * Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 *
 *
 * Example 2:
 *
 *
 * Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * Output: Reference of the node with value = 2
 * Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [0,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
 *
 *
 * Example 3:
 *
 *
 * Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * Output: null
 * Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
 * Explanation: The two lists do not intersect, so return null.
 *
 *
 * Notes:
 *
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class Q00160_IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        Stack<ListNode> sA = buildStack(headA);
        Stack<ListNode> sB = buildStack(headB);
        ListNode intersection = null;
        while (!sA.empty() && !sB.empty()) {
            ListNode curNode = sA.pop();
            if (curNode == sB.pop()) {
                intersection = curNode;
            } else {
                return intersection;
            }
        }

        return intersection;
    }

    private Stack<ListNode> buildStack(ListNode head) {
        Stack<ListNode> s = new Stack<>();
        ListNode node = head;
        while (node != null) {
            s.push(node);
            node = node.next;
        }
        return s;
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

        Q00160_IntersectionOfTwoLinkedLists q = new Q00160_IntersectionOfTwoLinkedLists();
        ListNode intersection = q.getIntersectionNode(headA, headB);
        System.out.println("Intersection: " + ((intersection != null) ? intersection.val : null));
    }
}
