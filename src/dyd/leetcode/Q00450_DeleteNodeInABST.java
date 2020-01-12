package dyd.leetcode;

import dyd.leetcode.common.TreeNode;
import dyd.leetcode.common.TreeUtil;

/**
 * 450. Delete Node in a BST -- Medium
 *
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node
 * reference (possibly updated) of the BST.
 *
 * Basically, the deletion can be divided into two stages:
 *
 * Search for a node to remove.
 * If the node is found, delete the node.
 * Note: Time complexity should be O(height of tree).
 *
 * Example:
 *
 * root = [5,3,6,2,4,null,7]
 * key = 3
 *
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Given key to delete is 3. So we find the node with value 3 and delete it.
 *
 * One valid answer is [5,4,6,2,null,null,7], shown in the following BST.
 *
 *     5
 *    / \
 *   4   6
 *  /     \
 * 2       7
 *
 * Another valid answer is [5,2,6,null,4,null,7].
 *
 *     5
 *    / \
 *   2   6
 *    \   \
 *     4   7
 */
public class Q00450_DeleteNodeInABST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.right != null) {
                root.val = successor(root).val;
                root.right = deleteNode(root.right, root.val);
            } else {
                root.val = predecessor(root).val;
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }

    private TreeNode successor(TreeNode node) {
        node = node.right;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private TreeNode predecessor(TreeNode node) {
        node = node.left;
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    public static void main(String[] args) {
        Integer[] root = new Integer[] {5,3,6,2,4,null,7};
        test(root, 4);
        test(root, 2);
        test(root, 6);
        test(root, 3);
    }

    private static void test(Integer[] rootArr, int key) {
        TreeNode root = TreeUtil.createBinaryTree(rootArr);
        System.out.println("Key=" + key);
        TreeUtil.printTree(root);
        Q00450_DeleteNodeInABST q = new Q00450_DeleteNodeInABST();
        q.deleteNode(root, key);
        System.out.println();
        TreeUtil.printTree(root);
        System.out.println();
    }
}
