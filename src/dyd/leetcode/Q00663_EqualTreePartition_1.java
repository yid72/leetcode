package dyd.leetcode;

import dyd.leetcode.common.TreeNode;
import dyd.leetcode.common.TreeUtil;

import java.util.HashMap;
import java.util.Map;

public class Q00663_EqualTreePartition_1 {
    Map<TreeNode, Integer> subTreeValues = new HashMap<>();

    public boolean checkEqualTree(TreeNode root) {
        if (root == null) {
            return false;
        }

        subTreeValues.clear();
        computeSubTreeValues(root);

        int rootValues = subTreeValues.get(root);
        if (rootValues % 2 != 0) {
            return false;
        }
        subTreeValues.remove(root);
        return subTreeValues.values().contains(rootValues / 2);
    }

    private int computeSubTreeValues(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int val = root.val + computeSubTreeValues(root.left) + computeSubTreeValues(root.right);
        subTreeValues.put(root, val);
        return val;
    }

    public static void main(String[] args) {
        Q00663_EqualTreePartition_1 q = new Q00663_EqualTreePartition_1();

        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(10);
        root1.right = new TreeNode(10);
        root1.right.left = new TreeNode(2);
        root1.right.right = new TreeNode(3);
        TreeUtil.printTree(root1);
        System.out.println("Can be equally partitioned: " + q.checkEqualTree(root1));

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(10);
        root2.right.left = new TreeNode(2);
        root2.right.right = new TreeNode(20);
        TreeUtil.printTree(root2);
        System.out.println("Can be equally partitioned: " + q.checkEqualTree(root2));

        TreeNode root3 = new TreeNode(0);
        root3.left = new TreeNode(-1);
        root3.right = new TreeNode(1);
        TreeUtil.printTree(root3);
        System.out.println("Can be equally partitioned: " + q.checkEqualTree(root3));

        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(1);
        TreeUtil.printTree(root4);
        System.out.println("Can be equally partitioned: " + q.checkEqualTree(root4));

        TreeNode root5 = new TreeNode(1);
        root5.left = new TreeNode(-1);
        TreeUtil.printTree(root5);
        System.out.println("Can be equally partitioned: " + q.checkEqualTree(root5));

        TreeNode root6 = new TreeNode(1);
        root6.right = new TreeNode(2);
        root6.right.left = new TreeNode(2);
        TreeUtil.printTree(root6);
        System.out.println("Can be equally partitioned: " + q.checkEqualTree(root6));
    }
}