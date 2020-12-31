package dyd.leetcode;

import dyd.leetcode.common.TreeNode;
import dyd.leetcode.common.TreeUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1457. Pseudo-Palindromic Paths in a Binary Tree -- Medium
 *
 * Given a binary tree where node values are digits from 1 to 9. A path in the binary tree is said to be pseudo-palindromic if at least one permutation of the node values in the path is a palindrome.
 *
 * Return the number of pseudo-palindromic paths going from the root node to leaf nodes.
 *
 * Example 1:
 * Input: root = [2,3,1,3,1,null,1]
 * Output: 2
 * Explanation: The figure above represents the given binary tree. There are three paths going from the root node to leaf nodes: the red path [2,3,3], the green path [2,1,1], and the path [2,3,1]. Among these paths only red path and green path are pseudo-palindromic paths since the red path [2,3,3] can be rearranged in [3,2,3] (palindrome) and the green path [2,1,1] can be rearranged in [1,2,1] (palindrome).
 *
 * Example 2:
 * Input: root = [2,1,1,1,3,null,null,null,null,null,1]
 * Output: 1
 * Explanation: The figure above represents the given binary tree. There are three paths going from the root node to leaf nodes: the green path [2,1,1], the path [2,1,3,1], and the path [2,1]. Among these paths only the green path is pseudo-palindromic since [2,1,1] can be rearranged in [1,2,1] (palindrome).
 *
 * Example 3:
 * Input: root = [9]
 * Output: 1
 */
public class Q01457_PseudoPalindromicPathsInABinaryTree {

    private int res = 0;

    public int pseudoPalindromicPaths (TreeNode root) {
        if (root == null) {
            return 0;
        }

        inorder(root, new HashMap<Integer, Integer>(), 0);
        return res;
    }

    private void inorder(TreeNode node, Map<Integer, Integer> counts, int oddCount) {
        int count = counts.getOrDefault(node.val, 0);
        if (count % 2 == 0) {
            oddCount ++;
        } else {
            oddCount --;
        }

        if (node.left == null && node.right == null) {
            if (oddCount <= 1) {
                res ++;
            }
            return;
        }

        counts.put(node.val, count + 1);

        if (node.left != null) {
            inorder(node.left, counts, oddCount);
        }

        if (node.right != null) {
            inorder(node.right, counts, oddCount);
        }

        counts.put(node.val, count);
    }

    public static void main(String[] args) {
        test(new Integer[] {2,3,1,3,1,null,1}); // answer: 2
        test(new Integer[] {2,1,1,1,3,null,null,null,null,null,1}); // answer: 1
    }

    private static void test(Integer[] tree) {
        System.out.println(Arrays.deepToString(tree));
        TreeNode root = TreeUtil.createBinaryTree(tree);

        Q01457_PseudoPalindromicPathsInABinaryTree q = new Q01457_PseudoPalindromicPathsInABinaryTree();
        System.out.println("Result=" + q.pseudoPalindromicPaths(root));
    }
}
