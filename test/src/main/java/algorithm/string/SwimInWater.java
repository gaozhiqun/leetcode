package algorithm.string;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/9/17 上午11:49
 */
public class SwimInWater {
    public static void main(String[] args) {

    }

    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int swimInWater(int[][] grid) {
        int result = 0;
        int m = grid.length;
        boolean[][] visited = new boolean[m][m];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return grid[o1[0]][o1[1]] - grid[o2[0]][o2[1]];
            }
        });
        priorityQueue.offer(new int[]{0, 0});
        visited[0][0] = true;
        while (!priorityQueue.isEmpty()) {
            int[] peek = priorityQueue.poll();
            result = Math.max(result, grid[peek[0]][peek[1]]);
            if (peek[0] == m - 1 && peek[1] == m - 1) {
                return result;
            }
            for (int[] dir : dirs) {
                int nx = peek[0] + dir[0], ny = peek[1] + dir[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < m && !visited[nx][ny]) {
                    priorityQueue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        return -1;
    }
}
