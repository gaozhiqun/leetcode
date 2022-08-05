package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/1/17 上午10:53
 */
public class Leetcode_790_numTilings {
    public static void main(String[] args) {
        Leetcode_790_numTilings l = new Leetcode_790_numTilings();
    }

    private static final int MOD = 1000_000_007;

    /**
     * 0：XX
     * 1 X
     * X
     * 2 XX
     * x
     * 3 X
     * xx
     * 1. 全不铺
     * 2. 全铺
     * 3。 第一层铺
     * 4 第2层铺
     *
     * @param N
     * @return
     */
    public int numTilings(int N) {
        long[] dp = new long[]{1, 0, 0, 0};
        for (int i = 0; i < N; ++i) {
            long[] newDp = new long[4];
            newDp[0] = (dp[0] + dp[3]) % MOD;
            newDp[1] = (dp[0] + dp[2]) % MOD;
            newDp[2] = (dp[0] + dp[1]) % MOD;
            newDp[3] = (dp[0] + dp[1] + dp[2]) % MOD;
            dp = newDp;
        }
        return (int) dp[0];
    }
}
