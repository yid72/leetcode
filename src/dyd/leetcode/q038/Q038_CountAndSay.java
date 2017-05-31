package dyd.leetcode.q038;

public class Q038_CountAndSay {
    public String countAndSay(int n) {
    	String ret = "1";
    	for (int i = 2; i <= n; i++) {
    		ret = countAndSay(ret);
    	}
    	return ret;
    }
    
    private String countAndSay(String element) {
    	StringBuilder sb = new StringBuilder();
    	
    	int prevPos = 0;
    	char prevCh = element.charAt(0);
    	for (int i = 1; i < element.length(); i++) {
    		if (element.charAt(i) != prevCh) {
    			sb.append(i-prevPos);
    			sb.append(prevCh);
    			prevPos = i;
    			prevCh = element.charAt(i);
    		}
    	}
    	
    	if (prevPos <= element.length() - 1) {
			sb.append(element.length() - prevPos);
			sb.append(prevCh);
    	}
    	
    	return sb.toString();
    }
    
    public static void main(String[] args) {
    	Q038_CountAndSay q = new Q038_CountAndSay();
    	
    	System.out.println(q.countAndSay(1));
    	System.out.println(q.countAndSay(2));
    	System.out.println(q.countAndSay(3));
    	System.out.println(q.countAndSay(4));
    	System.out.println(q.countAndSay(5));
    }
}
