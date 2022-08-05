package algorithm.dp;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/4/23 8:08 下午
 */
public class UnderGroundGame {
    public static void main(String[] args) {

    }


    public int calculateMinimumLife(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        dp[m][n - 1] = dp[m - 1][n] = 1;
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                int min = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(min - matrix[i][j], 1);
            }
        }
        return dp[0][0];
    }
}
