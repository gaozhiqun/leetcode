package leetcode;


import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/5 下午2:42
 */
public class Leetcode_200_numIslands {

    public static void main(String[] args) {
        Leetcode_200_numIslands l = new Leetcode_200_numIslands();
        System.out.println(l.numIslands(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        }));
    }

    int[] v = new int[]{-1, 1, 0, 0};
    int[] h = new int[]{0, 0, 1, -1};


    public int numIslands(char[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        int ans = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    bfs(i, j, grid, visited);
                    ++ans;
                }
            }
        }
        return ans;
    }

    private void bfs(int i, int j, char[][] grid, boolean[][] visited) {
        visited[i][j] = true;
        for (int d = 0; d < 4; ++d) {
            int ni = i + h[d];
            int nj = j + v[d];
            if (ni >= 0 && nj >= 0 && ni < grid.length && nj < grid[0].length
                    && !visited[ni][nj] && grid[ni][nj] == '1') {
                bfs(ni, nj, grid, visited);
            }
        }
    }


}