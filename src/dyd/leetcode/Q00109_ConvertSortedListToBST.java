package dyd.leetcode;

import dyd.leetcode.common.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of
 * every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted linked list: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class Q00109_ConvertSortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> vals = new ArrayList();
        ListNode node = head;
        while (node != null) {
            vals.add(node.val);
            node = node.next;
        }

        return buildBST(vals, 0, vals.size() - 1);
    }

    private TreeNode buildBST(List<Integer> vals, int lo, int hi) {
        if (lo > hi) {
            return null;
        }

        int mid = (lo + hi) / 2;
        TreeNode node = new TreeNode(vals.get(mid));
        node.left = buildBST(vals, lo, mid - 1);
        node.right = buildBST(vals, mid + 1, hi);
        return node;
    }

    public static void main(String[] args) {
        test(new int[] {-10,-3,0,5,9});
    }

    private static void test(int[] vals) {
        ListNode head = ListUtil.createList(vals);
        ListUtil.printList(head);

        Q00109_ConvertSortedListToBST q = new Q00109_ConvertSortedListToBST();
        TreeNode root = q.sortedListToBST(head);
        TreeUtil.printTree(root);
    }
}
