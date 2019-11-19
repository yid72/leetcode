package dyd.leetcode;

import dyd.leetcode.common.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 559. Maximum Depth of N-ary Tree -- Easy
 *
 * Given a n-ary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: 3
 * Example 2:
 *
 *
 *
 * Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: 5
 *
 *
 * Constraints:
 *
 * The depth of the n-ary tree is less than or equal to 1000.
 * The total number of nodes is between [0, 10^4].
 */
public class Q00559_MaximumDepthOfNaryTree {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        int max = 0;
        if (root.children != null) {
            for (Node child : root.children) {
                max = Math.max(max, maxDepth(child));
            }
        }
        return max + 1;
    }

    public static void main(String[] args) {
        List<Node> children1 = new ArrayList<>();
        Node child11 = new Node();
        child11.val = 5;
        children1.add(child11);

        Node child12 = new Node();
        child12.val = 6;
        children1.add(child12);

        List<Node> children = new ArrayList<>();
        Node child1 = new Node();
        child1.val = 3;
        child1.children = children1;
        children.add(child1);

        Node child2 = new Node();
        child2.val = 2;
        children.add(child2);

        Node child3 = new Node();
        child3.val = 4;
        children.add(child3);

        Node root = new Node();
        root.val = 1;
        root.children = children;

        Q00559_MaximumDepthOfNaryTree q = new Q00559_MaximumDepthOfNaryTree();
        System.out.println(q.maxDepth(root));
    }
}
