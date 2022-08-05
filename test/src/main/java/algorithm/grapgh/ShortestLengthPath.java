package algorithm.grapgh;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/9 下午7:27
 */
public class ShortestLengthPath {
    public static void main(String[] args) {

    }

    /**
     * 不能成环
     *
     * @param graph
     * @return
     */

    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] seen = new boolean[n][1 << n];
        for (int i = 0; i < n; ++i) {
            queue.offer(new int[]{i, 1 << i, 0});
            seen[i][1 << i] = true;
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            int[] tuple = queue.poll();
            int u = tuple[0], mask = tuple[1], dist = tuple[2];
            if (mask == (1 << n) - 1) {
                ans = dist;
                break;
            }
            for (int v : graph[u]) {
                int maskv = mask | (1 << u);
                if (!seen[v][maskv]) {
                    queue.offer(new int[]{v, mask, dist + 1});
                    seen[v][maskv] = true;
                }
            }
        }
        return ans;
    }
}
