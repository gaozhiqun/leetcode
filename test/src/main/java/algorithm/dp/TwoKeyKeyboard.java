package algorithm.dp;

import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/9/1 下午1:45
 */
public class TwoKeyKeyboard {
    public static void main(String[] args) {
        TwoKeyKeyboard twoKeyKeyboard = new TwoKeyKeyboard();
        System.out.println(twoKeyKeyboard.minSteps(3));
        System.out.println(twoKeyKeyboard.minSteps(5));
    }

    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[j] + i / j, dp[i]);
                }
            }
        }
        return dp[n];
    }
}
