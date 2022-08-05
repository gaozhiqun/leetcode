package algorithm.dp;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/9/7 下午8:53
 */
public class CountPalindromicSubsequences {
    public static void main(String[] args) {

    }

    /**
     * dp[i][j] = i==j? dp[i-1][j-1] +2
     *
     * @param s
     * @return
     */
    public int countPalindromicSubsequences(String s) {
        int m = s.length();
        int[][] dp = new int[m][m];
        for (int i = m - 1; i >= 0; --i) {
            dp[i][i] = 1;
            for (int j = m - 1; j > i; --j) {

            }
        }
        return 0;
    }
}
