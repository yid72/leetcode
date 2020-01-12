package dyd.leetcode;

import dyd.leetcode.common.TreeNode;
import dyd.leetcode.common.TreeUtil;

/**
 * 
ou need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.

The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.

Example 1:
Input: Binary tree: [1,2,3,4]
       1
     /   \
    2     3
   /    
  4     

Output: "1(2(4))(3)"

Explanation: Originally it needs to be "1(2(4)())(3()())", 
but you need to omit all the unnecessary empty parenthesis pairs. 
And it will be "1(2(4))(3)".
Example 2:
Input: Binary tree: [1,2,3,null,4]
       1
     /   \
    2     3
     \  
      4 

Output: "1(2()(4))(3)"

Explanation: Almost the same as the first example, 
except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.
 
 * @author dyd
 *
 */
public class Q00606_StringFromBT {
    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        tree2Str(t, sb);
        return sb.toString();
    }
    
    private void tree2Str(TreeNode t, StringBuilder sb) {
    	if (t == null) {
    		return;
    	}

    	sb.append(t.val);
    		
    	if (t.left != null || t.right != null) {
    		sb.append('(');
    		tree2Str(t.left, sb);
    		sb.append(')');
    	
    		if (t.right != null) {
    			sb.append('(');
    			tree2Str(t.right, sb);
    			sb.append(')');
    		}
    	}
    }
    
    public static void main(String[] args) {
    	test(new Integer[] {1, 2, 3, 4});
    	test(new Integer[] {1, 2, 3, null, 4});
    }
    
    private static void test(Integer[] vals) {
    	Q00606_StringFromBT q = new Q00606_StringFromBT();
    	TreeNode root = TreeUtil.createBinaryTree(vals);
    	System.out.println(q.tree2str(root));
    }
}
