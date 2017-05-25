package dyd.leetcode.q023;

import dyd.leetcode.common.ListNode;

/**
 * 
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

 * @author dyd
 *
 */
public class Q023_MergeKSortedLists_1 {
    static class MinListNodeHeap {
    	private ListNode[] nodes;
    	private int length;
    	
    	public MinListNodeHeap(ListNode[] nodes) {
    		this.nodes = nodes;
    		this.length = nodes.length;
    		heapify();
    	}
    	
    	public void heapify() {
    		for (int i = length/2; i >= 0; i--) {
    			siftDown(i);
    		}
    	}
    	
    	public int size() {
    		return length;
    	}
    	
    	public ListNode min() {
    		if (length == 0) {
    			return null;
    		}
    		
    		return nodes[0];
    	}
    	
    	public void siftDown(int start) {
    		int minIndex = start;
    		
    		int leftChild = start*2+1;
    		if (leftChild >= length) {
    			return;
    		}
    		
    		if (nodes[minIndex].val > nodes[leftChild].val) {
    			minIndex = leftChild;
    		}
    		
    		int rightChild = leftChild + 1;
    		if (rightChild < length 
    				&& nodes[minIndex].val > nodes[rightChild].val) {
    			minIndex = rightChild;
    		}
    		
    		if (minIndex != start) {
    			ListNode temp = nodes[start];
    			nodes[start] = nodes[minIndex];
    			nodes[minIndex] = temp;
    			
    			siftDown(minIndex);
    		}
    	}
    	
    	public void deleteNode(int index) {
    		if (index < 0 || index >= length) {
    			return;
    		}
    		
    		nodes[index] = nodes[length-1];
    		length --;
    		
    		siftDown(index);
    	}
    	
    	public void setNode(int index, ListNode newNode) {
    		if (index < 0 || index >= length) {
    			return;
    		}
    		
    		nodes[index] = newNode;
    		siftDown(index);
    	}
    }
    
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}
		
		ListNode mergedHead = null;
		ListNode mergedCur = null;
		
		ListNode[] curNodes = new ListNode[lists.length];
		System.arraycopy(lists, 0, curNodes, 0, lists.length);
		MinListNodeHeap heap = new MinListNodeHeap(curNodes);
		
		ListNode minNode = heap.min();
		while (minNode != null) {
			ListNode nextNode = minNode.next;
			minNode.next = null;
			
			if (mergedHead == null) {
				mergedHead = minNode;
				mergedCur = minNode;
			}
			else {
				mergedCur.next = minNode;
				mergedCur = minNode;
			}
			
			if (nextNode == null) {
				heap.deleteNode(0);
			}
			else {
				heap.setNode(0, nextNode);
			}
			
			minNode = heap.min();
		}
		
		return mergedHead;
	}
}
