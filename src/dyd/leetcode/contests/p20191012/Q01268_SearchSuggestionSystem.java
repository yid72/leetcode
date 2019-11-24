package dyd.leetcode.contests.p20191012;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1268. Search Suggestions System -- Medium
 *
 * Given an array of strings products and a string searchWord. We want to design a system that suggests at most three product names from products after each character of searchWord is typed. Suggested products should have common prefix with the searchWord. If there are more than three products with a common prefix return the three lexicographically minimums products.
 *
 * Return list of lists of the suggested products after each character of searchWord is typed.
 *
 * Example 1:
 *
 * Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
 * Output: [
 * ["mobile","moneypot","monitor"],
 * ["mobile","moneypot","monitor"],
 * ["mouse","mousepad"],
 * ["mouse","mousepad"],
 * ["mouse","mousepad"]
 * ]
 * Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"]
 * After typing m and mo all products match and we show user ["mobile","moneypot","monitor"]
 * After typing mou, mous and mouse the system suggests ["mouse","mousepad"]
 * Example 2:
 *
 * Input: products = ["havana"], searchWord = "havana"
 * Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
 * Example 3:
 *
 * Input: products = ["bags","baggage","banner","box","cloths"], searchWord = "bags"
 * Output: [["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]
 * Example 4:
 *
 * Input: products = ["havana"], searchWord = "tatiana"
 * Output: [[],[],[],[],[],[],[]]
 *
 *
 * Constraints:
 *
 * 1 <= products.length <= 1000
 * 1 <= Σ products[i].length <= 2 * 10^4
 * All characters of products[i] are lower-case English letters.
 * 1 <= searchWord.length <= 1000
 * All characters of searchWord are lower-case English letters.
 */
public class Q01268_SearchSuggestionSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);

        List<List<String>> ret = new ArrayList<>();

        List<String> words = new ArrayList<>();
        for (String product : products) {
            words.add(product);
        }

        for (int i = 0; i < searchWord.length(); i++) {
            List<String> nextWords = new ArrayList<>();
            char ch = searchWord.charAt(i);
            for (int j = 0; j < words.size(); j++) {
                String word = words.get(j);
                if (i < word.length() && word.charAt(i) == ch) {
                    nextWords.add(words.get(j));
                }
            }

            List<String> suggestions = new ArrayList<>();
            int size = Math.min(nextWords.size(), 3);
            for (int j = 0; j < size; j++) {
                suggestions.add(nextWords.get(j));
            }
            ret.add(suggestions);

            words = nextWords;
        }

        return ret;
    }

    public static void main(String[] args) {
        test(new String[] {"mobile","mouse","moneypot","monitor","mousepad"}, "mouse");
    }

    private static void test(String[] products, String searchWord) {
        System.out.printf("products=%s, searchWord=%s\n", products, searchWord);
        Q01268_SearchSuggestionSystem q = new Q01268_SearchSuggestionSystem();
        System.out.println(q.suggestedProducts(products, searchWord));
    }
}
