package dyd.leetcode;

import dyd.leetcode.common.PrintUtil;

import java.util.Stack;

public class Q00739_M_2 {
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.empty() && T[i] >= T[stack.peek()]) {
                stack.pop();
            }
            if (!stack.empty()) {
                ans[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Q00739_M_2 q = new Q00739_M_2();
        int[] T = new int[] {73, 74, 75, 71, 69, 72, 76, 73};
        PrintUtil.printArray("T", T);
        PrintUtil.printArray("Warmer temperatures", q.dailyTemperatures(T));

        int[] T1 = new int[] {89,62,70,58,47,47,46,76,100,70};
        PrintUtil.printArray("T1", T1);
        PrintUtil.printArray("Warmer temperatures", q.dailyTemperatures(T1));
    }

}
