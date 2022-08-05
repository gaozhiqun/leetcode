package leetcode;


import algorithm.tree.TreeNode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/14 上午10:48
 */
public class Leetcode_516_longestPalindromeSubseq {


    public static void main(String[] args) {
        Leetcode_516_longestPalindromeSubseq l = new Leetcode_516_longestPalindromeSubseq();
        System.out.println(l.longestPalindromeSubseq("bbbab"));
        System.out.println(l.longestPalindromeSubseq("cbbd"));
    }

    public int longestPalindromeSubseq(String s) {
        int m = s.length();
        int[][] dp = new int[m][m];
        for (int i = 0; i < m; i++) {
            dp[i][i] = 1;
        }
        for (int j = 1; j < m; ++j) {
            for (int i = j - 1; i >= 0; --i) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                if (s.charAt(i) == s.charAt(j)) {
                    if (i == j - 1) {
                        dp[i][j] = 2;
                    } else {
                        dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - 1] + 2);
                    }
                }
            }
        }
        return dp[0][m - 1];
    }
}