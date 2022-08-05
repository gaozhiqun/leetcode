package leetcode;


/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_44_patternIsMatch {

    public static void main(String[] args) {
        Leetcode_44_patternIsMatch l = new Leetcode_44_patternIsMatch();
        System.out.println(l.isMatch("aa", "*"));
        System.out.println(l.isMatch("aa", "a"));
        System.out.println(l.isMatch("cb", "?a"));
        System.out.println(l.isMatch("adceb", "*a*b"));
        System.out.println(l.isMatch("acdcb", "a*c?b"));
    }

    /**
     * '?' 可以匹配任何单个字符。
     * '*' 可以匹配任意字符串（包括空字符串）。
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1];//零次
                    if (i > 0) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j - 1] || dp[i - 1][j]; //一次和多次
                    }
                } else if (i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }
    // * 0次 dp[i+1][j] 多次 dp[i][j]

}
