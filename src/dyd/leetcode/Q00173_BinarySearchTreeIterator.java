package dyd.leetcode;

import dyd.leetcode.common.TreeNode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Q00173_BinarySearchTreeIterator {
    Iterator<TreeNode> iterator;

    public Q00173_BinarySearchTreeIterator(TreeNode root) {
        List<TreeNode> flatBst = new LinkedList<>();
        inorder(root, flatBst);
        iterator = flatBst.iterator();
    }

    private void inorder(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }

        inorder(node.left, list);
        list.add(node);
        inorder(node.right, list);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return iterator.hasNext();
    }

    /** @return the next smallest number */
    public int next() {
        return iterator.next().val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        Q00173_BinarySearchTreeIterator iterator = new Q00173_BinarySearchTreeIterator(root);
        System.out.println(iterator.next());    // return 3
        System.out.println(iterator.next());    // return 7
        System.out.println(iterator.hasNext()); // return true
        System.out.println(iterator.next());    // return 9
        System.out.println(iterator.hasNext()); // return true
        System.out.println(iterator.next());    // return 15
        System.out.println(iterator.hasNext()); // return true
        System.out.println(iterator.next());    // return 20
        System.out.println(iterator.hasNext()); // return false
    }
}
