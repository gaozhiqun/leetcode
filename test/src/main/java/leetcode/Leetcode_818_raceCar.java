package leetcode;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_818_raceCar {

    public static void main(String[] args) {
        Leetcode_818_raceCar l = new Leetcode_818_raceCar();
    }

    /**
     * position += speed
     * speed *= 2
     * 当收到指令 'R' 时，赛车这样行驶：
     * 如果速度为正数，那么speed = -1
     * 否则 speed = 1
     * 1+2+4+8
     */
    public int racecar(int target) {
        int[] dp = new int[target + 3];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 4;

        for (int t = 3; t <= target; ++t) {
            int k = 32 - Integer.numberOfLeadingZeros(t);
            if (t == (1 << k) - 1) {
                dp[t] = k;
                continue;
            }
            for (int j = 0; j < k - 1; ++j) {
                dp[t] = Math.min(dp[t], dp[t - (1 << (k - 1)) + (1 << j)] + k - 1 + j + 2);
            }
            if ((1 << k) - 1 - t < t) {
                dp[t] = Math.min(dp[t], dp[(1 << k) - 1 - t] + k + 1);
            }
        }
        return dp[target];
    }


}