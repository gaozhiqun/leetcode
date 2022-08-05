package algorithm.niuke;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/16 下午2:11
 */
public class LCS {
    public static void main(String[] args) {
        String s1 = "1AB2345CD", s2 = "12345EF";
        LCS lcs = new LCS();
        System.out.println(lcs.LCS(s1, s2));
        System.out.println(lcs.LCS2("1A2C3D4B56", "B1D23A456A"));
        System.out.println(lcs.LCS2("abc", "def"));
        System.out.println(lcs.LCS2("abc", ""));
    }

    public String LCS(String s1, String s2) {
        String ret = "";
        for (int i = 0; i < s1.length(); ++i) {
            for (int j = 0; j < s2.length(); ++j) {
                int k = 0;
                StringBuilder temp = new StringBuilder();
                while (i + k < s1.length() && j + k < s2.length()
                        && s1.charAt(i + k) == s2.charAt(j + k)) {
                    temp.append(s1.charAt(i + k));
                    ++k;
                }
                if (temp.length() > ret.length()) {
                    ret = temp.toString();
                }
            }
        }
        return ret;
    }


    public String LCS2(String str1, String str2) {
        // write code here
        if ("".equals(str1) || "".equals(str2)) {
            return "-1";
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
            return "-1";
        }
        return ret.reverse().toString();
    }


}
