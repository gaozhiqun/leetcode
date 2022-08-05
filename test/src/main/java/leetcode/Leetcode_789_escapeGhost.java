package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/1/17 上午10:53
 */
public class Leetcode_789_escapeGhost {
    public static void main(String[] args) {
        Leetcode_789_escapeGhost l = new Leetcode_789_escapeGhost();
    }

    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int move = Math.abs(target[0]) + Math.abs(target[1]);
        for (int[] ghost : ghosts) {
            int minMove = Math.abs(ghost[0] - target[0]) + Math.abs(ghost[1] - target[1]);
            if (minMove <= move) {
                return false;
            }
        }
        return true;
    }
}
