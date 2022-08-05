package algorithm.array;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/8/25 下午1:27
 */
public class FindTargetSumWays {

    public static void main(String[] args) {
        FindTargetSumWays findTargetSumWays = new FindTargetSumWays();
        System.out.println(findTargetSumWays.finldTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

    /**
     * dp[i][j] = dp[i-1][j] OR dp[i-1][j] + dp[i-1][j-num]
     * dp[j] = dp[j] + dp[j-num]
     *
     * @param nums
     * @param target sum -2*neg = target
     *               sum-target/2 = neg;
     * @return
     */
    public int finldTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int l = (sum - target) / 2;
        int[] dp = new int[l + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = l; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[l];
    }
}
