package dyd.leetcode;

import dyd.leetcode.common.PrintUtil;

import java.util.HashMap;

/**
 * Given two lists Aand B, and B is an anagram of A. B is an anagram of A means B is made by randomizing the order of the elements in A.
 *
 * We want to find an index mapping P, from A to B. A mapping P[i] = j means the ith element in A appears in B at index j.
 *
 * These lists A and B may contain duplicates. If there are multiple answers, output any of them.
 *
 * For example, given
 *
 * A = [12, 28, 46, 32, 50]
 * B = [50, 12, 32, 46, 28]
 * We should return
 * [1, 4, 3, 2, 0]
 * as P[0] = 1 because the 0th element of A appears at B[1], and P[1] = 4 because the 1st element of A appears at B[4], and so on.
 * Note:
 *
 * A, B have equal lengths in range [1, 100].
 * A[i], B[i] are integers in range [0, 10^5].
 */
public class Q00760_FindAnagramMappings {
    public int[] anagramMappings(int[] A, int[] B) {
        HashMap<Integer, Integer> bIndices = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            bIndices.put(B[i], i);
        }

        int[] mappings = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            mappings[i] = bIndices.get(A[i]);
        }

        return mappings;
    }

    public static void main(String[] args) {
        Q00760_FindAnagramMappings q = new Q00760_FindAnagramMappings();
        int[] A = {12, 28, 46, 32, 50};
        int[] B = {50, 12, 32, 46, 28};
        int[] mappings = q.anagramMappings(A, B);
        PrintUtil.printArray(mappings);
    }
}
