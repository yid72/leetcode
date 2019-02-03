package dyd.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class Q00146_LRUCache_LinkedHashMap extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public Q00146_LRUCache_LinkedHashMap(int capacity) {
        super(capacity*2,0.6f,true);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (containsKey(key)) {
            return super.get(key);
        }
        return -1;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        Q00146_LRUCache_LinkedHashMap lruCache = new Q00146_LRUCache_LinkedHashMap(2);
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
