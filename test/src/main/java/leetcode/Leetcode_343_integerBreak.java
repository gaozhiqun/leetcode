package leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/2 下午9:11
 */
public class Leetcode_343_integerBreak {

    /**
     * 至少两个正整数的和
     * (i-j)*j dp[i-j]*j dp[i-j]*dp[j]
     *
     * @param n
     * @return
     */

    public int integerBreak(int n) {
        if (n < 4) {
            return n - 1;
        }
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(Math.max(2 * (i - 2), 2 * dp[i - 2]), Math.max(3 * (i - 3), 3 * dp[i - 3]));
        }
        return dp[n];
    }

}
