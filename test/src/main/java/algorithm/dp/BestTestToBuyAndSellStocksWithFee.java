package algorithm.dp;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/9/7 下午2:28
 */
public class BestTestToBuyAndSellStocksWithFee {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices, int fee) {
        int m = prices.length;
        int[] profits = new int[m + 1];
        int[] holds = new int[m + 1];
        for (int i = 1; i <= prices.length; i++) {
            profits[i] = Math.max(profits[i - 1], holds[i - 1] + prices[i] - fee);
            holds[i] = Math.max(profits[i - 1] - prices[i], profits[i - 1]);
        }
        return profits[m];
    }
}
