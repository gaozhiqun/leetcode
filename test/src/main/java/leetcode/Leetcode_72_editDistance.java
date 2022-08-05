package leetcode;


import java.util.LinkedList;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_72_editDistance {

    public static void main(String[] args) {
        Leetcode_72_editDistance l = new Leetcode_72_editDistance();
        System.out.println(l.minDistance("intention", "execution"));
        System.out.println(l.minDistance("horse", "ros"));

        //System.out.println(l.fullJustify(new String[]{"What", "must", "be", "acknowledgment", "shall", "be"}, 16));
        //System.out.println(l.fullJustify(new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}, 20));

    }

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                int distance = word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1;
                dp[i][j] = Math.min(dp[i - 1][j - 1] + distance,
                        Math.min(dp[i - 1][j], dp[i][j - 1]) + 1);
            }
        }
        return dp[m][n];
    }

}
