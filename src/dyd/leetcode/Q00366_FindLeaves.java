package dyd.leetcode;

import dyd.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q00366_FindLeaves {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> allLeaves = new ArrayList<>();
        if (root == null) {
            return allLeaves;
        }

        while (root.left != null || root.right != null) {
            List<Integer> leaves = new ArrayList<>();
            removeLeaves(root, leaves);
            allLeaves.add(leaves);
        }

        List<Integer> leaves = new ArrayList<>();
        leaves.add(root.val);
        allLeaves.add(leaves);

        return allLeaves;
    }

    private void removeLeaves(TreeNode node, List<Integer> leaves) {
        if (node.left != null) {
            if (isLeaf(node.left)) {
                leaves.add(node.left.val);
                node.left = null;
            } else {
                removeLeaves(node.left, leaves);
            }
        }

        if (node.right != null) {
            if (isLeaf(node.right)) {
                leaves.add(node.right.val);
                node.right = null;
            } else {
                removeLeaves(node.right, leaves);
            }
        }
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public static void main(String[] args) {
        Q00366_FindLeaves q = new Q00366_FindLeaves();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        List<List<Integer>> leaves = q.findLeaves(root);
        for (List<Integer> l1 : leaves) {
            for (Integer l2 : l1) {
                System.out.print(l2 + " ");
            }
            System.out.println();
        }
    }
}
