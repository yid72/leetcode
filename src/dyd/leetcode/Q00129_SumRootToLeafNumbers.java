package dyd.leetcode;

import dyd.leetcode.common.TreeNode;
import dyd.leetcode.common.TreeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 129. Sum Root to Leaf Numbers -- Medium
 *
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 *
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 *
 * Find the total sum of all root-to-leaf numbers.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input: [1,2,3]
 *     1
 *    / \
 *   2   3
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 * Example 2:
 *
 * Input: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 */
public class Q00129_SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        List<Integer> numbers = new ArrayList<>();
        collectNumbers(root, "", numbers);

        int sum = 0;
        for (Integer num : numbers) {
            sum += num;
        }
        return sum;
    }

    private void collectNumbers(TreeNode node, String prefix, List<Integer> numbers) {
        if (node.left == null && node.right == null) {
            numbers.add(Integer.parseInt(prefix + node.val));
            return;
        }

        if (node.left != null) {
            collectNumbers(node.left, prefix + node.val, numbers);
        }

        if (node.right != null) {
            collectNumbers(node.right, prefix + node.val, numbers);
        }
    }

    public static void main(String[] args) {
        test(new Integer[] {1,2,3});
        test(new Integer[] {4,9,0,5,1});
    }

    private static void test(Integer[] tree) {
        TreeNode root = TreeUtil.createBinaryTree(tree);
        TreeUtil.printTree(root);
        Q00129_SumRootToLeafNumbers q = new Q00129_SumRootToLeafNumbers();
        System.out.printf("sum = %d\n", q.sumNumbers(root));
    }
}
