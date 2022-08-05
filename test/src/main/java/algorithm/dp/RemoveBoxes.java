package algorithm.dp;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/8/26 下午1:25
 */
public class RemoveBoxes {
    public static void main(String[] args) {

    }

    /**
     * dp[i][j] 移除N个气球最大分数，
     * dp[i+t][j-t] i->0,j->m-1开始
     * dp[i][j][k]
     *
     * @param boxes
     * @return
     */
    int[][][] dp;

    public int removeBoxes(int[] boxes) {
        int m = boxes.length;
        int[][][] dp = new int[m][m][m];
        return calculate(boxes, 0, m - 1, 0);
    }

    private int calculate(int[] boxes, int l, int r, int k) {
        if (l > r) {
            return 0;
        }
        if (dp[l][r][k] == 0) {
            int r1 = r, k1 = k;
            while (r1 > 1 && boxes[r1] == boxes[r1 - 1]) {
                r1--;
                k1++;
            }
            dp[l][r][k] = calculate(boxes, l, r1 - 1, 0) + (k1 + 1) * (k1 + 1);
            for (int i = l; i < r1; i++) {
                if (boxes[i] == boxes[r1]) { //a[i] ==a[r]时先删除中间的数字，再删除完整
                    dp[l][r][k] = Math.max(dp[l][r][k], calculate(boxes, l, i, k1 + 1) + calculate(boxes, i + 1, r1 - 1, 0));
                }
            }
        }
        return dp[l][r][k];
    }

}
