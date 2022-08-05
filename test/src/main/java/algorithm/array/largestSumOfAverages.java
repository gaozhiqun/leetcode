package algorithm.array;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/9/26 下午8:54
 */
public class largestSumOfAverages {
    public static void main(String[] args) {

    }

    public double largestSumOfAverages(int[] nums, int k) {
        int m = nums.length;
        int[] sums = new int[m + 1];
        sums[0] = nums[0];
        for (int i = 1; i < sums.length; ++i) {
            sums[i] = sums[i - 1] + nums[i];
        }
        int[] dp = new int[m];
        for (int i = 0; i < m; ++i) {
            dp[i] = (sums[m] - sums[i]) / (m - i);
        }
        for (int l = 0; l < k - 1; ++l) {
            for (int i = 0; i < m; ++i) {
                for (int j = i + 1; j < m; ++j) {
                    dp[i] = Math.max(dp[i], (sums[j] - sums[i]) / (j - i) + dp[j]);
                }
            }
        }
        return dp[0];
    }

}
