package leetcode;


import algorithm.tree.TreeNode;

import java.util.Map;
import java.util.Stack;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/5 下午2:42
 */
public class Leetcode_174_calculateMinHp {

    public static void main(String[] args) {
        Leetcode_174_calculateMinHp l = new Leetcode_174_calculateMinHp();
        System.out.println(l.calculateMinimumHP(new int[][]{
                {-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}
        }));
        System.out.println(l.calculateMinimumHP(new int[][]{
                {-3, 5}
        }));
    }

    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        if (m == 1 && n == 1) {
            return 1 - Math.min(0, dungeon[0][0]);
        }
        int dp[][] = new int[m][n];
        for (int j = n - 1; j >= 0; --j) {
            for (int i = m - 1; i >= 0; --i) {
                if (i == m - 1 && j == n - 1) {
                    dp[i][j] = Math.max(1, 1 - dungeon[i][j]);
                } else if (j == n - 1) {
                    dp[i][j] = Math.max(1, dp[i + 1][j] - dungeon[i][j]);
                } else if (i == m - 1) {
                    dp[i][j] = Math.max(1, dp[i][j + 1] - dungeon[i][j]);
                } else {
                    dp[i][j] = Math.max(1, Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]);
                }
            }
        }
        return dp[0][0];
    }

}