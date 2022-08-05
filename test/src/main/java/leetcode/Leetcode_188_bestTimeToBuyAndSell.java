package leetcode;


import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/5 下午2:42
 */
public class Leetcode_188_bestTimeToBuyAndSell {

    public static void main(String[] args) {
        Leetcode_188_bestTimeToBuyAndSell l = new Leetcode_188_bestTimeToBuyAndSell();
        System.out.println(l.maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
    }

    /**
     * 最多k笔交易 dp[n][k] = Math.max(dp[n][k],dp[n][k-1]);
     *
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        int m = prices.length;
        if (m == 0) {
            return 0;
        }
        int[][][] dp = new int[m][k + 1][2];
        dp[0][0][0] = -prices[0];
        for (int i = 1; i < m; ++i) {
            dp[i][0][0] = Math.max(dp[i - 1][0][0], -prices[i]);
        }
        for (int op = 1; op <= k; op++) {
            for (int i = 0; i < m; ++i) {
                dp[i][op][0] = dp[i][op - 1][0];
                dp[i][op][1] = dp[i][op - 1][1];
                if (i > 0) {
                    //1 出售时，op 增加
                    dp[i][op][1] = Math.max(dp[i - 1][op - 1][0]
                            + prices[i], dp[i - 1][op][1]);
                    //购买时,op不增加
                    dp[i][op][0] = Math.max(dp[i - 1][op][1]
                            - prices[i], dp[i - 1][op][0]);
                }
            }
        }
        return Math.max(dp[m - 1][k][0], dp[m - 1][k][1]);
    }


}