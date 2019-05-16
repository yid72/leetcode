package dyd.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Q00707_DesignLinkedList {
    class MyLinkedListNode {
        int val;
        MyLinkedListNode next;

        MyLinkedListNode(int val) {
            this.val = val;
        }
    }

    private MyLinkedListNode head;
    private int size = 0;

    /** Initialize your data structure here. */
    public Q00707_DesignLinkedList() {
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        MyLinkedListNode curNode = head;
        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
        }
        return curNode.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        MyLinkedListNode newNode = new MyLinkedListNode(val);
        newNode.next = head;
        head = newNode;
        size ++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (size == 0) {
            addAtHead(val);
            return;
        }

        MyLinkedListNode curNode = head;
        while(curNode.next != null) {
            curNode = curNode.next;
        }
        MyLinkedListNode newNode = new MyLinkedListNode(val);
        curNode.next = newNode;
        size ++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of
     * linked list, the node will be appended to the end of linked list. If index is greater than the length,
     * the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }

        if (index <= 0) {
            addAtHead(val);
        } else if (index == size) {
            addAtTail(val);
        } else {
            MyLinkedListNode prevNode = head;
            for (int i = 0; i < index - 1; i++) {
                prevNode = prevNode.next;
            }

            MyLinkedListNode newNode = new MyLinkedListNode(val);
            newNode.next = prevNode.next;
            prevNode.next = newNode;
            size++;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        if (index == 0) {
            MyLinkedListNode deleteNode = head;
            head = head.next;
            deleteNode.next = null;
        } else {
            MyLinkedListNode prevNode = head;
            for (int i = 0; i < index - 1; i++) {
                prevNode = prevNode.next;
            }
            MyLinkedListNode deleteNode = prevNode.next;
            prevNode.next = deleteNode.next;
            deleteNode.next = null;
        }
        size --;
    }

    private void printMyList(Q00707_DesignLinkedList list) {
        MyLinkedListNode node = list.head;
        while (node != null) {
            System.out.print(node.val + " > ");
            node = node.next;
        }
        System.out.println();
    }

    @Test
    public void test1() {
        Q00707_DesignLinkedList list = new Q00707_DesignLinkedList();
        list.addAtHead(1);
        printMyList(list);

        list.addAtTail(3);
        printMyList(list);

        list.addAtIndex(1, 2);
        printMyList(list);

        System.out.println("list[1]=" + list.get(1));

        list.deleteAtIndex(1);
        printMyList(list);

        System.out.println("list[1]=" + list.get(1));
    }

    /**
     * ["MyLinkedList","addAtIndex","get","deleteAtIndex"]
     * [[],[-1,0],[0],[-1]]
     */
    @Test
    public void test2() {
        Q00707_DesignLinkedList list = new Q00707_DesignLinkedList();
        list.addAtIndex(-1, 0);
        printMyList(list);
        System.out.println("list[0]=" + list.get(0));
        list.deleteAtIndex(-1);
        printMyList(list);
    }
}
