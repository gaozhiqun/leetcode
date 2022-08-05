package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/13 下午3:13
 */
public class Leetcode_417_pacificAtlantic {
    public static void main(String[] args) {

    }

    int m, n;
    int[][] heights;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        this.heights = heights;
        int[][] pacific = new int[m][n];
        int[][] atlantic = new int[m][n];
        for (int i = 0; i < m; i++) {
            bfs(i, 0, pacific);
            bfs(i, n - 1, atlantic);
        }
        for (int j = 0; j < n; ++j) {
            bfs(0, j, pacific);
            bfs(m - 1, j, atlantic);
        }
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (pacific[i][j] == 1 && atlantic[i][j] == 1) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }

    private void bfs(int i, int j, int[][] reach) {
        reach[i][j] = 1;
        int[] dirs = new int[]{-1, 0, 1, 0, -1};
        for (int d = 0; d < 4; d++) {
            int nx = i + dirs[d];
            int ny = j + dirs[d + 1];
            if (nx >= 0 && ny >= 0 && nx < m && ny < n
                    && reach[nx][ny] == 0 && heights[nx][ny] >= heights[i][j]) {
                bfs(nx, ny, reach);
            }
        }
    }

}
