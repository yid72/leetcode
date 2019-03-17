package dyd.leetcode;

import dyd.leetcode.common.ListNode;
import dyd.leetcode.common.ListUtil;
import dyd.leetcode.common.PrintUtil;

public class Q00206_ReverseLinkedLIst {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;

        while (head != null) {
            ListNode tempNode = head;
            head = head.next;
            tempNode.next = newHead;
            newHead = tempNode;
        }

        return newHead;
    }

    public static void main(String[] args) {
        Q00206_ReverseLinkedLIst solution = new Q00206_ReverseLinkedLIst();

        ListNode head = ListUtil.createList(new int[] {1, 2, 3, 4, 5});
        PrintUtil.printList(head);

        ListNode newHead = solution.reverseList(head);
        PrintUtil.printList(newHead);
    }
}
