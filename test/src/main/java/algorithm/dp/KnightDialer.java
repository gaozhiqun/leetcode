package algorithm.dp;

import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/20 下午7:06
 */
public class KnightDialer {
    public static void main(String[] args) {
        KnightDialer k = new KnightDialer();
        System.out.println(k.knightDialer(1));
        System.out.println(k.knightDialer(2));
        System.out.println(k.knightDialer(3));
    }

    public int knightDialer(int n) {
        int mod = 100_000_0007;
        int[][] dp = new int[n][10];
        Arrays.fill(dp[0], 1);
        int[][] moves = new int[][]{
                {4, 6}, {6, 8}, {7, 9}, {4, 8}, {3, 9, 0}, {}, {1, 7, 0}, {2, 6}, {1, 3}, {2, 4}
        };
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < 10; j++) {
                for (int pre : moves[j]) {
                    dp[i][j] += dp[i - 1][pre];
                    dp[i][j] %= mod;
                }
            }
        }
        int ans = 0;
        for (int j = 0; j < 10; ++j) {
            ans += dp[n - 1][j];
            ans %= mod;
        }
        return ans;
    }
}
