package algorithm.dp;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/9/7 下午2:04
 */
public class MinDeleteSum {
    public static void main(String[] args) {

    }

    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= n; ++i) {
            dp[i][0] += dp[i - 1][0] + s1.codePointAt(i);
        }
        for (int i = 1; i <= n; ++i) {
            dp[0][i] += dp[0][i - 1] + s2.codePointAt(i);
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + s1.codePointAt(i), dp[i][j - 1] + s2.codePointAt(i));
                }
            }
        }
        return dp[m][n];
    }
}
