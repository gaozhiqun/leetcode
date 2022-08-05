package algorithm.bfs;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/9/10 下午5:11
 */
public class CherryPick {
    public static void main(String[] args) {
        CherryPick cherryPick = new CherryPick();
        System.out.println(cherryPick.cherryPick(new int[][]{{0, 1, -1}, {1, 0, -1}, {1, 1, 1}}));
    }

    /**
     * 一共走m+n-2步，假设两个人分别走，走到同一点是时候，结果相加
     * dp[c1][c2] = (0,0)->(r1,c1) (0,0)->(r2,c2)
     *
     * @param grid
     * @return
     */
    public int cherryPick(int[][] grid) {
        int m = grid.length;
        int[][] dp = new int[m][m];
        for (int[] ar : dp) {
            Arrays.fill(ar, Integer.MIN_VALUE);
        }
        for (int t = 1; t < 2 * m - 2; t++) {
            int[][] dp2 = new int[m][m];
            for (int[] ar : dp) {
                Arrays.fill(ar, Integer.MIN_VALUE);
            }

            /**
             * 在第i步时两个人分别获得了多少樱桃.
             */
            for (int i = 0; i < Math.min(t, m - 1); i++) {
                for (int j = 0; j < Math.min(j, m - 1); j++) {
                    if (grid[i][t - i] == -1 || grid[j][t - j] == -1) {
                        continue;
                    }
                    int res = grid[i][t - i];
                    if (i != j) {
                        res += grid[j][t - j];
                    }
                    for (int pi = i - 1; pi <= i; pi++) {
                        for (int pj = j - 1; pj <= j; pj++) {
                            if (pi >= 0 && pj >= 0) {
                                dp2[i][j] = Math.max(dp[pi][pj] + res, dp2[i][j]);
                            }

                        }
                    }
                }
            }
            dp = dp2;
        }
        return dp[m - 1][m - 1];
    }
}
