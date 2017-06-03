package dyd.leetcode.q014;

/**
 * 
 * @author duyid
 *
 */
public class Q014_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
    	if (strs == null || strs.length == 0) {
    		return "";
    	}
    	
    	if (strs.length == 1) {
    		return strs[0];
    	}
    	
    	int pos = 0;
    	boolean exit = false;
    	while (!exit) {
    		for (int i = 0; i < strs.length; i++) {
    			if (pos >= strs[i].length()) {
    				exit = true;
    				break;
    			}
    			else if (strs[i].charAt(pos) != strs[0].charAt(pos)) {
    				exit = true;
    				break;
    			}
    		}
    		if (!exit) {
    			pos ++;
    		}
    	}
    	return strs[0].substring(0, pos);
    }
    
    public static void main(String[] args) {
    	test(new String[] {"abc", "abdd", "ab"});
    	test(new String[] {"abc", "abdd", "a"});
    	test(new String[] {"abc", "abdd", ""});
    }
    
    private static void test(String[] strs) {
    	Q014_LongestCommonPrefix q = new Q014_LongestCommonPrefix();
    	System.out.println(q.longestCommonPrefix(strs));
    }
}
