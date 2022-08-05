package algorithm.array;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/8/26 下午8:00
 */
public class MinDistance {
    public static void main(String[] args) {

    }

    /**
     * 最长公共子串
     *
     * @param s
     * @param l
     * @return
     */
    public int minDistance(String s, String l) {
        int m = s.length();
        int n = l.length();
        int[][] dp = new int[m + 1][n + 1];
        //dp[i][j] ==
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    continue;
                }
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return m + n - 2 * dp[m][n];
    }
}
