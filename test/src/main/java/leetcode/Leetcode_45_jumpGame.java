package leetcode;


import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_45_jumpGame {

    public static void main(String[] args) {
        Leetcode_45_jumpGame l = new Leetcode_45_jumpGame();
        System.out.println(l.jump2(new int[]{2, 3, 1, 1, 4}));
        System.out.println(l.jump2(new int[]{2, 3, 0, 1, 4}));
    }

    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, nums.length);
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int k = 1; k <= nums[i] && i + k < nums.length; ++k) {
                dp[i + k] = Math.min(dp[i + k], dp[i] + 1);
            }
        }
        return dp[nums.length - 1];
    }

    public int jump2(int[] nums) {
        int m = nums.length;
        int ans = 0, max = 0, r = 0;
        for (int i = 0; i < m-1; ++i) {
            max = Math.max(max, i + nums[i]);
            if (i == r) {
                ++ans;
                r = max;
            }
        }
        return ans;
    }
}
