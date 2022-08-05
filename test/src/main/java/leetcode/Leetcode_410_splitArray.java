package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/10 上午11:24
 */
public class Leetcode_410_splitArray {
    public static void main(String[] args) {
        Leetcode_410_splitArray l = new Leetcode_410_splitArray();


    }

    /**
     * 给定一个非负整数数组 nums 和一个整数 m ，你需要将这个数组分成 m 个非空的连续子数组。
     * 设计一个算法使得这 m 个子数组各自和的最大值最小。
     * dp[j][k] -> i到j分割成k个数组，最大值最小
     * dp[j][1] = sums[j]-sums[i-1]
     * easy! bro
     */
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        int[] sub = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sub[i + 1] = sub[i] + nums[i];
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, m); j++) {
                for (int k = 0; k < i; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], sub[i] - sub[k]));
                }
            }
        }
        return dp[n][m];
    }
}



