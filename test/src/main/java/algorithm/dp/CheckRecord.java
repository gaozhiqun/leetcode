package algorithm.dp;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/8/26 下午2:20
 */
public class CheckRecord {
    public static void main(String[] args) {

    }


    /**
     * 1 超过2次缺勤 A
     * 2 连续3天及以上迟到 LLL
     * 3 - 超过2次缺勤，以及连续K天迟到 LLL
     * i,j,k分别表示 前i天有j个迟到，且有k个连续3天及以上迟到
     * 0<i<=n, 0<=j<2, 0<=l<3
     *
     * @param n
     * @return
     */
    public int checkRecord(int n) {
        int mod = 1000000007;
        int[][][] dp = new int[n + 1][2][3];
        dp[0][0][0] = 1;
        for (int i = 1; i <= n; ++i) {
            //以P结尾
            for (int j = 0; j < 2; ++j) {
                for (int k = 0; k < 3; ++k) {
                    dp[i][j][0] = (dp[i][j][k] + dp[i - 1][j][0]) % mod;
                }
            }
            //以A结尾
            for (int k = 0; k < 3; ++k) {
                dp[i][1][0] = (dp[i][1][0] + dp[i - 1][0][k]) % mod;
            }
            //以L结尾
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k <= 2; k++) {
                    dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j][k - 1]) % mod;
                }
            }
        }
        int sum = 0;
            //以P结尾
            for (int j = 0; j < 2; ++j) {
                for (int k = 0; k < 3; ++k) {
                    sum =( sum+ dp[n][j][k])%mod;

                }
            }
        return sum;
    }
}