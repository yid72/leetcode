package dyd.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Q00657_Robot_Return_to_Origin {
    public boolean judgeCircle(String moves) {
        int hPos = 0;
        int vPos = 0;
        for (char ch : moves.toCharArray()) {
            switch (ch) {
                case 'L':
                    hPos --;
                    break;

                case 'R':
                    hPos ++;
                    break;

                case 'U':
                    vPos --;
                    break;

                case 'D':
                    vPos ++;
                    break;
            }
        }
        return hPos == 0 && vPos == 0;
    }

    @Test
    public void test() {
        assertTrue(judgeCircle("UD"));
        assertFalse(judgeCircle("LL"));
        assertTrue(judgeCircle("URDL"));
    }
}
