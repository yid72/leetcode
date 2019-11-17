package dyd.leetcode;

import dyd.leetcode.common.TreeNode;
import dyd.leetcode.common.TreeUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * 5264. Find Elements in a Contaminated Binary Tree -- Medium
 *
 * Given a binary tree with the following rules:
 *
 * root.val == 0
 * If treeNode.val == x and treeNode.left != null, then treeNode.left.val == 2 * x + 1
 * If treeNode.val == x and treeNode.right != null, then treeNode.right.val == 2 * x + 2
 * Now the binary tree is contaminated, which means all treeNode.val have been changed to -1.
 *
 * You need to first recover the binary tree and then implement the FindElements class:
 *
 * FindElements(TreeNode* root) Initializes the object with a contamined binary tree, you need to recover it first.
 * bool find(int target) Return if the target value exists in the recovered binary tree.
 *
 *
 * Example 1:
 *
 *
 *
 * Input
 * ["FindElements","find","find"]
 * [[[-1,null,-1]],[1],[2]]
 * Output
 * [null,false,true]
 * Explanation
 * FindElements findElements = new FindElements([-1,null,-1]);
 * findElements.find(1); // return False
 * findElements.find(2); // return True
 * Example 2:
 *
 *
 *
 * Input
 * ["FindElements","find","find","find"]
 * [[[-1,-1,-1,-1,-1]],[1],[3],[5]]
 * Output
 * [null,true,true,false]
 * Explanation
 * FindElements findElements = new FindElements([-1,-1,-1,-1,-1]);
 * findElements.find(1); // return True
 * findElements.find(3); // return True
 * findElements.find(5); // return False
 * Example 3:
 *
 *
 *
 * Input
 * ["FindElements","find","find","find","find"]
 * [[[-1,null,-1,-1,null,-1]],[2],[3],[4],[5]]
 * Output
 * [null,true,false,false,true]
 * Explanation
 * FindElements findElements = new FindElements([-1,null,-1,-1,null,-1]);
 * findElements.find(2); // return True
 * findElements.find(3); // return False
 * findElements.find(4); // return False
 * findElements.find(5); // return True
 *
 *
 * Constraints:
 *
 * TreeNode.val == -1
 * The height of the binary tree is less than or equal to 20
 * The total number of nodes is between [1, 10^4]
 * Total calls of find() is between [1, 10^4]
 * 0 <= target <= 10^6
 */
public class Q05264_FindElementsInAContaminatedBinaryTree {
    private Set<Integer> vals = new HashSet();

    public Q05264_FindElementsInAContaminatedBinaryTree(TreeNode root) {
        if (root == null) {
            return;
        }

        root.val = 0;
        vals.add(root.val);
        recover(root);
    }

    public boolean find(int target) {
        return vals.contains(target);
    }

    private void recover(TreeNode node) {
        if (node.left != null) {
            node.left.val = 2*node.val + 1;
            vals.add(node.left.val);
            recover(node.left);
        }

        if (node.right != null) {
            node.right.val = 2*node.val + 2;
            vals.add(node.right.val);
            recover(node.right);
        }
    }

    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        TreeNode root = new TreeNode(-1);
        root.right = new TreeNode(-1);
        test(root, new int[] {1, 2});
    }

    private static void test2() {
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(-1);
        root.right = new TreeNode(-1);
        root.left.left = new TreeNode(-1);
        root.left.right = new TreeNode(-1);
        test(root, new int[] {1, 3, 5});
    }

    private static void test(TreeNode root, int[] targets) {
        TreeUtil.printTree(root);
        Q05264_FindElementsInAContaminatedBinaryTree q = new Q05264_FindElementsInAContaminatedBinaryTree(root);
        TreeUtil.printTree(root);

        for (int target : targets) {
            System.out.println("Find target " + target + ": " + q.find(target));
        }
    }
}
