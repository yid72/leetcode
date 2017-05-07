package dyd.leetcode.common;

public class PrintUtil {
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
	
	public static void printNode(RandomListNode node) {
		if (node != null) {
			System.out.print(node.label);
		}
		else {
			System.out.print("#");
		}
	}
}
