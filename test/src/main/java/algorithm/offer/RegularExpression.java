package algorithm.offer;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/6/3 4:20 下午
 */
public class RegularExpression {
    public static void main(String[] args) {
        RegularExpression regularExpression = new RegularExpression();
//        System.out.println(regularExpression.isMatch("aaa", "ab*ac*a"));
//        System.out.println(regularExpression.isMatch("aaa", "a"));
        System.out.println(regularExpression.isMatch("ab", ".*"));

    }

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

}
