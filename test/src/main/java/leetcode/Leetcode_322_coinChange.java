package leetcode;


import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_322_coinChange {

    public static void main(String[] args) {
        Leetcode_322_coinChange l = new Leetcode_322_coinChange();
        System.out.println(l.coinChange(new int[]{1, 2, 5}, 11));

        System.out.println(l.coinChange(new int[]{2}, 3));
        System.out.println(l.coinChange(new int[]{1}, 0));
        System.out.println(l.coinChange(new int[]{1}, 2));
    }

    /**
     * 最少的硬币个数
     */

    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 1000_000_007);
        dp[0] = 0;
        for (int i = 1; i <= amount; ++i) {
            for (int c : coins) {
                if (i - c >= 0) {
                    dp[i] = Math.min(dp[i - c] + 1, dp[i]);
                }
            }
        }
        return dp[amount] == 1000_000_007 ? -1 : dp[amount];

    }
}