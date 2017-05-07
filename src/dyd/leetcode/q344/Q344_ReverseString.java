package dyd.leetcode.q344;

public class Q344_ReverseString {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
        	sb.append(s.charAt(i));
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
    	String s = "abcdef";
    	System.out.println(new Q344_ReverseString().solution(s));
    }
}
