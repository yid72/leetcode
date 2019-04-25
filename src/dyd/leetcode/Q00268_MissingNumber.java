package dyd.leetcode;

public class Q00268_MissingNumber {
    public int missingNumber(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        return nums.length * (nums.length + 1)/2 - sum;
    }

    public static void main(String[] args) {
        Q00268_MissingNumber q = new Q00268_MissingNumber();
        System.out.println(q.missingNumber(new int[] {3, 0, 1}));
        System.out.println(q.missingNumber(new int[] {9,6,4,2,3,5,7,0,1}));
    }
}
