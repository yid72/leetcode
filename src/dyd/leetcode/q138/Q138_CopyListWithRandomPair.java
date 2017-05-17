package dyd.leetcode.q138;

import java.util.HashMap;
import java.util.Map;

import dyd.leetcode.common.PrintUtil;
import dyd.leetcode.common.RandomListNode;

public class Q138_CopyListWithRandomPair {
    public RandomListNode copyRandomList(RandomListNode head) {
    	  return copyHelper(head, new HashMap<Integer, RandomListNode>());
    }
    
    public RandomListNode copyHelper(RandomListNode head, Map<Integer, RandomListNode> map) {
        if (head == null) {
            return null;
        }
        
        RandomListNode newHead = new RandomListNode(head.label);
        RandomListNode newCurNode = newHead;
        
        RandomListNode curNode = head;
        while (curNode != null) {
        	if (curNode.next != null) {
        		newCurNode.next = shallowCopyNode(curNode.next, map);
        	}
        	curNode = curNode.next;
        	newCurNode = newCurNode.next;
        }
        
        curNode = head;
        newCurNode = newHead;
        while (curNode != null) {
        	if (curNode.random != null) {
        		newCurNode.random = shallowCopyNode(curNode.random, map);
        	}
        	curNode = curNode.next;
        	newCurNode = newCurNode.next;
        }
        
        return newHead;
    }
    
    private RandomListNode shallowCopyNode(RandomListNode node, Map<Integer, RandomListNode> map) {
    	RandomListNode newNode = map.get(node.label);
    	if (newNode == null) {
    		newNode = new RandomListNode(node.label);
        	map.put(node.label, newNode);
    	}
    	return newNode;
    }
    
    public static void main(String[] args) {
    	RandomListNode node1 = new RandomListNode(1);
    	RandomListNode node2 = new RandomListNode(2);
    	RandomListNode node3 = new RandomListNode(3);
    	RandomListNode node4 = new RandomListNode(4);
    	node1.next = node2;
    	node1.random = node3;
    	node2.next = node3;
    	node2.random = node1;
    	node3.next = node4;
    	node3.random = null;
    	node4.random = node4;
    	PrintUtil.printList(node1);
    	
    	RandomListNode newHead = new Q138_CopyListWithRandomPair().copyRandomList(node1);
    	PrintUtil.printList(newHead);
    }
}
