package dyd.leetcode;

import dyd.leetcode.common.PrintUtil;
import dyd.leetcode.common.TreeNode;
import dyd.leetcode.common.TreeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,3,2]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class Q00094_BinaryTreeInOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if (root == null) {
            return results;
        }

        Stack<TreeNode> stack = new Stack<>();

        pushAllLeftChildren(stack, root);

        while (!stack.empty()) {
            TreeNode node = stack.pop();
            results.add(node.val);
            if (node.right != null) {
                pushAllLeftChildren(stack, node.right);
            }
        }

        return results;
    }

    private void pushAllLeftChildren(Stack<TreeNode> stack, TreeNode node) {
        TreeNode curNode = node;
        while (curNode != null) {
            stack.push(curNode);
            curNode = curNode.left;
        }
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(2);
        root1.right.left = new TreeNode(3);
        test(root1);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        test(root2);
    }
    private static void test(TreeNode root) {
        TreeUtil.printTree(root);

        Q00094_BinaryTreeInOrderTraversal q = new Q00094_BinaryTreeInOrderTraversal();
        System.out.println(q.inorderTraversal(root));
    }
}
