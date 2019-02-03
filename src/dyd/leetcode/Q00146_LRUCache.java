package dyd.leetcode;

import java.util.HashMap;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following
 * operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it
 * should invalidate the least recently used item before inserting a new item.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Example:
 *
 * LRUCache cache = new LRUCache(2) // Capacity
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // returns 1
 * cache.put(3,3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4,4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 */
public class Q00146_LRUCache {
    static class DeListNode<T> {
    	DeListNode<T> prev;
    	DeListNode<T> next;
    	T value;
    	
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
	
    public Q00146_LRUCache(int capacity) {
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
    
    public void put(int key, int value) {
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

    public static void main(String[] args) {
		Q00146_LRUCache lruCache = new Q00146_LRUCache(2);
		lruCache.put(1, 1);
		lruCache.put(2, 2);
		System.out.println(lruCache.get(1));
		lruCache.put(3, 3);
		System.out.println(lruCache.get(2));
		lruCache.put(4, 4);
		System.out.println(lruCache.get(1));
		System.out.println(lruCache.get(3));
		System.out.println(lruCache.get(4));
	}
}
