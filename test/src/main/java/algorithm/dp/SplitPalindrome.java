package algorithm.dp;

import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/3/8 7:46 下午
 */
public class SplitPalindrome {
    public static void main(String[] args) {

    }

    int minSplit(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; ++j) {
                dp[i][j] = s.charAt(i) == s.charAt(j);
            }
        }
        int[] f = new int[n];
        Arrays.fill(f, Integer.MAX_VALUE);
        for (int i = 0; i < n; ++i) {
            if (dp[0][i]) {
                f[i] = 0;
            } else {
                for (int j = 0; j < i; ++j) {
                    if (dp[j + 1][i]) {
                        f[i] = Math.min(f[i], f[j] + 1);
                    }
                }
            }
        }
        return f[n - 1];
    }
}
