package dyd.leetcode;

/**
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 *
 * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 *
 * Rectangle Area
 *
 * Example:
 *
 * Input: A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2
 * Output: 45
 */
public class Q00223_RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        if (A > E) {
            int t1 = A;
            int t2 = B;
            int t3 = C;
            int t4 = D;
            A = E;
            B = F;
            C = G;
            D = H;
            E = t1;
            F = t2;
            G = t3;
            H = t4;
        }

        int overlapArea;
        if (E >= C || F >= D || H <= B) {
            overlapArea = 0;
        } else {
            int top = Math.min(D, H);
            int bottom = Math.max(B, F);
            int left = Math.max(A, E);
            int right = Math.min(C, G);
            overlapArea = (right - left) * (top - bottom);
        }

        return (C - A) * (D - B) + (G - E) * (H - F) - overlapArea;
    }

    public static void main(String[] args) {
//        test(-3, 0, 3, 4, 0, -1, 9, 2);
        test(-2, -2 ,2, 2, 3, 3, 4, 4);
    }

    private static void test(int A, int B, int C, int D, int E, int F, int G, int H) {
        Q00223_RectangleArea q = new Q00223_RectangleArea();
        System.out.printf(
                "(%d, %d), (%d, %d), (%d, %d), (%d, %d): %d\n",
                A, B, C, D, E, F, G, H,
                q.computeArea(A, B, C, D, E, F, G, H));
    }
}
