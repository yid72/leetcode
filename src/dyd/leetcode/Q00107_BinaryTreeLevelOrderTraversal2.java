package dyd.leetcode;

import dyd.leetcode.common.PrintUtil;
import dyd.leetcode.common.TreeNode;
import dyd.leetcode.common.TreeUtil;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its bottom-up level order traversal as:
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
public class Q00107_BinaryTreeLevelOrderTraversal2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }

        Stack<List<Integer>> levelValueStack = new Stack<>();

        Queue<TreeNode> curLevel = new LinkedList<>();
        curLevel.add(root);

        while (curLevel.size() > 0) {
            List<Integer> curLevelValues = new LinkedList<>();
            Queue<TreeNode> nextLevel = new LinkedList<>();

            for (TreeNode curNode : curLevel) {
                curLevelValues.add(curNode.val);

                if (curNode.left != null) {
                    nextLevel.add(curNode.left);
                }

                if (curNode.right != null) {
                    nextLevel.add(curNode.right);
                }
            }

            levelValueStack.push(curLevelValues);

            curLevel = nextLevel;
        }

        List<List<Integer>> levelValues = new LinkedList<>();
        while (!levelValueStack.empty()) {
            levelValues.add(levelValueStack.pop());
        }
        return levelValues;
    }

    public static void main(String[] args) {
        Q00107_BinaryTreeLevelOrderTraversal2 q = new Q00107_BinaryTreeLevelOrderTraversal2();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        TreeUtil.printTree(root);

        System.out.println(q.levelOrderBottom(root));
    }
}
