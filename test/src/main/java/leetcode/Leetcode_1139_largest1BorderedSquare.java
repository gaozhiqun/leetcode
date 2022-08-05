package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/27 下午8:34
 */
public class Leetcode_1139_largest1BorderedSquare {

    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m+1][n+1][2];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (grid[i-1][j-1] == 1){
                    dp[i][j][0] = 1 + dp[i][j-1][0];
                    dp[i][j][1] = 1 + dp[i-1][j][1];
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int side = Math.min(dp[i][j][0], dp[i][j][1]); side >= 1; side--){
                    if (dp[i][j-side+1][1] >= side && dp[i-side+1][j][0] >= side){
                        res = Math.max(res, side);
                        break;
                    }
                }
            }
        }
        return res * res;
    }

}
