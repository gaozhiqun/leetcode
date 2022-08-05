package algorithm.niuke;

import java.util.ArrayList;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/19 上午11:58
 */
public class MaxRectangle {


    public int solve(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int ret = 0;
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j],
                            Math.min(dp[i - 1][j - 1],
                                    dp[i][j - 1])) + 1;
                    ret = Math.max(ret, dp[i][j]);
                }
            }
        }
        return ret * ret;
    }

    ArrayList<String> ret;

    public ArrayList<String> restoreIpAddresses(String s) {
        // write code here
        ret = new ArrayList<>();
        dfs(new StringBuilder(), 0, 0, s);
        return ret;
    }

    private void dfs(StringBuilder sb, int dc, int i, String s) {
        if (i == s.length() && dc == 4) {
            sb.deleteCharAt(sb.length() - 1);
            ret.add(sb.toString());
            return;
        } else if (i >= s.length()) {
            return;
        }
        int digit = 0;
        int curLen = sb.length();
        if (s.charAt(i) == '0') {
            //special case
            sb.append(s.charAt(i));
            sb.append('.');
            dfs(sb, dc + 1, i + 1, s);
        } else {
            for (int k = i; k < s.length(); ++k) {
                digit = digit * 10 + (s.charAt(k) - '0');
                if (digit < 256) {
                    sb.append(digit);
                    sb.append('.');
                    dfs(sb, dc + 1, k + 1, s);
                    while (sb.length() > curLen) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        MaxRectangle maxRectangle = new MaxRectangle();
        System.out.println(maxRectangle.restoreIpAddresses("000256"));
        System.out.println(maxRectangle.restoreIpAddresses("25525522135"));
        System.out.println(maxRectangle.restoreIpAddresses("1111"));
    }


}
