package leetcode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/1/27 下午2:48
 */
public class Leetcode_847_shortestPathLength {
    public static void main(String[] args) {
        Leetcode_847_shortestPathLength l = new Leetcode_847_shortestPathLength();
        System.out.println(l.shortestPathLength(new int[][]{
                {1, 2, 3}, {0}, {0}, {0}
        }));
        System.out.println(l.shortestPathLength(new int[][]{
                {1}, {0, 2, 4}, {1, 2, 4}, {2}, {1, 2}
        }));
    }

    int M;

    public int shortestPathLength(int[][] graph) {
        int M = graph.length;
        int size = 1 << M;
        int MASK = size - 1;
        boolean[][] seen = new boolean[M][size];
        LinkedList<int[]> queue = new LinkedList<>();
        for (int i = 0; i < M; ++i) {
            queue.offer(new int[]{i, 1 << i, 0});
            seen[i][1 << i] = true;
        }
        while (!queue.isEmpty()) {
            int[] tuple = queue.poll();
            int i = tuple[0], s = tuple[1], dist = tuple[2];
            if (s == MASK) {
                return dist;
            }
            for (int j : graph[i]) {
                int sn = s | (1 << j);
                if (!seen[j][sn]) {
                    queue.offer(new int[]{j, sn, dist + 1});
                    seen[j][sn] = true;
                }
            }
        }
        return 0;
    }


}
