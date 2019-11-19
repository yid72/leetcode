package dyd.leetcode;

import dyd.leetcode.common.TreeNode;
import dyd.leetcode.common.TreeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 257. Binary Tree Paths -- Easy
 *
 * Given a binary tree, return all root-to-leaf paths.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * Output: ["1->2->5", "1->3"]
 *
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */
public class Q00257_BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList();
        if (root == null) {
            return paths;
        }

        List<TreeNode> ancestors = new ArrayList();
        ancestors.add(root);
        binaryTreePaths(ancestors, paths);
        return paths;
    }

    private void binaryTreePaths(List<TreeNode> nodes, List<String> paths) {
        TreeNode node = nodes.get(nodes.size() - 1);
        if (node.left == null && node.right == null) {
            paths.add(createPath(nodes));
            return;
        }

        if (node.left != null) {
            nodes.add(node.left);
            binaryTreePaths(nodes, paths);
            nodes.remove(nodes.size() - 1);
        }

        if (node.right != null) {
            nodes.add(node.right);
            binaryTreePaths(nodes, paths);
            nodes.remove(nodes.size() - 1);
        }
    }

    private String createPath(List<TreeNode> nodes) {
        if (nodes.size() == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nodes.size() - 1; i++) {
            sb.append(nodes.get(i).val);
            sb.append("->");
        }
        sb.append(nodes.get(nodes.size() - 1).val);
        return sb.toString();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        test(root);
    }

    private static void test(TreeNode root) {
        TreeUtil.printTree(root);
        Q00257_BinaryTreePaths q = new Q00257_BinaryTreePaths();
        System.out.println(q.binaryTreePaths(root));
    }
}
