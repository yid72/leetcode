package dyd.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 165. Compare Version Numbers -- Medium
 *
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.
 *
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 *
 * The . character does not represent a decimal point and is used to separate number sequences.
 *
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
 *
 * You may assume the default revision number for each level of a version number to be 0. For example, version number 3.4 has a revision number of 3 and 4 for its first and second level revision number. Its third and fourth level revision number are both 0.
 *
 *
 *
 * Example 1:
 *
 * Input: version1 = "0.1", version2 = "1.1"
 * Output: -1
 * Example 2:
 *
 * Input: version1 = "1.0.1", version2 = "1"
 * Output: 1
 * Example 3:
 *
 * Input: version1 = "7.5.2.4", version2 = "7.5.3"
 * Output: -1
 * Example 4:
 *
 * Input: version1 = "1.01", version2 = "1.001"
 * Output: 0
 * Explanation: Ignoring leading zeroes, both “01” and “001" represent the same number “1”
 * Example 5:
 *
 * Input: version1 = "1.0", version2 = "1.0.0"
 * Output: 0
 * Explanation: The first version number does not have a third level revision number, which means its third level revision number is default to "0"
 */
public class Q00165_CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        List<Integer> v1 = parseComponents(version1);
        List<Integer> v2 = parseComponents(version2);
        for (int i = 0; i < Math.min(v1.size(), v2.size()); i++) {
            if (v1.get(i) < v2.get(i)) {
                return -1;
            } else if (v1.get(i) > v2.get(i)) {
                return 1;
            }
        }
        if (v1.size() < v2.size()) {
            return -1;
        } else if (v1.size() > v2.size()) {
            return 1;
        } else {
            return 0;
        }
    }

    private List<Integer> parseComponents(String version) {
        String[] strComponents = version.split("\\.");
        List<Integer> components = Arrays.stream(strComponents)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int i = components.size() - 1;
        for (; i > 0 && components.get(i) == 0; i--) {
        }
        List<Integer> ret = new ArrayList<>();
        for (int j = 0; j <= i; j++) {
            ret.add(components.get(j));
        }
        return ret;
    }

    public static void main(String[] args) {
        test("0.1", "1.1");
        test("1.01", "1");
        test("7.5.2.4", "7.5.3");
        test("1.01", "1.001");
        test("1.0", "1.0.0");
        test("0", "000");
    }

    private static void test(String v1, String v2) {
        Q00165_CompareVersionNumbers q = new Q00165_CompareVersionNumbers();
        String ret;
        switch (q.compareVersion(v1, v2)) {
            case -1:
                ret = "<";
                break;

            case 1:
                ret = ">";
                break;

            default:
                ret = "=";
                break;
        }
        System.out.printf("%s %s %s\n", v1, ret, v2);
    }
}
