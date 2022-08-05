package algorithm.dp;

import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/6/1 3:28 下午
 */
public class MaxCoins {
    public static void main(String[] args) {
//戳气球，反过来就是加气球
    }

    public int maxCoins(int[] nums) {
        int m = nums.length;
        int[] newNums = new int[m + 2];
        newNums[0] = 1;
        newNums[m + 1] = 1;
        for (int i = 0; i < m; i++) {
            newNums[i + 1] = newNums[i];
        }
        int[][] dp = new int[m + 2][m + 2];
        for (int i = 0; i <= m + 1; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(0, m + 1, dp, newNums);
    }

    public int solve(int l, int r, int[][] dp, int[] newNums) {
        if (l >= r - 1) {
            return 0;
        }
        if (dp[l][r] != -1) {
            return dp[l][r];
        }
        for (int i = l + 1; i < r; i++) {
            int sum = newNums[l] * newNums[i] * newNums[r];
            sum += solve(l, i, dp, newNums) + solve(i, r, dp, newNums);
            dp[l][r] = Math.max(dp[l][r], sum);
        }
        return dp[l][r];
    }


}
