package dyd.leetcode.common;

public class PrintUtil {
	public static void printArray(int a[]) {
		printArray(a, 0, a.length);
	}
	
	public static void printArray(int[] a, int start, int len) {
		System.out.print("[");
		for (int i = start; i < start + len; i++) {
			System.out.print(a[i]);
			if (i < start + len - 1) {
				System.out.print(' ');
			}
		}
		System.out.println("]");
	}
	
	public static void printArray(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			printArray(a[i]);
		}
	}
	
	public static void printList(RandomListNode head) {
		if (head == null) {
			return;
		}
		
		System.out.print("[");
		
		RandomListNode curNode = head;
		while (curNode != null) {
			System.out.print("(");
			printNode(curNode.next);
			System.out.print(", ");
			printNode(curNode.random);
			System.out.print(")");
			curNode = curNode.next;
		}
		
		System.out.println("]");
	}
	
	public static void printList(ListNode list) {
		System.out.print("[");
		while (list != null) {
			System.out.print(list.val + " ");
			list = list.next;
		}
		System.out.println("]");
	}
	
	public static void printNode(RandomListNode node) {
		if (node != null) {
			System.out.print(node.label);
		}
		else {
			System.out.print("#");
		}
	}
	
	public static void printTreeNode(TreeNode node)
	{
		if (node != null) {
			System.out.print(node.val);
		}
	}
	
	public static void printInterval(Interval interval) {
		System.out.print("[" + interval.start + ", " + interval.end + "]");
	}
}
