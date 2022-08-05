package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/10 上午11:24
 */
public class Leetcode_407_trapWater {
    public static void main(String[] args) {
        Leetcode_407_trapWater l = new Leetcode_407_trapWater();

    }

    int m, n;
    int[][] heightMap;
    boolean[][] visited;


    public int trapRainWater(int[][] heightMap) {
        m = heightMap.length;
        n = heightMap[0].length;
        this.heightMap = heightMap;
        this.visited = new boolean[m][n];
        if (m < 3 || n < 3) {
            return 0;
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    queue.offer(new int[]{i * n + j, heightMap[i][j]});
                    visited[i][j] = true;
                }
            }
        }
        int res = 0;
        int[] dirs = {-1, 0, 1, 0, -1};
        //自外往内更新
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int k = 0; k < 4; ++k) {
                int nx = curr[0] / n + dirs[k];
                int ny = curr[0] % n + dirs[k + 1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                    if (curr[1] > heightMap[nx][ny]) {
                        res += curr[1] - heightMap[nx][ny];
                    }
                    queue.offer(new int[]{nx * n + ny, Math.max(heightMap[nx][ny], curr[1])});
                    visited[nx][ny] = true;
                }
            }
        }
        return res;
    }
}



