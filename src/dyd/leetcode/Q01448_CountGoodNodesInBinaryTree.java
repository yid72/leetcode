package dyd.leetcode;

import dyd.leetcode.common.TreeNode;
import dyd.leetcode.common.TreeUtil;

/**
 * 1448. Count Good Nodes in Binary Tree - Medium
 *
 * Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
 *
 * Return the number of good nodes in the binary tree.
 *
 *
 * Example 1:
 * Input: root = [3,1,4,3,null,1,5]
 * Output: 4
 * Explanation: Nodes in blue are good.
 * Root Node (3) is always a good node.
 * Node 4 -> (3,4) is the maximum value in the path starting from the root.
 * Node 5 -> (3,4,5) is the maximum value in the path
 * Node 3 -> (3,1,3) is the maximum value in the path.
 *
 * Example 2:
 * Input: root = [3,3,null,4,2]
 * Output: 3
 * Explanation: Node 2 -> (3, 3, 2) is not good, because "3" is higher than it.
 *
 * Example 3:
 * Input: root = [1]
 * Output: 1
 * Explanation: Root is considered as good.
 *
 * Constraints:
 *
 * The number of nodes in the binary tree is in the range [1, 10^5].
 * Each node's value is between [-10^4, 10^4].
 */
public class Q01448_CountGoodNodesInBinaryTree {
    public int goodNodes(TreeNode root) {
        return goodNodes(root, Integer.MIN_VALUE);
    }

    private int goodNodes(TreeNode node, int parentMax) {
        if (node == null) {
            return 0;
        }

        int good = 0;
        if (node.val >= parentMax) {
            good ++;
        }

        int curMax = Math.max(node.val, parentMax);
        good += goodNodes(node.left, curMax);
        good += goodNodes(node.right, curMax);
        return good;
    }

    public static void main(String[] args) {
        test(new Integer[] {3,1,4,3,null,1,5});
        test(new Integer[] {3,3,null,4,2});
        test(new Integer[] {1});
        test(new Integer[] {-1,5,-2,4,4,2,-2,null,null,-4,null,-2,3,null,-2,0,null,-1,null,-3,null,-4,-3,3,null,null,
                null,null,null,null,null,3,-3});
    }

    private static void test(Integer[] tree) {
        TreeNode root = TreeUtil.createBinaryTree(tree);
        TreeUtil.printTree(root);
        Q01448_CountGoodNodesInBinaryTree q = new Q01448_CountGoodNodesInBinaryTree();
        System.out.printf("Good nodes=%d\n", q.goodNodes(root));
    }
}
