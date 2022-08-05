package algorithm.array;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/9/18 下午12:12
 */
public class NumTilings {
    public static void main(String[] args) {
        NumTilings numTilings = new NumTilings();
        System.out.println(numTilings.numTilings(3));
    }

    int mod = 1000000007;

    public int numTilings(int n) {
        long[] dp = new long[]{1, 0, 0, 0};//第i行不铺/上有下无/上无下有/铺满
        for (int i = 0; i < n; ++i) {
            long[] next = new long[4];
            next[0b00] = (dp[0b00] + dp[0b11]) % mod;
            next[0b01] = (dp[0b00] + dp[0b10]) % mod;
            next[0b10] = (dp[0b00] + dp[0b01]) % mod;
            next[0b11] = (dp[0b00] + dp[0b01] + dp[0b10]) % mod;
            dp = next;
        }
        return (int) dp[0];
    }

}
