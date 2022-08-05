package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/6 下午8:18
 */
public class Leetcode_377_combitionSum4 {
    public static void main(String[] args) {
        Leetcode_377_combitionSum4 l = new Leetcode_377_combitionSum4();
        System.out.println(l.combinationSum4(new int[]{1, 2, 3}, 4));

    }


    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; ++i) {
            for (int pre : nums) {
                if (i - pre >= 0) {
                    dp[i] += dp[i - pre];
                }
            }
        }
        return dp[target];
    }


}
