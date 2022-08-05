package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_813_largestSumOfAverages {

    public static void main(String[] args) {
        Leetcode_813_largestSumOfAverages l = new Leetcode_813_largestSumOfAverages();
    }

    /**
     * K 个相邻的非空子数组
     *
     * @param nums
     * @param k
     * @return
     */
    public double largestSumOfAverages(int[] nums, int k) {
        int N = nums.length;
        int[] sum = new int[N + 1];
        double[] dp = new double[N + 1];
        for (int i = 1; i < N; ++i) {
            sum[i] = sum[i - 1] + nums[i - 1];
            dp[i] = (double) sum[i] / i;
        }
        for (int l = 2; l <= k; ++l) {
            double[] newDp = new double[N + 1];
            for (int i = l - 1; i <= N; ++i) {
                for (int j = 1; j < i; ++j) {
                    newDp[i] = Math.max(newDp[i], dp[j] + (sum[i] - sum[j]));
                }
            }
        }
        return dp[N];
    }

}