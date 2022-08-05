package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/4/6 下午5:23
 */
public class Leetcode_1031_maxSumTwoNoOverlap {

    public int maxSumTwoNoOverlap(int[] nums, int smaller, int bigger) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        ;
        if (smaller > bigger) {
            int t = smaller;
            smaller = bigger;
            bigger = t;
        }
        int[][] dp = new int[n + 1][2];
        int max = 0;
        for (int i = smaller; i <= n; i++) {
            int s1 = sum[i] - sum[i - smaller];
            dp[i][0] = Math.max(dp[i - 1][0], s1);
            max = Math.max(max, s1 + dp[i - smaller][1]);
            if (i >= bigger) {
                int s2 = sum[i] - sum[i - bigger];
                dp[i][1] = Math.max(dp[i - 1][1], s2);
                max = Math.max(max, s2 + dp[i - bigger][0]);
            }
        }
        return max;
    }
}
