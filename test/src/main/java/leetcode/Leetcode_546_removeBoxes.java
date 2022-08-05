package leetcode;


import java.util.LinkedList;
import java.util.Queue;


/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/14 上午10:48
 */
public class Leetcode_546_removeBoxes {


    public static void main(String[] args) {
        Leetcode_546_removeBoxes l = new Leetcode_546_removeBoxes();

    }

    /**
     * 每一轮你可以移除具有相同颜色的连续 k 个盒子
     * 1 <= boxes.length <= 100
     * 1 <= boxes[i] <= 100
     * dp[l][r][k]-> [l-r]+ k*boxes[r];
     *
     * @param boxes
     * @return
     */
    int[][][] dp;

    public int removeBoxes(int[] boxes) {
        int m = boxes.length;
        dp = new int[m][m][m];
        return helper(boxes, 0, m - 1, 0);

    }

    private int helper(int[] boxes, int l, int r, int k) {
        if (l > r) {
            return 0;
        }
        if (dp[l][r][k] == 0) {
            int r1 = r, k1 = k;

            while (r1 > l && boxes[r1] == boxes[r1 - 1]) {
                r1--;
                ++k1;
            }
            dp[l][r][k] = helper(boxes, l, r1 - 1, 0) + (k1 + 1) * (k1 + 1);

            for (int i = l; i < r1; i++) {
                if (boxes[i] == boxes[r1]) {
                    dp[l][r][k] = Math.max(dp[l][r][k], helper(boxes, l, i, k1 + 1) + helper(boxes, i + 1, r1 - 1, 0));
                }
            }
        }
        return dp[l][r][k];
    }


}