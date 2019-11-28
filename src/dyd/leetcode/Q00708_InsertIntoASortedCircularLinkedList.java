package dyd.leetcode;

/**
 * 708. Insert into a Sorted Circular Linked List -- Medium
 *
 * Given a node from a Circular Linked List which is sorted in ascending order, write a function to insert a value
 * insertVal into the list such that it remains a sorted circular list. The given node can be a reference to any single
 * node in the list, and may not be necessarily the smallest value in the circular list.
 *
 * If there are multiple suitable places for insertion, you may choose any place to insert the new value. After the
 * insertion, the circular list should remain sorted.
 *
 * If the list is empty (i.e., given node is null), you should create a new single circular list and return the
 * reference to that single node. Otherwise, you should return the original given node.
 *
 * Example 1:
 *
 * Input: head = [3,4,1], insertVal = 2
 * Output: [3,4,1,2]
 * Explanation: In the figure above, there is a sorted circular list of three elements. You are given a reference to
 * the node with value 3, and we need to insert 2 into the list. The new node should be inserted between node 1 and node
 * 3. After the insertion, the list should look like this, and we should still return node 3.
 *
 * Example 2:
 *
 * Input: head = [], insertVal = 1
 * Output: [1]
 * Explanation: The list is empty (given head is null). We create a new single circular list and return the reference to
 * that single node.
 * Example 3:
 *
 * Input: head = [1], insertVal = 0
 * Output: [1,0]
 *
 *
 * Constraints:
 *
 * 0 <= Number of Nodes <= 5 * 10^4
 * -10^6 <= Node.val <= 10^6
 * -10^6 <= insertVal <= 10^6
 */
public class Q00708_InsertIntoASortedCircularLinkedList {
    static class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

    public Node insert(Node head, int insertVal) {
        Node newNode = new Node(insertVal);

        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        if (head.next == head) {
            newNode.next = head;
            head.next = newNode;
            return head;
        }

        Node tail = head;
        while (tail.next != head && tail.next.val >= tail.val) {
            tail = tail.next;
        }

        if (insertVal >= tail.val) {
            newNode.next = tail.next;
            tail.next = newNode;
            return head;
        }

        Node node = tail;
        while (node.next.val <= insertVal && node.next != tail) {
            node = node.next;
        }

        newNode.next = node.next;
        node.next = newNode;
        return head;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    private static void test1() {
        Node head = new Node(3);
        head.next = new Node(3);
        head.next.next = new Node(4);
        head.next.next.next = new Node(1);
        head.next.next.next.next = head;
        test(head, 2);
    }

    private static void test2() {
        test(null, 2);
    }

    private static void test3() {
        Node head = new Node(1);
        head.next = head;
        test(head, 2);
    }

    private static void test4() {
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(5);
        head.next.next.next = head;
        test(head, 1);
    }

    private static void test(Node head, int insertVal) {
        print(head);
        System.out.println("insertVal=" + insertVal);
        Q00708_InsertIntoASortedCircularLinkedList q = new Q00708_InsertIntoASortedCircularLinkedList();
        q.insert(head, insertVal);
        print(head);
    }

    private static void print(Node head) {
        if (head == null) {
            return;
        }

        Node node = head;
        System.out.print(node.val);
        node = node.next;
        while (node != head) {
            System.out.print("->" + node.val);
            node = node.next;
        }
        System.out.println();
    }
}
