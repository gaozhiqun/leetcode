package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/5 下午2:42
 */
public class Leetcode_115_numDistinct {
    public static void main(String[] args) {
        Leetcode_115_numDistinct l = new Leetcode_115_numDistinct();
        System.out.println(l.numDistinct("rabbbit", "rabbit"));
        System.out.println(l.numDistinct("babgbag", "bag"));
    }

    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; ++i) {
            dp[i][0] = 1;
        }
        for (int j = 1; j <= n; ++j) {
            for (int i = 1; i <= m; ++i) {
                dp[i][j] = dp[i - 1][j];
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }

}
