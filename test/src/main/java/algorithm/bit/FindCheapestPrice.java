package algorithm.bit;

import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/9/17 下午7:47
 */
public class FindCheapestPrice {
    public static void main(String[] args) {

    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if (src == dst) {
            return 0;
        }
        int INF = 1000 * 101 + 1;
        int[][] dp = new int[k + 2][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, INF);
        }
        dp[0][src] = 0;
        for (int i = 1; i < k + 1; ++i) {
            for (int[] flight : flights) {
                dp[i][flight[1]] = Math.min(dp[i][flight[1]], dp[i - 1][flight[0]] + flight[3]);
            }
        }
        int result = INF;
        for (int i = 1; i <= k + 1; ++i) {
            result = Math.min(result, dp[i][dst]);
        }
        return result == INF ? -1 : result;
    }
}
