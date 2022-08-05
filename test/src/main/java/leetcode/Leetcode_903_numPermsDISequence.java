package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/2/22 下午4:38
 */
public class Leetcode_903_numPermsDISequence {

    public static void main(String[] args) {
        Leetcode_903_numPermsDISequence leetcode_902_atMostNGivenDigitSet = new Leetcode_903_numPermsDISequence();
        System.out.println(leetcode_902_atMostNGivenDigitSet.numPermsDISequence("DID"));
    }

    /**
     * dp[i][j]-> 表示 已经排好序的i个 数字中，相对位置为K的数字的排序次数
     *
     * @param s
     * @return
     */
    public int numPermsDISequence(String s) {
        int MOD = 1_000_000_007;
        int N = s.length();

        // dp[i][j] : Num ways to place P_i with relative rank j
        int[][] dp = new int[N + 1][N + 1];
        Arrays.fill(dp[0], 1);

        for (int i = 1; i <= N; ++i) {
            for (int j = 0; j <= i; ++j) {
                if (s.charAt(i - 1) == 'D') {
                    for (int k = j; k < i; ++k) {
                        dp[i][j] += dp[i - 1][k];
                        dp[i][j] %= MOD;
                    }
                } else {
                    for (int k = 0; k < j; ++k) {
                        dp[i][j] += dp[i - 1][k];
                        dp[i][j] %= MOD;
                    }
                }
            }
        }

        int ret = 0;
        for (int x : dp[N]) {
            ret += x;
            ret %= MOD;
        }
        return ret;
    }
}