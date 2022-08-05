package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_695_maxAreaOfIsland {

    public static void main(String[] args) {
        Leetcode_695_maxAreaOfIsland l = new Leetcode_695_maxAreaOfIsland();
        /**
         * [2,2,2,2,3,4,5]
         * 4
         */
    }

    int m, n;
    int[][] grid;
    int[] dirs = new int[]{-1, 0, 1, 0, -1};

    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    ans = Math.max(ans, bfs(i, j));
                }
            }
        }
        return ans;
    }

    private int bfs(int i, int j) {
        int ret = 1;
        grid[i][j] = 0;
        for (int d = 0; d < 4; ++d) {
            int ni = i + dirs[d], nj = j + dirs[d + 1];
            if (ni >= 0 && nj >= 0 && ni < m && nj < n && grid[ni][nj] == 1) {
                ret += bfs(ni, nj);
            }
        }
        return ret;
    }





}