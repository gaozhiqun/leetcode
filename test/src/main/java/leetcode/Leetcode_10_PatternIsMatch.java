package leetcode;


/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/29 下午2:37
 */
public class Leetcode_10_PatternIsMatch {
    public static void main(String[] args) {
        Leetcode_10_PatternIsMatch l = new Leetcode_10_PatternIsMatch();
        System.out.println(l.isMatch("aaa", ".*"));
        System.out.println(l.isMatch("mississippi", "mis*is*p*."));
        System.out.println(l.isMatch("ab", "c*a*b"));
        System.out.println(l.isMatch("ab", ".*"));
        System.out.println(l.isMatch("mississippi", "mis*is*p*"));
        System.out.println(l.isMatch("aa", "a*"));
        System.out.println(l.isMatch("aa", "a"));


    }

    public boolean isMatch(String s, String p) {
        int M = s.length();
        int N = p.length();
        boolean[][] dp = new boolean[M + 1][N + 1];
        dp[0][0] = true;
        for (int i = 0; i <= M; ++i) {
            for (int j = 1; j <= N; ++j) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2]; // *前使用0次
                    if (match(s, p, i, j - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j]; //*前字母使用好1次以上
                    }
                } else {
                    if (match(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[M][N];
    }

    private boolean match(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}