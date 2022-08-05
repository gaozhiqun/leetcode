package leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_97_isInterLeave {

    /**
     * 10
     */

    /**
     * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
     * 输出：true
     * 示例 2：
     * <p>
     * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
     * 输出：false
     * 示例 3：
     * <p>
     * 输入：s1 = "", s2 = "", s3 = ""
     * 输出：true
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/interleaving-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        Leetcode_97_isInterLeave l = new Leetcode_97_isInterLeave();
        System.out.println(l.isInterleaveDp("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(l.isInterleaveDp("aabcc", "dbbca", "aadbbbaccc"));
        System.out.println(l.isInterleaveDp("", "", ""));
    }

    public boolean isInterleaveDp(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length(), l = s3.length();
        if (m + n != l) {
            return false;
        }
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; ++j) {
                if (i > 0 && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j];
                }
                if (j > 0 && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = dp[i][j] || dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length(), l = s3.length();
        if (m + n != l) {
            return false;
        }
        if ("".equals(s1)) {
            return s2.equals(s3);
        } else if ("".equals(s2)) {
            return s1.equals(s3);
        }
        return dfs(s1, s2, s3, 0, 0);

    }

    private boolean dfs(String s1, String s2, String s3, int i, int j) {
        if (i > s1.length() || j > s2.length()) {
            return false;
        }
        if (i + j == s3.length()) {
            return true;
        }
        if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j) && dfs(s1, s2, s3, i + 1, j)) {
            return true;
        }
        if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j) && dfs(s1, s2, s3, i, j + 1)) {
            return true;
        }
        return false;
    }
}
