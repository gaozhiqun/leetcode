package leetcode;


import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_639 {

    public static void main(String[] args) {
        Leetcode_639 l = new Leetcode_639();
        System.out.println(l.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));

        System.out.println(l.countSubstrings("aaa"));
        System.out.println(l.numDecodings("2*"));
        System.out.println(l.solveEquation("x+5-3+x=6+x-2"));
        System.out.println(l.solveEquation("x=x"));
        System.out.println(l.solveEquation("2x=x"));
        System.out.println(l.solveEquation("2x+3x-6x=x+2"));
        System.out.println(l.solveEquation("x=x+2"));
        System.out.println(l.solveEquation("x+5-3+x=6+x-2"));

    }

    static final int MOD = 1000000007;

    public int numDecodings(String s) {
        int n = s.length();
        long[] dp = new long[n + 1];
        dp[0] = 1;
        // a = f[i-2], b = f[i-1], c = f[i]
        for (int i = 1; i <= n; ++i) {
            dp[i] = dp[i - 1] * check1digit(s.charAt(i - 1)) % MOD;
            if (i > 1) {
                dp[i] = (dp[i] + dp[i - 2] * check2digits(s.charAt(i - 2), s.charAt(i - 1))) % MOD;
            }
        }
        return (int) dp[n];
    }

    public int check1digit(char ch) {
        if (ch == '0') {
            return 0;
        }
        return ch == '*' ? 9 : 1;
    }

    public int check2digits(char c0, char c1) {
        if (c0 == '*' && c1 == '*') {
            return 15;
        }
        if (c0 == '*') {
            return c1 <= '6' ? 2 : 1;
        }
        if (c1 == '*') {
            if (c0 == '1') {
                return 9;
            }
            if (c0 == '2') {
                return 6;
            }
            return 0;
        }
        return (c0 != '0' && (c0 - '0') * 10 + (c1 - '0') <= 26) ? 1 : 0;
    }

    public String solveEquation(String equation) {
        int lxc = 0, ldc = 0, rxc = 0, rdc = 0;
        String[] parts = equation.split("=");
        int[] lp = cal(parts[0]);
        int[] rp = cal(parts[1]);
        lxc = lp[0];
        ldc = lp[1];
        rxc = rp[0];
        rdc = rp[1];
        if (lxc == rxc) {
            if (ldc == rdc) {
                return "Infinite solutions";
            } else {
                return "No solution";
            }
        }
        return ("x=" + (rdc - ldc) / (lxc - rxc));
    }

    private int[] cal(String e) {
        int xc = 0, dc = 0;
        int digit = 0, base = 1;
        for (int i = 0; i < e.length(); i++) {
            char ch = e.charAt(i);
            if (Character.isDigit(ch)) {
                digit = digit * 10 + (ch - '0');
            } else if ('x' == ch) {
                if (i == 0 || !Character.isDigit(e.charAt(i - 1))) {
                    digit = 1;
                }
                xc += (digit * base);
                digit = 0;
                base = 1;
            } else if ('+' == ch) {
                dc += (digit * base);
                digit = 0;
                base = 1;
            } else if ('-' == ch) {
                dc += (digit * base);
                digit = 0;
                base = -1;
            }
        }
        if (digit > 0) {
            dc += (digit * base);
        }
        return new int[]{xc, dc};
    }

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> {
            return a[0] - b[0];
        });
        int m = pairs.length;
        int[] dp = new int[m];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; ++i) {
            for (int j = 0; j < i; ++j) {
                if (pairs[j][1] < pairs[i][0]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public int findLongestChain2(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int rmax = Integer.MIN_VALUE, ans = 0;
        for (int[] pair : pairs) {
            if (rmax < pair[0]) {
                rmax = pair[1];
                ans++;
            }
        }
        return ans;
    }

    public int countSubstrings(String s) {
        int m = s.length();
        int dp[][] = new int[m][m];
        int ret = 0;
        for (int i = 0; i < m; ++i) {
            dp[i][i] = 1;
            ++ret;
        }
        for (int r = 1; r < m; r++) {
            for (int l = r - 1; l >= 0; --l) {
                if (s.charAt(l) == s.charAt(r)) {
                    if (l == r - 1) {
                        dp[l][r] = 1;
                    } else {
                        dp[l][r] = dp[l + 1][r - 1];
                    }
                    ret += dp[l][r];
                }
            }
        }
        return ret;
    }

    public int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }


}