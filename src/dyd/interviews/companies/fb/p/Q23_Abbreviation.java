package dyd.interviews.companies.fb.p;

public class Q23_Abbreviation {
    static String abbreviation(String a, String b) {
        if (a.length() < b.length()) {
            return "NO";
        }

        boolean found = true;
        int i = 0;
        int j = 0;
        for (; j < b.length(); j++) {
            char bChar = b.charAt(j);
            while (i < a.length() && a.charAt(i) != bChar
                    && Character.toUpperCase(a.charAt(i)) != bChar) {
                i ++;
            }
            if (i == a.length()) {
                found = true;
                break;
            }

            i++;
        }

        return (i < a.length() && j == b.length()) ? "YES" : "NO";
    }

    public static void main(String[] args) {
        test("daBcd", "ABC");
    }

    private static void test(String a, String b) {
        System.out.printf("a=%s, b=%s: %s\n", a, b, Q23_Abbreviation.abbreviation(a, b));
    }
}
