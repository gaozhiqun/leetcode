package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/3/22 下午8:56
 */
public class Leetcode_934_shortestBridge {
    public static void main(String[] args) {
        Leetcode_934_shortestBridge l = new Leetcode_934_shortestBridge();
        System.out.println(l.shortestBridge(new int[][]{
                {1, 1, 1, 1, 1}, {1, 0, 0, 0, 1}, {1, 0, 1, 0, 1}, {1, 0, 0, 0, 1}, {1, 1, 1, 1, 1}
        }));
    }

    int N;
    int[][] grid;
    int[] dir = new int[]{-1, 0, 1, 0, -1};

    public int shortestBridge(int[][] grid) {
        this.N = grid.length;
        this.grid = grid;
        int color = 2;
        Queue<Integer> queue = new LinkedList<>();
        outter:
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (grid[i][j] == 1) {
                    bfs(i, j, color, queue);
                    break outter;
                }
            }
        }
        int ret = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int c = 0; c < size; ++c) {
                int m = queue.poll();
                int i = m / N;
                int j = m % N;
                for (int d = 0; d < 4; ++d) {
                    int ni = i + dir[d], nj = j + dir[d + 1];
                    if (ni < 0 || nj < 0 || ni >= N || nj >= N) {
                        continue;
                    }
                    if (grid[ni][nj] == 1) {
                        return ret;
                    } else if (grid[ni][nj] == 0) {
                        queue.offer(ni * N + nj);
                        grid[ni][nj] = 2;
                    }
                }
            }
            ++ret;
        }
        return -1;
    }

    private void bfs(int i, int j, int color, Queue<Integer> queue) {
        grid[i][j] = color;
        queue.offer(i * N + j);
        for (int d = 0; d < 4; ++d) {
            int ni = i + dir[d], nj = j + dir[d + 1];
            if (ni < 0 || nj < 0 || ni >= N || nj >= N || grid[ni][nj] != 1) {
                continue;
            }
            bfs(ni, nj, color, queue);
        }
    }


}
