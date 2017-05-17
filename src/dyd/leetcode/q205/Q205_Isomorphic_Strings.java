package dyd.leetcode.q205;

import java.util.HashMap;

public class Q205_Isomorphic_Strings {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        
        if (s.length() == 0) {
            return true;
        }
        
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();
        
        int len = s.length();
        for (int i = 0; i < len; i++) {
        	char ch1 = s.charAt(i);
        	char ch2 = t.charAt(i);
        	if (map1.containsKey(ch1)) {
        		if (ch2 != map1.get(ch1)) {
        			return false;
        		}
        	}
        	else if (map2.containsKey(ch2)) {
        		return false;
        	}
        	else {
        		map1.put(ch1, ch2);
        		map2.put(ch2, ch1);
        	}
        }
        return true;
    }
    
    public static void main(String[] args) {
    	Q205_Isomorphic_Strings q = new Q205_Isomorphic_Strings();
    	System.out.println(q.isIsomorphic("egg", "add"));
    	System.out.println(q.isIsomorphic("foo", "bar"));
    	System.out.println(q.isIsomorphic("paper", "title"));
   }
}
