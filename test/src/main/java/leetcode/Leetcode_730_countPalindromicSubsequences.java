package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/1/12 上午10:26
 */
public class Leetcode_730_countPalindromicSubsequences {

    public static void main(String[] args) {
        Leetcode_730_countPalindromicSubsequences l = new Leetcode_730_countPalindromicSubsequences();
        System.out.println(l.countPalindromicSubsequences("abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba"));
    }


    /**
     * dp[i][j] 以 i为中心的长度为j的回文数个数
     * S[i] 将会是集合 {'a', 'b', 'c', 'd'} 中的某一个
     *
     * @param s
     * @return
     */

    int MOD = 1_000_000_007;

    public int countPalindromicSubsequences(String s) {
        int m = s.length();
        int[][][] dp = new int[m][m][4];
        for (int i = m - 1; i >= 0; --i) {
            for (int j = i; j < m; ++j) {
                for (int k = 0; k < 4; ++k) {
                    char c = (char) ('a' + k);
                    if (j == i) {
                        if (s.charAt(i) == c) {
                            dp[i][j][k] = 1;
                        } else {
                            dp[i][j][k] = 0;
                        }
                    } else if (s.charAt(i) == c && s.charAt(j) == c) { // S[i] == S[j] == c
                        if (j == i + 1) {
                            dp[i][j][k] = 2;
                        } else {
                            dp[i][j][k] = 2;
                            for (int n = 0; n < 4; ++n) {
                                dp[i][j][k] += dp[i + 1][j - 1][n];
                                dp[i][j][k] %= MOD;
                            }
                        }
                    } else {
                        dp[i][j][k] = Math.max(dp[i][j - 1][k], dp[i + 1][j][k]);
                    }

                }
            }
        }
        int ans = 0;
        for (int k = 0; k < 4; ++k) {
            ans += dp[0][m - 1][k];
            ans %= MOD;
        }
        return ans;
    }

}

