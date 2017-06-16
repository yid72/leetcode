package dyd.leetcode.q146;

import java.util.HashMap;

public class Q146_LRUCache {
    static class DeListNode<T> {
    	DeListNode<T> prev;
    	DeListNode<T> next;
    	T value;
    	
    	public DeListNode() {
    	}
    	
    	public DeListNode(T value) {
    		this.value = value;
    	}
    }    
    
    static class DeList<T> {
    	DeListNode<T> head;
    	DeListNode<T> tail;
    	
    	public void addFirst(DeListNode<T> node) {
    		if (head == node) {
    			return;
    		}
    		
    		if (head == null) {
    			head = node;
    			tail = node;
    		}
    		else {
    			node.prev = null;
    			node.next = head;
    			head.prev = node;
    			head = node;
    		}
    	}
    	
    	public DeListNode<T> removeLast() {
    		if (tail == null) {
    			return null;
    		}
    		
    		DeListNode<T> ret = tail;
    		
    		if (tail.prev != null) {
    			tail.prev.next = null;
    			tail = tail.prev;
    		}
    		
    		ret.prev = null;
    		ret.next = null;
    		
    		return ret;
    	}
    	
    	public void remove(DeListNode<T> node) {
    		if (node == null || head == null) {
    			return;
    		}
    		
    		if (node.prev != null) {
    			node.prev.next = node.next;
    		}
    		
    		if (node.next != null) {
    			node.next.prev = node.prev;
    		}
    		
    		if (node == head) {
    			head = node.next;
    		}
    		
    		if (node == tail) {
    			tail = node.prev;
    		}
    		
    		node.prev = null;
    		node.next = null;
    	}
    }
    
	static class KeyValue {
		int key;
		int value;
		public KeyValue() {
		}
		
		public KeyValue(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
	
	private int capacity;
	private HashMap<Integer, DeListNode<KeyValue>> cache;
	private DeList<KeyValue> lruList;
	
    public Q146_LRUCache(int capacity) {
    	this.capacity = capacity;
    	cache = new HashMap<>();
    	lruList = new DeList<>();
    }
    
    public int get(int key) {
    	if (cache.containsKey(key)) {
    		DeListNode<KeyValue> node = cache.get(key);
    		
    		lruList.remove(node);
    		lruList.addFirst(node);
    		return node.value.value;
    	}
    	else {
    		return -1;
    	}
    }
    
    public void set(int key, int value) {
    	if (capacity <= 0) {
    		return;
    	}
    	
    	if (cache.containsKey(key)) {
    		DeListNode<KeyValue> node = cache.get(key);
    		node.value.value = value;
    		
    		lruList.remove(node);
    		lruList.addFirst(node);
    		return;
    	}
    	
    	if (cache.size() >= capacity) {
    		DeListNode<KeyValue> node = lruList.removeLast();
    		cache.remove(node.value.key);
    	}
    	
    	DeListNode<KeyValue> newNode = new DeListNode<>(new KeyValue(key, value));
    	cache.put(key, newNode);
    	lruList.addFirst(newNode);
    }
}
