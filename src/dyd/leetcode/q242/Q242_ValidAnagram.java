package dyd.leetcode.q242;

import java.util.HashMap;

public class Q242_ValidAnagram {
    public boolean isAnagram(String s, String t) {
    	if (s == null || t == null || s.length() != t.length()) {
    		return false;
    	}
    	
    	HashMap<Character, Integer> map1 = countCharacters(s);
    	HashMap<Character, Integer> map2 = countCharacters(t);
    	if (map1.size() != map2.size()) {
    		return false;
    	}
        
    	return map1.equals(map2);
    }
    
    private HashMap<Character, Integer> countCharacters(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
        	char ch = s.charAt(i);
        	if (!map.containsKey(ch)) {
        		map.put(ch, 1);
        	}
        	else {
        		map.put(ch, map.get(ch)+1);
        	}
        }
        return map;
    }
    
    public static void main(String[] args) {
    	Q242_ValidAnagram q = new Q242_ValidAnagram();
    	
    	System.out.println(q.isAnagram("anagram", "nagaram"));
    	System.out.println(q.isAnagram("car", "rat"));
    }
}
