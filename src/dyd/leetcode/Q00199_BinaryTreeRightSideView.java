package dyd.leetcode;

import dyd.leetcode.common.TreeNode;
import dyd.leetcode.common.TreeUtil;

import java.util.*;

/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see
 * ordered from top to bottom.
 *
 * Example:
 *
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 */
public class Q00199_BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> view = new ArrayList<>();
        if (root == null) {
            return view;
        }

        Queue<TreeNode> curLevel = new LinkedList<>();
        curLevel.add(root);
        while (!curLevel.isEmpty()) {
            TreeNode curNode = null;
            Queue<TreeNode> nextLevel = new LinkedList<>();
            while (!curLevel.isEmpty()) {
                curNode = curLevel.remove();
                if (curNode.left != null) {
                    nextLevel.add(curNode.left);
                }
                if (curNode.right != null) {
                    nextLevel.add(curNode.right);
                }
            }
            if (curNode != null) {
                view.add(curNode.val);
            }
            curLevel = nextLevel;
        }

        return view;
    }

    public static void main(String[] args) {
        Q00199_BinaryTreeRightSideView q = new Q00199_BinaryTreeRightSideView();

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.right = new TreeNode(5);
        root1.right.right = new TreeNode(4);
        TreeUtil.printTree(root1);
        System.out.println(q.rightSideView(root1));

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(5);
        TreeUtil.printTree(root2);
        System.out.println(q.rightSideView(root2));
    }
}
