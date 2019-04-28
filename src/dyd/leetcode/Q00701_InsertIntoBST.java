package dyd.leetcode;

import dyd.leetcode.common.TreeNode;

public class Q00701_InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = root;
        insert(node, val);
        return root;
    }

    private void insert(TreeNode node, int val) {
        if (node.val > val) {
            if (node.left != null) {
                insert(node.left, val);
            } else {
                TreeNode newNode = new TreeNode(val);
                node.left = newNode;
            }
        } else {
            if (node.right != null) {
                insert(node.right, val);
            } else {
                TreeNode newNode = new TreeNode(val);
                node.right = newNode;
            }
        }
    }

    public static void main(String[] args) {
        Q00701_InsertIntoBST q = new Q00701_InsertIntoBST();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        TreeNode newRoot = q.insertIntoBST(root, 5);
        System.out.println(1);
    }
}
