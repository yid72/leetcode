package dyd.leetcode;

import dyd.leetcode.common.TreeNode;
import dyd.leetcode.common.TreeUtil;

import java.util.*;

/**
 * 1110. Delete Nodes And Return Forest -- Medium
 *
 * Given the root of a binary tree, each node in the tree has a distinct value.
 *
 * After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).
 *
 * Return the roots of the trees in the remaining forest.  You may return the result in any order.
 *
 * Example 1:
 *
 * Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
 * Output: [[1,2,null,4],[6],[7]]
 *
 *
 * Constraints:
 *
 * The number of nodes in the given tree is at most 1000.
 * Each node has a distinct value between 1 and 1000.
 * to_delete.length <= 1000
 * to_delete contains distinct values between 1 and 1000.
 */
public class Q01110_DeleteNodesAndReturnForest {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root == null) {
            return new ArrayList<>();
        }

        Set<Integer> toDelete = new HashSet<>();
        for (int i : to_delete) {
            toDelete.add(i);
        }

        Set<TreeNode> roots = new HashSet<>();
        if (!toDelete.contains(root.val)) {
            roots.add(root);
        }
        deleteNodes(root, toDelete, roots);
        return new ArrayList<TreeNode>(roots);
    }

    private TreeNode deleteNodes(TreeNode node, Set<Integer> toDelete, Set<TreeNode> roots) {
        if (node == null) {
            return null;
        }

        TreeNode ret = node;

        if (toDelete.contains(node.val)) {
            toDelete.remove(node.val);

            if (roots.contains(node)) {
                roots.remove(node);
            }

            if (node.left != null) {
                roots.add(node.left);
            }

            if (node.right != null) {
                roots.add(node.right);
            }

            ret = null;
        }

        node.left = deleteNodes(node.left, toDelete, roots);
        node.right = deleteNodes(node.right, toDelete, roots);
        return ret;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        test(root, new int[] {3,5});
    }

    private static void test(TreeNode root, int[] to_delete) {
        TreeUtil.printTree(root);
        System.out.printf("to_delete=%s\n", Arrays.toString(to_delete));
        Q01110_DeleteNodesAndReturnForest q = new Q01110_DeleteNodesAndReturnForest();
        List<TreeNode> retNodes = q.delNodes(root, to_delete);
        for (TreeNode retNode : retNodes) {
            TreeUtil.printTree(retNode);
        }
    }
}
