package dyd.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 341. Flatten Nested List Iterator -- Medium
 *
 * Given a nested list of integers, implement an iterator to flatten it.
 *
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 *
 * Example 1:
 *
 * Input: [[1,1],2,[1,1]]
 * Output: [1,1,2,1,1]
 * Explanation: By calling next repeatedly until hasNext returns false,
 *              the order of elements returned by next should be: [1,1,2,1,1].
 * Example 2:
 *
 * Input: [1,[4,[6]]]
 * Output: [1,4,6]
 * Explanation: By calling next repeatedly until hasNext returns false,
 *              the order of elements returned by next should be: [1,4,6].
 */
public class Q00341_FlattenNestedListIterator implements Iterator<Integer> {
    class NestedInteger {
        boolean isInteger;
        Integer val;
        private List<NestedInteger> list;

        public NestedInteger(Integer val) {
            this.isInteger = true;
            this.val = val;
        }

        public NestedInteger(List<NestedInteger> list) {
            this.isInteger = false;
            this.list = list;
        }

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger() {
            return isInteger;
        }

         // @return the single integer that this NestedInteger holds, if it holds a single integer
         // Return null if this NestedInteger holds a nested list
         public Integer getInteger() {
            return val;
         }

         // @return the nested list that this NestedInteger holds, if it holds a nested list
         // Return null if this NestedInteger holds a single integer
         public List<NestedInteger> getList() {
            return list;
         }
    }

    private Iterator<Integer> iter;

    public Q00341_FlattenNestedListIterator(List<NestedInteger> nestedList) {
        List<Integer> flattenNumbers = new ArrayList<>();
        for (NestedInteger num : nestedList) {
            addNumbers(num, flattenNumbers);
        }
        iter = flattenNumbers.iterator();
    }

    private void addNumbers(NestedInteger nestedInteger, List<Integer> flattenList) {
        if (nestedInteger.isInteger()) {
            flattenList.add(nestedInteger.getInteger());
            return;
        }

        for (NestedInteger num : nestedInteger.getList()) {
            addNumbers(num, flattenList);
        }
    }

    @Override
    public Integer next() {
        return iter.next();
    }

    @Override
    public boolean hasNext() {
        return iter.hasNext();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */