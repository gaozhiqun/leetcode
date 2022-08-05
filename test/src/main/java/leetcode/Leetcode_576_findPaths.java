package leetcode;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/14 上午10:48
 */
public class Leetcode_576_findPaths {


    public static void main(String[] args) {
        Leetcode_576_findPaths leetcode_560_subarraySum = new Leetcode_576_findPaths();
        // System.out.println(leetcode_560_subarraySum.findPaths(2, 2, 2, 0, 0));
        System.out.println(leetcode_560_subarraySum.findPaths(1, 3, 3, 0, 1));
    }

    final int MOD = 1000_000_007;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int ans = 0;
        int[][] dp = new int[m][n];
        dp[startRow][startColumn] = 1;
        int[] dirs = new int[]{-1, 0, 1, 0, -1};
        for (int move = 0; move < maxMove; move++) {
            int[][] newDp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int d = 0; d < 4; d++) {
                        int ni = i + dirs[d];
                        int nj = j + dirs[d + 1];
                        if (ni < 0 || nj < 0 || ni >= m || nj >= n) {
                            ans = (ans + dp[i][j]) % MOD;
                        } else {
                            newDp[ni][nj] = (newDp[ni][nj] + dp[i][j]) % MOD;
                        }
                    }
                }
            }
            dp = newDp;
        }
        return ans;
    }


}