package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/4/7 上午11:16
 */
public class Leetcode_1039_minScoreTriangulation {
    public static void main(String[] args) {
        Leetcode_1039_minScoreTriangulation l = new Leetcode_1039_minScoreTriangulation();
        System.out.println(l.minScoreTriangulation(new int[]{1, 3, 1, 4, 1, 5}));
        System.out.println(l.minScoreTriangulation(new int[]{3, 7, 4, 5}));
    }

    /**
     * dp[i][j] i->j 序列的最低分，m表示将i，j连接起来时，最低分
     *
     * @param A
     * @return
     */

    public int minScoreTriangulation(int[] A) {
        int N = A.length;
        int[][] dp = new int[N][N];
        for (int i = N - 3; i >= 0; --i) {
            for (int j = i + 2; j < N; ++j) {
                for (int m = i + 1; m < j; m++) {
                    if (dp[i][j] == 0) {
                        dp[i][j] = A[i] * A[j] * A[m] + dp[i][m] + dp[m][j];
                    } else {
                        dp[i][j] = Math.min(dp[i][j], A[i] * A[j] * A[m] + dp[i][m] + dp[m][j]);
                    }
                }
            }
        }
        return dp[0][N - 1];
    }
}
