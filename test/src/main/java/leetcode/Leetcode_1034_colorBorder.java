package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/4/6 下午7:44
 */
public class Leetcode_1034_colorBorder {
    public static void main(String[] args) {
        Leetcode_1034_colorBorder l = new Leetcode_1034_colorBorder();
        System.out.println(l.colorBorder(new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}, 1, 1, 2));
    }


    int[][] grid;
    int M, N;
    int[] DIRS = new int[]{-1, 0, 1, 0, -1};
    boolean[][] visited;

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        this.grid = grid;
        M = grid.length;
        N = grid[0].length;
        if (grid[row][col] == color) {
            return grid;
        }
        this.visited = new boolean[M][N];
        bfs(row, col, color, grid[row][col]);
        return grid;
    }

    private void bfs(int i, int j, int color, int p) {
        visited[i][j] = true;
        int m = 0;
        List<int[]> nexts = new ArrayList<>();
        for (int d = 0; d < 4; ++d) {
            int ni = i + DIRS[d], nj = j + DIRS[d + 1];
            if (ni < 0 || nj < 0 || ni > M - 1 || nj > N - 1 || grid[ni][nj] != p) {
                continue;
            }
            ++m;
            if (!visited[ni][nj]) {
                nexts.add(new int[]{ni, nj});
            }
        }
        for (int[] next : nexts) {
            bfs(next[0], next[1], color, p);
        }
        if (m != 4) {
            grid[i][j] = color;
        }

    }


}
