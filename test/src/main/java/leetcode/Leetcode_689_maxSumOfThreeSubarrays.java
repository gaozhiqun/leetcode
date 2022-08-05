package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/1/10 下午2:44
 */
public class Leetcode_689_maxSumOfThreeSubarrays {
    public static void main(String[] args) {

    }

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] ans = new int[3];
        int sum1 = 0, maxSum1 = 0, maxSum1Idx = 0;
        int sum2 = 0, maxSum12 = 0, maxSum12Idx1 = 0, maxSum12Idx2 = 0;
        int sum3 = 0, maxTotal = 0;
        for (int i = k * 2; i < nums.length; ++i) {
            sum1 += nums[i - k * 2];
            sum2 += nums[i - k];
            sum3 += nums[i];
            if (i >= k * 3 - 1) {
                if (sum1 > maxSum1) {
                    maxSum1 = sum1;
                    maxSum1Idx = i - k * 3 + 1;
                }
                if (maxSum1 + sum2 > maxSum12) {
                    maxSum12 = maxSum1 + sum2;
                    maxSum12Idx1 = maxSum1Idx;
                    maxSum12Idx2 = i - k * 2 + 1;
                }
                if (maxSum12 + sum3 > maxTotal) {
                    maxTotal = maxSum12 + sum3;
                    ans[0] = maxSum12Idx1;
                    ans[1] = maxSum12Idx2;
                    ans[2] = i - k + 1;
                }
                sum1 -= nums[i - k * 3 + 1];
                sum2 -= nums[i - k * 2 + 1];
                sum3 -= nums[i - k + 1];
            }
        }
        return ans;
    }
    /**
     * dp[i][j]=max(dp[i][j−1],dp[i−1][j−k]+sum[j]−sum[j−k])
     */


    public double knightProbability(int n, int k, int row, int column) {
        double[][] dp = new double[n][n];
        dp[row][column] = 1;
        int[] dr = new int[]{2, 2, 1, 1, -1, -1, -2, -2};
        int[] dc = new int[]{1, -1, 2, -2, 2, -2, 1, -1};
        for (; k > 0; k--) {
            double[][] newDp = new double[n][n];
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    for (int d = 0; d < 8; d++) {
                        int cr = r + dr[d];
                        int cc = c + dc[d];
                        if (0 <= cr && cr < n && 0 <= cc && cc < n) {
                            newDp[cr][cc] += dp[r][c] / 8.0;
                        }
                    }
                }
            }
            dp = newDp;
        }
        double ans = 0.0;
        for (double[] r : dp) {
            for (double x : r) {
                ans += x;
            }
        }
        return ans;
    }

}
