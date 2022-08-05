package algorithm.dp;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/21 下午2:25
 */
public class DistinctSubSeqll {
    public static void main(String[] args) {
        DistinctSubSeqll d
                = new DistinctSubSeqll();
        System.out.println(d.distinctSubSeqll("aba"));
    }

    /**
     * leetcode 940
     *
     * @param s
     * @return
     */
    public int distinctSubSeqll(String s) {
        int mod = 100_000_007;
        int m = s.length();
        int[] dp = new int[m + 1];
        dp[0] = 1;
        int[] last = new int[26];// 考虑第i个字母，最后一次出现的
        Arrays.fill(last, -1);
        for (int i = 0; i < m; ++i) {
            int x = s.charAt(i) - 'a';
            dp[i + 1] = dp[i] * 2 % mod;
            if (last[x] >= 0) {
                dp[i + 1] -= dp[last[x]];
            }
            dp[i + 1] %= mod;
            last[x] = i;
        }
        dp[m]--;//去掉空串
        if (dp[m] < 0) {
            dp[m] += mod;
        }
        return dp[m];
    }
}
