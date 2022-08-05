package leetcode;

import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/1/17 上午10:53
 */
public class Leetcode_787_findCheapestPrice {
    public static void main(String[] args) {
        Leetcode_787_findCheapestPrice l = new Leetcode_787_findCheapestPrice();
    }


    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        final int INF = 10000 * 101 + 1;
        int[][] dp = new int[k + 2][n];
        for (int i = 0; i < k + 2; ++i) {
            Arrays.fill(dp[i], INF);
        }
        dp[0][src] = 0;
        for (int t = 1; t <= k + 1; ++t) {
            for (int[] flight : flights) {
                int j = flight[0], i = flight[1], cost = flight[2];
                dp[t][i] = Math.min(dp[t][i], dp[t - 1][j] + cost);
            }
        }
        int ans = INF;
        for (int t = 1; t <= k + 1; ++t) {
            ans = Math.min(ans, dp[t][dst]);
        }
        return ans == INF ? -1 : ans;
    }
}
