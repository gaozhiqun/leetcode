package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/26 下午11:07
 */
public class Leetcode_1092_shortestCommonSupersequence {
    public static void main(String[] args) {
        Leetcode_1092_shortestCommonSupersequence l = new Leetcode_1092_shortestCommonSupersequence();
        System.out.println(l.shortestCommonSupersequence("abac", "cab"));
    }


    public String shortestCommonSupersequence(String str1, String str2) {
        String lcs = lcs(str1, str2);
        return superString(str1, str2, lcs);
    }


    public String lcs(String str1, String str2) {
        // write code here
        if ("".equals(str1) || "".equals(str2)) {
            return "";
        }
        StringBuilder ret = new StringBuilder();
        int m = str1.length(), n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            if (dp[i + 1][j + 1] > 0 && str1.charAt(i) == str2.charAt(j)) {
                ret.append(str1.charAt(i));
                --i;
                --j;
            } else if (dp[i + 1][j] > dp[i][j + 1]) {
                --j;
            } else {
                --i;
            }
        }
        if (ret.length() == 0) {
            return "";
        }
        return ret.reverse().toString();
    }


    private String superString(String s1, String s2, String lcs) {
        int i = 0, j = 0, k = 0;
        StringBuilder ret = new StringBuilder();
        while (i < s1.length() || j < s2.length()) {
            if (k < lcs.length()) {
                if (s1.charAt(i) == lcs.charAt(k) && s2.charAt(j) == lcs.charAt(k)) {
                    ret.append(s1.charAt(i));
                    ++i;
                    ++k;
                    ++j;
                } else if (s1.charAt(i) == lcs.charAt(k)) {
                    ret.append(s2.charAt(j++));
                } else if (s2.charAt(j) == lcs.charAt(k)) {
                    ret.append(s1.charAt(i++));
                } else {
                    ret.append(s1.charAt(i++));
                    ret.append(s2.charAt(j++));
                }
            } else {
                while (i < s1.length()) {
                    ret.append(s1.charAt(i++));
                }
                while (j < s2.length()) {
                    ret.append(s2.charAt(j++));
                }
            }
        }
        return ret.toString();
    }

}
