package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/5 下午2:42
 */
public class Leetcode_121_maxProfit {
    public static void main(String[] args) {
        Leetcode_121_maxProfit l = new Leetcode_121_maxProfit();
        System.out.println(l.maxProfit3(new int[]{1, 2, 3, 4, 5}));
        System.out.println(l.maxProfit3(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
        System.out.println(l.maxProfit3(new int[]{7, 6, 4, 3, 1}));
        System.out.println(l.maxProfit3(new int[]{0}));

        System.out.println(l.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(l.maxProfit(new int[]{7, 6, 4, 3, 1}));

        System.out.println(l.maxProfit2(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(l.maxProfit2(new int[]{7, 6, 4, 3, 1}));
        System.out.println(l.maxProfit2(new int[]{1, 2, 3, 4, 5}));


    }


    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for (int i : prices) {
            ans = Math.max(ans, i - min);
            min = Math.min(i, min);
        }
        return ans;
    }

    /**
     * 多笔交易,但是每次只能进行一笔交易
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int hold = -prices[0], sell = 0;
        for (int i = 1; i < prices.length; i++) {
            int newHold = Math.max(hold, sell - prices[i]);
            int nesSell = Math.max(sell, hold + prices[i]);
            hold = newHold;
            sell = nesSell;
        }
        return Math.max(hold, sell);
    }

    /**
     * 最多可以完成 两笔 交易
     *
     * @param prices
     * @return
     */


    public int maxProfit4(int[] prices) {
        int sell1 = 0, sell2 = 0, buy1 = -prices[0], buy2 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            buy1 = Math.max(sell1 - prices[i], buy1);
            sell1 = Math.max(buy1 + prices[i], sell1);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }

    public int maxProfit3(int[] prices) {
        return maxProfitWithAtMostK(prices, 2);
    }

    public int maxProfitWithAtMostK(int[] prices, int k) {
        int m = prices.length;
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


    /**
     * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
     * // f[i][0]: 手上持有股票的最大收益
     * // f[i][1]: 手上不持有股票，并且处于冷冻期中的累计最大收益
     * // f[i][2]: 手上不持有股票，并且不在冷冻期中的累计最大收益
     */


    public int maxProfitWithCoolDown(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int hold = -prices[0];
        int coolDown = 0;
        int sell = 0;
        for (int i = 1; i < n; ++i) {
            int newHold = Math.max(hold, sell - prices[i]);
            int newCoolDown = hold + prices[i];
            int newSell = Math.max(coolDown, sell);
            hold = newHold;
            coolDown = newCoolDown;
            sell = newSell;
        }
        return Math.max(coolDown, sell);
    }


}
