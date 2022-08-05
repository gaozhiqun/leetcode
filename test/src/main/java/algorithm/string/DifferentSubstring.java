package algorithm.string;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/4/13 2:11 下午
 */
public class DifferentSubstring {
    public static void main(String[] args) {

    }

    public int differentSubSequence(String l, String s) {
        int m = l.length();
        int n = s.length();
        if (m < n) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][n] = 1;
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (l.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        return dp[0][0];
    }

}
