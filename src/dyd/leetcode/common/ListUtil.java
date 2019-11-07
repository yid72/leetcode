package dyd.leetcode.common;

public class ListUtil {
	public static ListNode createList(int[] values) {
		if (values == null || values.length == 0) {
			return null;
		}
		
		ListNode head = new ListNode(values[0]);
		ListNode prevNode = head;
		for (int i = 1; i < values.length; i++) {
			prevNode.next = new ListNode(values[i]);
			prevNode = prevNode.next;
		}
		
		return head;
	}

	public static void printList(ListNode list) {
		System.out.print("[");
		if (list != null) {
			System.out.print(list.val);
			list = list.next;
		}
		while (list != null) {
			System.out.print(" " + list.val);
			list = list.next;
		}
		System.out.println("]");
	}
}
