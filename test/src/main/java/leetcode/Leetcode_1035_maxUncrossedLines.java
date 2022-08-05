package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/4/6 下午8:07
 */
public class Leetcode_1035_maxUncrossedLines {
    public static void main(String[] args) {
        Leetcode_1035_maxUncrossedLines l = new Leetcode_1035_maxUncrossedLines();
//        System.out.println(l.maxUncrossedLines(new int[]{1, 4, 2}, new int[]{1, 2, 4}));
//        System.out.println(l.maxUncrossedLines(new int[]{2, 5, 1, 2, 5}, new int[]{10, 5, 2, 1, 5, 2}));
        System.out.println(l.maxUncrossedLines(new int[]{1, 3, 7, 1, 7, 5}, new int[]{1, 9, 2, 5, 1}));
    }


    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int M = nums1.length, N = nums2.length;
        int[][] dp = new int[M + 1][N + 1];
        for (int i = 1; i <= M; ++i) {
            for (int j = 1; j <= N; ++j) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, dp[i][j]);
                }
            }
        }
        return dp[M][N];
    }
}
