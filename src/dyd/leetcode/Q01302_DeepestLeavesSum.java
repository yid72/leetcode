package dyd.leetcode;

import dyd.leetcode.common.TreeNode;
import dyd.leetcode.common.TreeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 1302. Deepest Leaves Sum -- Medium
 *
 * Given a binary tree, return the sum of values of its deepest leaves.
 *
 * Example 1:
 *
 * Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * Output: 15
 *
 * Constraints:
 *
 * The number of nodes in the tree is between 1 and 10^4.
 * The value of nodes is between 1 and 100.
 */
public class Q01302_DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int curLevelSum = 0;
        List<TreeNode> currentLevel = new ArrayList<>();
        currentLevel.add(root);
        while (currentLevel.size() > 0) {
            List<TreeNode> nextLevel = new ArrayList<>();

            curLevelSum = 0;
            for (TreeNode node : currentLevel) {
                curLevelSum += node.val;

                if (node.left != null) {
                    nextLevel.add(node.left);
                }

                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }

            currentLevel = nextLevel;
        }

        return curLevelSum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(7);
        root.right.right.right = new TreeNode(8);
        test(root);
    }

    private static void test(TreeNode root) {
        TreeUtil.printTree(root);

        Q01302_DeepestLeavesSum q = new Q01302_DeepestLeavesSum();
        System.out.printf("deepest leaves sum=%d", q.deepestLeavesSum(root));
    }
}
