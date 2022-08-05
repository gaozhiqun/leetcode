package algorithm.dp;

import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/8/27 下午2:26
 */
public class KInversePairs {
    public static void main(String[] args) {
        KInversePairs kInversePairs = new KInversePairs();
        System.out.println(kInversePairs.kInversePairs(3, 1));
    }

    /**
     * 错项相减
     * f[m][n] = f[m-1][n] + f[m-1][n-1]+ f[m-1][n-2]...f[m-1][n-j]
     * f[m][n-1] = f[m-1][n-1]+ f[m-1][n-2]...f[m-1][n-j]
     * f[m][n] = f[m-1][n]  -f[m-1][n-1] + f[m][n-1]
     *
     * @param n
     * @param k
     * @return
     */
    public int kInversePairs(int n, int k) {
        if (k == 0) {
            return 1;
        }
        int[][] dp = new int[n + 1][k + 1];
        int M = 1000000007;

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= k; j++) {
                if (i == 1 && j == 0) {
                    dp[i][j] = 1;
                    break;
                } else if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    int val = (dp[i - 1][j] + M - ((j - i) >= 0 ? dp[i - 1][j - i] : 0)) % M;
                    dp[i][j] = (dp[i][j - 1] + val) % M;
                }
            }
        }
        return dp[n][k];
    }
}
