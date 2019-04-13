package dyd.leetcode;

import dyd.leetcode.common.ListNode;
import dyd.leetcode.common.ListUtil;

public class Q00141_LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode p1 = head;
        ListNode p2 = head.next;
        while (p1 != null && p2 != null && p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
            if (p2 != null) {
                p2 = p2.next;
            }
        }
        return p1 == p2;
    }

    public static void main(String[] args) {
        Q00141_LinkedListCycle q = new Q00141_LinkedListCycle();

        ListNode list1 = ListUtil.createList(new int[] {3,2,0,-4});
        list1.next.next.next.next = list1.next;
        System.out.println(q.hasCycle(list1));

        ListNode list2 = ListUtil.createList(new int[] {1,2});
        list2.next.next = list1;
        System.out.println(q.hasCycle(list2));

        ListNode list3 = ListUtil.createList(new int[] {1});
        System.out.print(q.hasCycle(list3));
    }
}
