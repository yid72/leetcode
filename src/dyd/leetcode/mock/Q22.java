package dyd.leetcode.mock;

public class Q22 {
    public String gcdOfStrings(String str1, String str2) {
        String c1 = smallestComponent(str1);
        String c2 = smallestComponent(str2);
        if (c1. equals(c2)) {
            return c1;
        } else {
            return "";
        }
    }

    private String smallestComponent(String str) {
        int i = 1;
        for (; i < str.length(); i++) {
            for (int j = i; j < 2*i; j++) {
                int k = j;
                for (; k < str.length(); k += i) {
                    if (str.charAt(j) != str.charAt(j - i)) {
                        break;
                    }
                }
            }
//            if (j >= str.length()) {
//                break;
//            }
        }
        return str.substring(0, i);
    }

    public static void main(String[] args) {
//        test("ABCABC", "ABC");
//        test("ABABAB", "ABAB");
//        test("LEET", "CODE");
//        test("ABCDEF", "ABAB");
        test("BXDCPBACKMBXDCPBACKMBXDCPBACKMBXDCPBACKMBXDCPBACKM",
                "BXDCPBACKMBXDCPBACKMBXDCPBACKMBXDCPBACKMBXDCPBACKMBXDCPBACKMBXDCPBACKMBXDCPBACKMBXDCPBACKMBXDCPBACKMBXDCPBACKMBXDCPBACKMBXDCPBACKMBXDCPBACKMBXDCPBACKMBXDCPBACKMBXDCPBACKM");
    }

    private static void test(String str1, String str2) {
        Q22 q = new Q22();
        System.out.printf("s1=%s, s2=%s: %s\n", str1, str2, q.gcdOfStrings(str1, str2));
    }
}
