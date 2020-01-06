package dyd.leetcode.contests.p20191012;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q2 {
    private int m;

    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> ret = new ArrayList<>();

        if (upper < 0 || lower < 0 || colsum.length == 0) {
            return ret;
        }

        this.m = colsum.length;

        List<List<Integer>> rowUppers = reconstructRows(upper, 0);
        List<List<Integer>> rowLowers = reconstructRows(lower, 0);
        for (int i = 0; i < rowUppers.size(); i++) {
            for (int j = 0; j < rowLowers.size(); j++) {
                List<Integer> rowUpper = rowUppers.get(i);
                List<Integer> rowLower = rowLowers.get(j);
                if (validateColsum(colsum, rowUpper, rowLower)) {
                    ret.add(rowUpper);
                    ret.add(rowLower);
                    return ret;
                }
            }
        }

        return ret;
    }

    private List<List<Integer>> reconstructRows(int sum, int pos) {
        List<List<Integer>> rows = new ArrayList<>();

        if (pos == m - 1) {
            List<Integer> row = new ArrayList<>();
            rows.add(row);
            if (sum == 1) {
                row.add(1);
            } else {
                row.add(0);
            }
            return rows;
        }

        List<List<Integer>> subRow0s = reconstructRows(sum, pos + 1);
        for (List<Integer> subRow0 : subRow0s) {
            subRow0.add(0);
            rows.add(subRow0);
        }

        if (sum >= 1) {
            List<List<Integer>> subRow1s = reconstructRows(sum - 1, pos + 1);
            for (List<Integer> subRow1 : subRow1s) {
                subRow1.add(1);
                rows.add(subRow1);
            }
        }

        return rows;
    }

    private boolean validateColsum(int[] colsum, List<Integer> upper, List<Integer> lower) {
        for (int i = 0; i < upper.size(); i++) {
            if (colsum[i] != upper.get(i) + lower.get(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] arggs) {
//        test(2, 1, new int[] {1, 1, 1});
//        test(2, 3, new int[] {2, 2, 1, 1});
//        test(5, 5, new int[] {2,1,2,0,1,0,1,2,0,1});
        test(15, 15, new int[] {2,1,0,1,1,1,1,0,1,2,1,2,1,0,1});
    }

    private static void test(int upper, int lower, int[] colsum) {
        System.out.printf("upper=%d, lower=%d, colsum=%s:\n", upper, lower, Arrays.toString(colsum));
        Q2 q = new Q2();
        System.out.println(q.reconstructMatrix(upper, lower, colsum));
    }
}
