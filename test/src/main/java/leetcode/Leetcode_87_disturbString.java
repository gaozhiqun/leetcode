package leetcode;


import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_87_disturbString {

    /**
     * 输入：s1 = "great", s2 = "rgeat""abcdefghijklmnopq"
     * "efghijklmnopqcadb"
     *
     * @param args
     */
    public static void main(String[] args) {
        Leetcode_87_disturbString l = new Leetcode_87_disturbString();
        System.out.println(l.isScramble("great", "rgeat"));
        System.out.println(l.isScramble("abcde", "caebd"));
        System.out.println(l.isScramble("abcdefghijklmnopq", "efghijklmnopqcadb"));
    }

    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        } else if (s1.length() == 1) {
            return s1.charAt(0) == s2.charAt(0);
        }
        int n = s1.length();
        boolean[][][] dp = new boolean[n][n][n + 1];

        /**
         * dp[i][j][len] -> s1 从i->j，s2从k开始长度 j-i+1
         */
        for (int j = 0; j < n; j++) {//第一次循环预处理，找长度为1的扰乱字符串
            for (int k = 0; k < n; k++) {
                if (s1.charAt(j) == s2.charAt(k)) {
                    dp[j][j][k] = true;
                }
            }
        }
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i; j < n; ++j) {
                int len = j - i + 1;
                for (int k = 0; k < n - len + 1; k++) {
                    for (int s = 0; s < len - 1; s++) {
                        if (dp[i][i + s][k] && dp[i + s + 1][j][k + s + 1]
                                || dp[i][i + s][k + len - s - 1] && dp[i + s + 1][j][k]) {
                            dp[i][j][k] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][n - 1][0];
    }


}
