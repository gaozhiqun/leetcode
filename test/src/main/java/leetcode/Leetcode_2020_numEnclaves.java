package leetcode;

import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/4/2 上午10:50
 */
public class Leetcode_2020_numEnclaves {
    public static void main(String[] args) {
        Leetcode_2020_numEnclaves l = new Leetcode_2020_numEnclaves();
        System.out.println(l.numEnclaves(new int[][]{
                {0, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}
        }));
        System.out.println(l.numEnclaves(new int[][]{
                {0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}
        }));

    }

    private static int[] DIRS = new int[]{-1, 0, 1, 0, -1};
    int M, N;
    int[][] grid;

    public int numEnclaves(int[][] grid) {
        this.grid = grid;
        this.M = grid.length;
        this.N = grid[0].length;
        for (int i = 0; i < M; ++i) {
            if (grid[i][0] == 1) {
                bfs(i, 0);
            }
            if (grid[i][N - 1] == 1) {
                bfs(i, N - 1);
            }

        }
        for (int j = 0; j < N; ++j) {
            if (grid[0][j] == 1) {
                bfs(0, j);
            }
            if (grid[M - 1][j] == 1) {
                bfs(M - 1, j);
            }
        }
        int ret = 0;
        for (int[] col : grid) {
            ret += Arrays.stream(col).sum();
        }
        return ret;
    }


    private void bfs(int i, int j) {
        grid[i][j] = 0;
        for (int d = 0; d < 4; ++d) {
            int ni = i + DIRS[d], nj = j + DIRS[d + 1];
            if (ni < 0 || nj < 0 || ni > M - 1 || nj > N - 1 || grid[ni][nj] == 0) {
                continue;
            }
            bfs(ni, nj);
        }
    }




}
