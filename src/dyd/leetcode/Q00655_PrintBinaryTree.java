package dyd.leetcode;

import dyd.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Print a binary tree in an m*n 2D string array following these rules:
 *
 * The row number m should be equal to the height of the given binary tree.
 * The column number n should always be an odd number.
 * The root node's value (in string format) should be put in the exactly middle of the first row it can be put.
 * The column and the row where the root node belongs will separate the rest space into two parts (left-bottom part and right-bottom part). You should print the left subtree in the left-bottom part and print the right subtree in the right-bottom part. The left-bottom part and the right-bottom part should have the same size. Even if one subtree is none while the other is not, you don't need to print anything for the none subtree but still need to leave the space as large as that for the other subtree. However, if two subtrees are none, then you don't need to leave space for both of them.
 * Each unused space should contain an empty string "".
 * Print the subtrees following the same rules.
 * Example 1:
 * Input:
 *      1
 *     /
 *    2
 * Output:
 * [["", "1", ""],
 *  ["2", "", ""]]
 * Example 2:
 * Input:
 *      1
 *     / \
 *    2   3
 *     \
 *      4
 * Output:
 * [["", "", "", "1", "", "", ""],
 *  ["", "2", "", "", "", "3", ""],
 *  ["", "", "4", "", "", "", ""]]
 * Example 3:
 * Input:
 *       1
 *      / \
 *     2   5
 *    /
 *   3
 *  /
 * 4
 * Output:
 *
 * [["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
 *  ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
 *  ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
 *  ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
 * Note: The height of binary tree is in the range of [1, 10].
 */
public class Q00655_PrintBinaryTree {
    private List<List<String>> result;

    public List<List<String>> printTree(TreeNode root) {
        result = new ArrayList<>();
        int h = height(root);
        int maxColumns = (int) Math.pow(2, h) - 1;
        for (int i = 0; i < h; i++) {
            String[] row = new String[maxColumns];
            Arrays.fill(row, "");
            result.add(Arrays.asList(row));
        }

        printTree(root, 0, 0, maxColumns - 1);
        return result;
    }

    private void printTree(TreeNode node, int rowNo, int colStart, int colEnd) {
        if (node == null) {
            return;
        }

        int pos = (colEnd + colStart) / 2;
        result.get(rowNo).set(pos, Integer.toString(node.val));
        printTree(node.left, rowNo + 1, colStart, pos - 1);
        printTree(node.right, rowNo + 1, pos + 1, colEnd);
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    public static void main(String[] args) {
        System.out.println("Test 1");
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        test(root);

        System.out.println("Test 2");
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.right.right = new TreeNode(5);
        test(root1);
    }

    private static void test(TreeNode root) {
        Q00655_PrintBinaryTree q = new Q00655_PrintBinaryTree();
        List<List<String>> result = q.printTree(root);
        for (List<String> row : result) {
            System.out.println(row);
        }
    }
}
