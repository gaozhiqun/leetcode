package leetcode;


/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_62_differentPaths {

    public static void main(String[] args) {
        Leetcode_62_differentPaths l = new Leetcode_62_differentPaths();
        System.out.println(l.uniquePaths(3, 7));
        System.out.println(l.uniquePaths(3, 2));
        System.out.println(l.uniquePaths(7, 3));
        System.out.println(l.uniquePaths(3, 3));
        System.out.println(l.uniquePathsWithObstacles(new int[][]{
                {0, 0, 0}, {0, 1, 0}, {0, 0, 0}
        }));
        System.out.println(l.uniquePathsWithObstacles(new int[][]{
                {0, 1}, {0, 0}
        }));

        System.out.println(l.minPathSum(new int[][]{
                {1, 3, 1}, {1, 5, 1}, {4, 2, 1}
        }));


    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                }
                if (i > 0) {
                    dp[i][j] += dp[i - 1][j];
                }
                if (j > 0) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = -1;
                    if (i == m - 1 && j == n - 1) {
                        obstacleGrid[i][j] = 0;
                    }
                    continue;
                }
                if (i == 0 && j == 0) {
                    obstacleGrid[i][j] = 1;
                }
                if (i > 0 && obstacleGrid[i - 1][j] >= 0) {
                    obstacleGrid[i][j] += obstacleGrid[i - 1][j];
                }
                if (j > 0 && obstacleGrid[i][j - 1] >= 0) {
                    obstacleGrid[i][j] += obstacleGrid[i][j - 1];
                }
            }
        }
        return obstacleGrid[m - 1][n - 1];
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i > 0 && j > 0) {
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                } else if (i > 0) {
                    grid[i][j] += grid[i - 1][j];
                } else if (j > 0) {
                    grid[i][j] += grid[i][j - 1];
                }
            }
        }
        return grid[m - 1][n - 1];
    }


}
