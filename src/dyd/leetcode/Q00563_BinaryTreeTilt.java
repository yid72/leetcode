package dyd.leetcode;

import dyd.leetcode.common.PrintUtil;
import dyd.leetcode.common.TreeNode;
import jdk.nashorn.api.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a binary tree, return the tilt of the whole tree.
 *
 * The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values. Null node has tilt 0.
 *
 * The tilt of the whole tree is defined as the sum of all nodes' tilt.
 *
 * Example:
 * Input:
 *          1
 *        /   \
 *       2     3
 * Output: 1
 * Explanation:
 * Tilt of node 2 : 0
 * Tilt of node 3 : 0
 * Tilt of node 1 : |2-3| = 1
 * Tilt of binary tree : 0 + 0 + 1 = 1
 */
public class Q00563_BinaryTreeTilt {
    class Result {
        int totalTilt;
        int totalValues;
    }

    public int findTilt(TreeNode root) {
        Result result = internalFindTilt(root);
        return result.totalTilt;
    }

    private Result internalFindTilt(TreeNode node) {
        Result result = new Result();
        if (node == null) {
            return result;
        }

        Result leftResult = internalFindTilt(node.left);
        Result rightResult = internalFindTilt(node.right);
        int tilt = Math.abs(leftResult.totalValues - rightResult.totalValues);
        result.totalTilt = tilt + leftResult.totalTilt + rightResult.totalTilt;
        result.totalValues = node.val + leftResult.totalValues + rightResult.totalValues;
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        Q00563_BinaryTreeTilt q = new Q00563_BinaryTreeTilt();
        System.out.println("tilt: " + q.findTilt(root));
    }
}
