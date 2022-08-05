package algorithm.dp;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/18 下午4:18
 */
public class EggsFall {
    public static void main(String[] args) {

    }

    public int superEggDrop(int k, int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
        }
        for (int j = 2; j <= k; j++) {
            int[] dp2 = new int[n + 1];
            int x = 1;
            for (int m = 1; m <= n; ++m) {
                /**
                 * x 单调增加
                 */
                while (x < m && Math.max(dp[x - 1], dp[m - x]) > Math.max(dp[x], dp[m - x - 1])) {
                    ++x;
                }
                dp2[m] = 1 + Math.max(dp[x], dp[m - x]);
            }

            dp = dp2;
        }
        return dp[n];
    }

    /**
     * dp[i][j] -> 达到高度i需要k个鸡蛋
     *
     * @param k（鸡蛋个数）
     * @param n       (n层楼)
     * @return
     */
    public int superEggDrop2(int k, int n) {
        int[][] dp = new int[n + 1][k + 1];
        /**
         * dp[f][t]>=n 的最小t
         */
        int ans = -1;
        for (int i = 0; i <= n; ++i) {
            dp[1][k] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= k; ++j) { //假设在第i层刚好碎了
                dp[i][j] = 1 + dp[i - 1][j - 1] + dp[i - 1][j];
            }
            if (dp[i][k] >= n) {
                ans = i;
                break;
            }
        }
        return ans;
    }
}
