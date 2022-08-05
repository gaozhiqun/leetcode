package algorithm.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/28 下午4:49
 */
public class OrangesRotting {

    int[][] DIR = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        OrangesRotting orangesRotting = new OrangesRotting();
        System.out.println(orangesRotting.orangesRotting(new int[][]{
                {2, 1, 1}, {1, 1, 0}, {0, 1, 1}
        }));
    }

    /**
     * 1<=grid.length<10
     *
     * @param grid
     * @return
     */
    public int orangesRotting(int[][] grid) {
        int M = grid.length, N = grid[0].length;
        int ans = 0, g = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < M; ++i) {
            for (int j = 0; j < N; ++j) {
                if (grid[i][j] == 1) {
                    ++g;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty() && g > 0) {
            ++ans;
            for (int i = 0; i < queue.size(); i++) {
                int[] next = queue.poll();
                for (int[] dir : DIR) {
                    int ni = next[0] + dir[0], nj = next[1] + dir[1];
                    if (ni >= 0 && ni < M && nj >= 0 && nj < N && grid[ni][nj] == 1) {
                        queue.offer(new int[]{ni, nj});
                        grid[ni][nj] = 2;
                        --g;
                    }
                }
            }
        }
        return g == 0 ? ans : -1;
    }

}
