package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/3/24 上午10:27
 */
public class Leetcode_940_distinctSubseqII {


    /**
     * dp[k] 表示 S[0 .. k] 可以组成的不同子序列的数目。
     *
     * @param s
     * @return
     */
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        int N = s.length();
        int[] dp = new int[N + 1];
        dp[0] = 1;
        int[] last = new int[26];
        Arrays.fill(last, -1);
        for (int i = 0; i < N; ++i) {
            int x = s.charAt(i) - 'a';
            dp[i + 1] = (dp[i] * 2) % MOD;
            if (last[x] >= 0) {
                dp[i + 1] -= dp[last[x]];
            }
            dp[i + 1] %= MOD;
            last[x] = i;
        }
        dp[N]--;
        if (dp[N] < 0) {
            dp[N] += MOD;
        }
        return dp[N];
    }


    public int[] diStringMatch(String S) {
        int N = S.length();
        int lo = 0, hi = N;
        int[] ans = new int[N + 1];
        for (int i = 0; i < N; ++i) {
            if (S.charAt(i) == 'I') {
                ans[i] = lo++;
            } else {
                ans[i] = hi--;
            }
        }
        ans[N] = lo;
        return ans;
    }

}
