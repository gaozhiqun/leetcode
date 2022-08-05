package algorithm.dp;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/7/1 下午5:42
 */
public class CombinationSum {
    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        System.out.println(combinationSum.combinationSum(new int[]{1, 2, 3}, 4));
    }

    public int combinationSum(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j : nums) {
                if (i - j >= 0) {
                    dp[i] += dp[i - j];
                }
            }
        }
        return dp[target];
    }
}
