package algorithm.dp;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/8/27 上午10:21
 */
public class FindPaths {
    public static void main(String[] args) {

    }

    /**
     * dp[i][j][k]
     *
     * @param m
     * @param n
     * @param maxMove
     * @param startRow
     * @param startColumn
     * @return
     */

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int mod = 1000000007;
        int[][][] dp = new int[maxMove + 1][m][n];
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        dp[0][startRow][startColumn] = 0;
        int result = 0;
        for (int i = 1; i <= maxMove; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    int cnt = dp[i - 1][j][k];
                    if (cnt <= 0) {
                        continue;
                    }
                    for (int[] dir : dirs) {
                        int nx = j + dir[0];
                        int ny = k + dir[1];
                        if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                            result = (result + cnt) % mod;
                        } else {
                            dp[i][j][k] = (dp[i][j][k] + cnt) % mod;
                        }
                    }
                }
            }
        }
        // 出界条件
        //1 r<0, c<0,r>m,c>n;
        return result;
    }
}
