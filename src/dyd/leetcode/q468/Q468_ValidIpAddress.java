package dyd.leetcode.q468;

import java.util.ArrayList;

public class Q468_ValidIpAddress {
    public String validIPAddress(String IP) {
        if (IP == null || IP.length() == 0) {
        	return "Neither";
        }
        
        if (isValidIpv4(IP)) {
        	return "IPv4";
        }
        
        if (isValidIpv6(IP)) {
        	return "IPv6";
        }
        
        return "Neither";
    }
    
    private boolean isValidIpv4(String IP) {
    	String[] tokens = parseTokens(IP, '.');
    	if (tokens.length != 4) {
    		return false;
    	}
    	
    	for (int i = 0; i < tokens.length; i++) {
    		String component = tokens[i];
    		if (component.charAt(0) == '0') {
    			return false;
    		}
    		
    		try {
    			int n = Integer.parseInt(component);
    			if (n < 0 || n > 255) {
    				return false;
    			}
    		}
    		catch (Exception e) {
    			return false;
    		}
    	}
    	
    	return true;
    }
    
    private boolean isValidIpv6(String IP) {
    	String[] tokens = parseTokens(IP, ':');
    	if (tokens.length != 8) {
    		return false;
    	}
    	
    	for (int i = 0; i < tokens.length; i++) {
    		String component = tokens[i];
    		if (component.length() > 4) {
    			return false;
    		}
    		
    		try {
    			int n = Integer.parseInt(component, 16);
    			if (n < 0) {
    				return false;
    			}
    		}
    		catch (Exception e) {
    			return false;
    		}
    	}
    	
    	return true;
    }
    
    private String[] parseTokens(String s, char separator) {
    	ArrayList<String> ret = new ArrayList<String>();
    	
    	int prev = 0;
    	int i = 0;
    	for (; i < s.length(); i++) {
    		if (s.charAt(i) == separator) {
    			if (prev < i) {
    				ret.add(s.substring(prev, i));
    			}
    			else {
    				ret.add(" ");
    			}
    			prev = i + 1;
    		}
    	}
    	
    	if (prev < i) {
    		ret.add(s.substring(prev, i));
    	}
    	else {
    		ret.add(" ");
    	}
    	
    	return ret.toArray(new String[ret.size()]);
    }
    
    public static void main(String[] args) {
    	Q468_ValidIpAddress q = new Q468_ValidIpAddress();
    	
    	System.out.println(q.validIPAddress("172.16.254.1"));
    	System.out.println(q.validIPAddress("256.256.256.256"));
    	System.out.println(q.validIPAddress("172.16.254.01"));
    	System.out.println(q.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
    	System.out.println(q.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
    	System.out.println(q.validIPAddress("1081:db8:85a3:01:-0:8A2E:0370:7334"));    	
    }
}
