package algorithm.huawei;

import java.util.Scanner;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/23 下午3:46
 */
public class EditDistance {


    public static int editDistance(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if (m == 0) {
            return n;
        } else if (n == 0) {
            return m;
        }
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    dp[i + 1][j + 1] = Math.min(dp[i][j] + 1, Math.min(dp[i + 1][j] + 1, dp[i][j + 1] + 1));
                }
            }
        }
        return dp[m][n];
    }


}
