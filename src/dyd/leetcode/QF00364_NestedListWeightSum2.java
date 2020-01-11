package dyd.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 364. Nested List Weight Sum II -- Medium
 * 
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
 *
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 *
 * Different from the previous question where weight is increasing from root to leaf, now the weight is defined from bottom up. i.e., the leaf level integers have weight 1, and the root level integers have the largest weight.
 *
 * Example 1:
 *
 * Input: [[1,1],2,[1,1]]
 * Output: 8 
 * Explanation: Four 1's at depth 1, one 2 at depth 2.
 * Example 2:
 *
 * Input: [1,[4,[6]]]
 * Output: 17 
 * Explanation: One 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17.
 */

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

public class QF00364_NestedListWeightSum2 {
    public interface NestedInteger {
         // @return true if this NestedInteger holds a single integer, rather than a nested list.
         public boolean isInteger();

         // @return the single integer that this NestedInteger holds, if it holds a single integer
         // Return null if this NestedInteger holds a nested list
         public Integer getInteger();

         // Set this NestedInteger to hold a single integer.
         public void setInteger(int value);

         // Set this NestedInteger to hold a nested list and adds a nested integer to it.
         public void add(NestedInteger ni);

         // @return the nested list that this NestedInteger holds, if it holds a nested list
         // Return null if this NestedInteger holds a single integer
         public List<NestedInteger> getList();
    }

    public int depthSumInverse(List<NestedInteger> nestedList) {
        Map<Integer, Integer> ret = new HashMap<>();
        for (NestedInteger num : nestedList) {
            helper(num, 0, ret);
        }

        int maxLevel = 0;
        for (Map.Entry<Integer, Integer> entry :  ret.entrySet()) {
            maxLevel = Math.max(maxLevel, entry.getKey() + 1);
        }

        int sum = 0;
        for (Map.Entry<Integer, Integer> entry :  ret.entrySet()) {
            sum += (maxLevel - entry.getKey()) * entry.getValue();
        }
        return sum;
    }

    private void helper(NestedInteger num, int level, Map<Integer, Integer> ret) {
        if (num.isInteger()) {
            ret.putIfAbsent(level, 0);
            ret.put(level, ret.get(level) + num.getInteger());
        } else {
            for (NestedInteger nested : num.getList()) {
                helper(nested, level + 1, ret);
            }
        }
    }
}
