package dyd.leetcode;

import java.util.*;

/**
 * Design a max stack that supports push, pop, top, peekMax and popMax.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Remove the element on top of the stack and return it.
 * top() -- Get the element on the top.
 * peekMax() -- Retrieve the maximum element in the stack.
 * popMax() -- Retrieve the maximum element in the stack, and remove it. If you find more than one maximum elements,
 * only remove the top-most one.
 * Example 1:
 * MaxStack stack = new MaxStack();
 * stack.push(5);
 * stack.push(1);
 * stack.push(5);
 * stack.top(); -> 5
 * stack.popMax(); -> 5
 * stack.top(); -> 1
 * stack.peekMax(); -> 5
 * stack.pop(); -> 1
 * stack.top(); -> 5
 * Note:
 * -1e7 <= x <= 1e7
 * Number of operations won't exceed 10000.
 * The last four operations won't be called when stack is empty.
 */
public class Q00716_MaxStack {
    private LinkedList<Integer> elementList;
    private PriorityQueue<Integer> maxElementsQueue;

     /** initialize your data structure here. */
    public Q00716_MaxStack() {
        elementList = new LinkedList<>();
        maxElementsQueue = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void push(int x) {
        elementList.addFirst(x);
        maxElementsQueue.add(x);
    }

    public int pop() {
        int x = elementList.removeFirst();
        maxElementsQueue.remove(x);
        return x;
    }

    public int top() {
        return elementList.getFirst();
    }

    public int peekMax() {
        return maxElementsQueue.peek();
    }

    public int popMax() {
        int max = maxElementsQueue.poll();
        elementList.remove((Integer) max);
        return max;
    }

    public static void main(String[] args) {
        Q00716_MaxStack stack = new Q00716_MaxStack();
        stack.push(5);
        stack.push(1);
        stack.push(5);
        System.out.println(stack.top());
        System.out.println(stack.popMax());
        System.out.println(stack.top());
        System.out.println(stack.peekMax());
        System.out.println(stack.pop());
        System.out.println(stack.top());
    }
}
