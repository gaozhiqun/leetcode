package algorithm.dp;

import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/4/13 2:23 下午
 */
public class SellingStock {
    /**
     * 买卖股票的最佳时机 dp
     */
    public static void main(String[] args) {

    }

    public int bestTimeBuyAndSellStocks(int[] array) {
        int result = Integer.MIN_VALUE;
        int curMin = array[0];
        for (int i = 1; i < array.length; i++) {
            result = Math.max(result, array[i] - curMin);
            curMin = Math.min(curMin, array[i]);
        }
        return result;
    }

    public int bestTimeBuyAndSellStocksWithMultiTransaction(int[] array) {
        int n = array.length + 1;
        int[] profit = new int[n];
        int[] holds = new int[n];
        holds[0] = -array[0];
        for (int i = 1; i < array.length; i++) {
            profit[i] = Math.max(profit[i - 1], holds[i - 1] + array[i]);
            holds[i] = Math.max(holds[i - 1], profit[i - 1] - array[i]);
        }
        return profit[n];
    }

    public int maximumProfitWith2Transactions(int[] price) {
        int n = price.length;
        int result = 0;
        int[] preProfit = new int[n];
        int[] postProfit = new int[n];
        int preMin = price[0];
        int postMax = price[n - 1];
        preProfit[0] = 0;
        postProfit[n] = 0;
        for (int i = 1; i < n; i++) {
            preProfit[i] = price[i] - preMin;
            postProfit[n - i] = postMax - price[n - i];
            preMin = Math.min(price[i], preMin);
            postMax = Math.max(price[n - i], postMax);
        }
        for (int i = 0; i < n; i++) {
            result = Math.max(result, preProfit[i] + postProfit[i + 1]);
        }
        return result;
    }

    //最多2笔交易
    public int maxProfit(int[] price) {
        int n = price.length;
        int buy1 = -price[0], sell1 = 0;
        int buy2 = -price[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            buy1 = Math.max(buy1, -price[i]);
            sell1 = Math.max(sell1, buy1 + price[i]);
            buy2 = Math.max(buy2, sell1 - price[i]);
            sell2 = Math.max(sell2, buy2 + price[i]);
        }
        return sell2;
    }

    //最多N笔交易
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        k = Math.min(k, n / 2);
        int[][] buy = new int[n][k + 1];
        int[][] sell = new int[n][k + 1];

        buy[0][0] = -prices[0];
        sell[0][0] = 0;
        for (int i = 1; i <= k; ++i) {
            buy[0][i] = sell[0][i] = Integer.MIN_VALUE / 2;
        }

        for (int i = 1; i < n; ++i) {
            buy[i][0] = Math.max(buy[i - 1][0], sell[i - 1][0] - prices[i]);
            for (int j = 1; j <= k; ++j) {
                buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j] - prices[i]);
                sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j - 1] + prices[i]);
            }
        }

        return Arrays.stream(sell[n - 1]).max().getAsInt();
    }


}
