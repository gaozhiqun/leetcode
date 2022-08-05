package algorithm.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/7/2 下午2:58
 */
public class PacificAtlantic {
    public static void main(String[] args) {
        PacificAtlantic pacificAtlantic = new PacificAtlantic();
        List<List<Integer>> result =
                pacificAtlantic.pacificAtlantic(new int[][]{{1, 2, 2, 3, 5},
                        {3, 2, 3, 4, 4},
                        {2, 4, 5, 3, 1},
                        {6, 7, 1, 4, 5},
                        {5, 1, 1, 2, 4},
                });
        System.out.println(result);
    }

    private static int[][] DIRS = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int m = heights.length, n = heights[0].length;
        boolean[][] visited = new boolean[m][n];
        boolean[][] toPacific = new boolean[m][n];
        boolean[][] toAtlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, m, n, heights, visited, toPacific, toAtlantic);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (toAtlantic[i][j] && toPacific[i][j]) {
                    List<Integer> cur = new ArrayList<>();
                    cur.add(i);
                    cur.add(j);
                    result.add(cur);
                }
            }
        }
        return result;
    }

    private void bfs(int i, int j, int m, int n, int[][] heights, boolean[][] visited, boolean[][] toPacific, boolean[][] toAtlantic) {
        visited[i][j] = true;
        if (i == 0 || j == 0) {
            toPacific[i][j] = true;
        }
        if (i == m - 1 || j == n - 1) {
            toAtlantic[i][j] = true;
        }
        for (int[] dirs : DIRS) {
            int newl = i + dirs[0], newr = j + dirs[1];
            if (newl >= 0 && newl < m && newr >= 0 && newr < n && heights[i][j] >= heights[newl][newr]) {
                if (!visited[newl][newr]) {
                    bfs(newl, newr, m, n, heights, visited, toPacific, toAtlantic);
                }
                if (toAtlantic[newl][newr]) {
                    toAtlantic[i][j] = true;
                }
                if (toPacific[newl][newr]) {
                    toPacific[i][j] = true;
                }
            }
        }
    }
}
