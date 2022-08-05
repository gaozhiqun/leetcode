package algorithm.dp;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/8/20 下午5:35
 */
public class PredictTheWinner {
    public static void main(String[] args) {

    }

    /**
     * dp[i][j] 表示i到j，获胜的点数
     * 那么dp[i][j] = nums[i] - dp[i-1][j]  ,nums[j] - dp[i][j-1]
     * ==>  dp[i] =  nums[i]-dp[j], nums[i]-dp[j-1];
     *
     * @param nums
     * @return
     */
    public boolean predictTheWinner(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = nums[i];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = i + 1; i < nums.length; j++) {
                dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
            }
        }
        return dp[nums.length] >= 0;
    }

}
