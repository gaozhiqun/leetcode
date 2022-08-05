package algorithm.dp;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/8/25 下午4:17
 */
public class LongestPalindromeSubSeq {
    public static void main(String[] args) {

    }

    /**
     * dp[i][j] == max(dp[k-1][j-1],)
     *
     * @param s
     */
    public void longestPalindromeSubSeq(String s) {
        int m = s.length();
        int[][] dp = new int[m][m];
        for (int i = m - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < m; j++) {
                if (s.charAt(j) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
    }
}
