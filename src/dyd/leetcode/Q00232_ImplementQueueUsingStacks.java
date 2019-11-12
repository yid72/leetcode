package dyd.leetcode;

import java.util.Stack;

/**
 * Implement the following operations of a queue using stacks.
 *
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * Example:
 *
 * MyQueue queue = new MyQueue();
 *
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // returns 1
 * queue.pop();   // returns 1
 * queue.empty(); // returns false
 * Notes:
 *
 * You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is
 * empty operations are valid.
 * Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque
 * (double-ended queue), as long as you use only standard operations of a stack.
 * You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty
 * queue).
 */
public class Q00232_ImplementQueueUsingStacks {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    /** Initialize your data structure here. */
    public Q00232_ImplementQueueUsingStacks() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!s2.empty()) {
            s1.push(s2.pop());
        }
        s1.push(x);
        while (!s1.empty()) {
            s2.push(s1.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return s2.pop();
    }

    /** Get the front element. */
    public int peek() {
        return s2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s2.empty();
    }

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        Q00232_ImplementQueueUsingStacks queue = new Q00232_ImplementQueueUsingStacks();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());  // returns 1
        System.out.println(queue.pop());   // returns 1
        System.out.println(queue.empty()); // returns false
        System.out.println(queue.pop());   // returns 2
        System.out.println(queue.empty()); // returns true
    }
}
