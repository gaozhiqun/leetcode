package algorithm.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/18 下午8:17
 */
public class NumPermsDISequence {

    public static void main(String[] args) {

    }

    /**
     * dp[i][j] 表示由范围 [0, i] 内的数字组成且最后一个数字为j的不同序列的个数。
     * if (S[i-1] == 'D')    dp[i][j] += dp[i-1][k]    ( j <= k <= i-1 )
     * else                  dp[i][j] += dp[i-1][k]    ( 0 <= k < j )
     */

    public int numPermsDISequence(String s) {
        int m = s.length(), mod = 100_000_007;
        int[][] dp = new int[m + 1][m + 1];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i <= m; ++i) {
            for (int j = 0; j <= i; ++j) {
                if (s.charAt(i) == 'D') {
                    for (int k = j; k < i; ++k) {
                        dp[i][j] += dp[i - 1][k];
                        dp[i][j] %= mod;
                    }
                } else {
                    for (int k = 0; k < j; ++k) {
                        dp[i][j] += dp[i - 1][k];
                        dp[i][j] %= mod;
                    }
                }
            }
        }
        int ans = 0;
        for (int x : dp[m]) {
            ans += x;
            ans %= mod;
        }
        return ans;
    }
}
