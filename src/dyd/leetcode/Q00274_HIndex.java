package dyd.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * 274. H-Index
 * Medium
 *
 * 483
 *
 * 809
 *
 * Favorite
 *
 * Share
 * Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute
 * the researcher's h-index.
 *
 * According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least
 * h citations each, and the other N − h papers have no more than h citations each."
 *
 * Example:
 *
 * Input: citations = [3,0,6,1,5]
 * Output: 3
 * Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had
 *              received 3, 0, 6, 1, 5 citations respectively.
 *              Since the researcher has 3 papers with at least 3 citations each and the remaining
 *              two with no more than 3 citations each, her h-index is 3.
 * Note: If there are several possible values for h, the maximum one is taken as the h-index.
 */
public class Q00274_HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length;
        for(int i = 0; i < len; i++) {
            if(citations[i] >= len - i) {
                return len - i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        test(new int[] {0});
        test(new int[] {100});
        test(new int[] {3,0,6,1,5});
    }

    private static void test(int[] cititions) {
        Q00274_HIndex q = new Q00274_HIndex();
        System.out.println(Arrays.toString(cititions) + ": " + q.hIndex(cititions));
    }
}
