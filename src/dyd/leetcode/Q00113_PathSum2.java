package dyd.leetcode;

import dyd.leetcode.common.TreeNode;
import dyd.leetcode.common.TreeUtil;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 * Return:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class Q00113_PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> paths = new LinkedList<>();

        if (root == null) {
            return paths;
        }

        if (root.left == null && root.right == null && root.val == sum) {
            List<Integer> path = new LinkedList<>();
            path.add(root.val);
            paths.add(path);
            return paths;
        }

        if (root.left != null) {
            List<List<Integer>> leftChildPaths = pathSum(root.left, sum - root.val);
            leftChildPaths.forEach(p -> ((LinkedList) p).addFirst(root.val));
            paths.addAll(leftChildPaths);
        }

        if (root.right != null) {
            List<List<Integer>> rightChildPaths = pathSum(root.right, sum - root.val);
            rightChildPaths.forEach(p -> ((LinkedList) p).addFirst(root.val));
            paths.addAll(rightChildPaths);
        }

        return paths;
    }

    public static void main(String[] args) {
        test(null, 1)
        ;
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        test(root, 22);
        test(root, 21);

        root = new TreeNode(-2);
        root.right = new TreeNode(-3);
        test(root, -5);

    }

    private static void test(TreeNode root, int sum) {
        TreeUtil.printTree(root);

        Q00113_PathSum2 q = new Q00113_PathSum2();
        List<List<Integer>> paths = q.pathSum(root, sum);
        System.out.println("target=" + sum + ": " + paths);
    }
}
