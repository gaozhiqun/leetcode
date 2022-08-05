package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/2/21 下午4:33
 */
public class Leetcode_879_profitableSchemes {
    public static void main(String[] args) {

    }

    /**
     * 集团里有 n 名员工，他们可以完成各种各样的工作创造利润。
     * <p>
     * 第 i 种工作会产生 profit[i] 的利润，它要求 group[i] 名成员共同参与。如果成员参与了其中一项工作，就不能参与另一项工作。
     * <p>
     * 工作的任何至少产生 minProfit 利润的子集称为 盈利计划 。并且工作的成员总数最多为 n 。
     * <p>
     * 有多少种计划可以选择？因为答案很大，所以 返回结果模 10^9 + 7 的值。
     * dp[i][j][k] 对于第i项工作，要/不要时， j个人， k利润时的数量
     */
    public int profitableSchemes2(int n, int minProfit, int[] group, int[] profit) {
        int len = group.length, MOD = 1000_000_007;
        int[][][] dp = new int[len + 1][n + 1][minProfit + 1];
        for (int i = 1; i <= len; ++i) {
            int m = group[i], p = profit[i];
            for (int j = 0; j <= n; ++j) {
                for (int k = 0; k <= minProfit; k++) {
                    if (j < m) {
                        dp[i][j][k] = dp[i - 1][j][k];
                    } else {
                        dp[i][j][k] = (dp[i - 1][j][k] + dp[i - 1][j - m][Math.max(0, k - p)]) % MOD;
                    }
                }
            }
        }
        int sum = 0;
        for (int j = 0; j <= n; j++) {
            sum = (sum + dp[len][j][minProfit]) % MOD;
        }
        return sum;
    }

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int[][] dp = new int[n + 1][minProfit + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        int len = group.length, MOD = (int) 1e9 + 7;
        for (int i = 0; i < len; i++) {
            int members = group[i], earn = profit[i];
            for (int j = n; j >= members; j--) {
                for (int k = minProfit; k >= 0; k--) {
                    dp[j][k] = (dp[j][k] + dp[j - members][Math.max(0, k - earn)]) % MOD;
                }
            }
        }
        return dp[n][minProfit];
    }
}
