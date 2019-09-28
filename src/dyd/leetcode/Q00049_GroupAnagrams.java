package dyd.leetcode;

import dyd.interviews.companies.amazon.onsite20170609.A3;

import java.util.*;

/**
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * Note:
 *
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */
public class Q00049_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            String sortedStr = sortString(str);
            List<String> anagrams = groups.get(sortedStr);
            if (anagrams == null) {
                anagrams = new ArrayList<>();
                groups.put(sortedStr, anagrams);
            }
            anagrams.add(str);
        }
        List<List<String>> results = new ArrayList<>();
        results.addAll(groups.values());
        return results;
    }

    private String sortString(String str) {
        char[] chs = str.toCharArray();
        Arrays.sort(chs);
        return new String(chs);
    }

    public static void main(String[] args) {
        A3 q = new A3();
        System.out.println(q.groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
