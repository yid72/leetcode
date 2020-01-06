package dyd.leetcode.contests.p20191012;

import java.util.*;

public class Q05298 {
    private String[] words;
    private String result;

    public boolean isSolvable(String[] words, String result) {
        this.words = words;
        this.result = result;

        Set<Character> set = new HashSet<>();
        for (String word : words) {
            set.addAll(findLetters(word));
        }
        set.addAll(findLetters(result));

        char[] letters = new char[set.size()];
        int i = 0;
        for (Character ch : set) {
            letters[i ++] = ch;
        }

        List<Integer> digits = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        return find(letters, 0, digits, new HashMap<>());
    }

    private boolean find(char[] letters, int pos, List<Integer> digits, Map<Character, Integer> map) {
        if (pos < letters.length) {
            for (int i = 0; i < digits.size(); i++) {
                int curDigit = digits.get(i);
                map.put(letters[pos], curDigit);

                List<Integer> newDigits = new ArrayList<>();
                for (int j = 0; j < digits.size(); j++) {
                    if (j != i) {
                        newDigits.add(digits.get(j));
                    }
                }

                if (find(letters, pos + 1, newDigits, map)) {
                    return true;
                }

                map.remove(letters[pos]);
            }
            return false;
        }

        int sum = 0;
        for (String word : words) {
            sum += wordToNumber(word, map);
        }

        int numResult = wordToNumber(result, map);
        return sum == numResult;
    }

    private Set<Character> findLetters(String word) {
        Set<Character> ret = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            ret.add(word.charAt(i));
        }
        return ret;
    }

    private int wordToNumber(String word, Map<Character, Integer> map) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            sb.append(map.get(word.charAt(i)));
        }
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
//        test(new String[] {"SEND","MORE"}, "MONEY");
        test(new String[] {"LEET","CODE"}, "POINT");
    }

    private static void test(String[] words, String result) {
        Q05298 q = new Q05298();
        System.out.printf("words=%s, result=%s: %b", Arrays.toString(words), result, q.isSolvable(words, result));
    }
}
