package dyd.leetcode;

/**
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of
 * your product fails the quality check. Since each version is developed based on the previous version, all the versions
 * after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following
 * ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to
 * find the first bad version. You should minimize the number of calls to the API.
 *
 * Example:
 *
 * Given n = 5, and version = 4 is the first bad version.
 *
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 *
 * Then 4 is the first bad version.
 */
public class Q00278_FirstBadVersion {
    private static int firstBadVersion;

    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (isBadVersion(mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean isBadVersion(int n) {
        return n >= firstBadVersion;
    }

    public static void main(String[] args) {
        test(5, 5);
        test(8, 5);
        test(3, 5);
        test(2126753390, 1702766719);
    }

    private static void test(int n, int firstBadVersion) {
        Q00278_FirstBadVersion.firstBadVersion = firstBadVersion;
        Q00278_FirstBadVersion q = new Q00278_FirstBadVersion();
        System.out.println("n=" + n +", first bad version=" + q.firstBadVersion(n));
    }

}
