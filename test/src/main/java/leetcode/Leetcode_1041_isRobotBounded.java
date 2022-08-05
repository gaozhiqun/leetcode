package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/4/8 上午10:56
 */
public class Leetcode_1041_isRobotBounded {
    public static void main(String[] args) {
        Leetcode_1041_isRobotBounded l = new Leetcode_1041_isRobotBounded();
        System.out.println(l.isRobotBounded("LLGRL"));
        System.out.println(l.isRobotBounded("GGLLGG"));
        System.out.println(l.isRobotBounded("GG"));
        System.out.println(l.isRobotBounded("GL"));

    }

    private static int[][] MOVES = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};//URDL

    public boolean isRobotBounded(String instructions) {
        int i = 0, j = 0, d = 0;
        for (char ch : instructions.toCharArray()) {
            switch (ch) {
                case 'G': {
                    i += MOVES[d][0];
                    j += MOVES[d][1];
                }
                break;
                case 'L':
                    d = ((d - 1) + 4) % 4;
                    break;
                case 'R':
                    d = (d + 1) % 4;
                    break;
                default:
            }
        }
        return d != 0 || (i == 0 && j == 0);
    }

}
