package dyd.leetcode;

import dyd.leetcode.common.TreeNode;
import dyd.leetcode.common.TreeUtil;

public class Q00938_RangeSumOfBST {
    private int sum = 0;

    public int rangeSumBST(TreeNode root, int L, int R) {
        traverse(root, L, R);
        return sum;
    }

    private void traverse(TreeNode node, int L, int R) {
        if (node == null) {
            return;
        }

        if (node.val >= L && node.val <= R) {
            sum += node.val;
            traverse(node.left, L, R);
            traverse(node.right, L, R);
        } else if (node.val <= L) {
            traverse(node.right, L, R);
        } else if (node.val >= R) {
            traverse(node.left, L, R);
        }
    }

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);
        test(root, 7, 15);
    }

    private static void test(TreeNode root, int L, int R) {
        Q00938_RangeSumOfBST q = new Q00938_RangeSumOfBST();
        TreeUtil.printTree(root);
        System.out.printf("L=%d, R=%d: %d\n", L, R, q.rangeSumBST(root, L, R));
    }
}
