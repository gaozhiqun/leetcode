package algorithm.bfs;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/9/2 下午1:52
 */
public class FindRedundantConnection {
    public static void main(String[] args) {
        FindRedundantConnection findRedundantConnection = new FindRedundantConnection();
        System.out.println(findRedundantConnection.findRedundantConnection(new int[][]{
                {1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}
        }));
    }

    public int[] findRedundantConnection(int[][] edges) {
        int m = edges.length;
        int[] parent = new int[m + 1];
        for (int i = 0; i < m; ++i) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            if (find(a, parent) != find(b, parent)) {
                union(a, b, parent);
            } else {
                return edge;
            }
        }
        return new int[0];
    }

    private void union(int i, int j, int[] array) {
        int a = find(i, array);
        int b = find(j, array);
        if (a != b) {
            array[b] = a;
        }
    }

    private int find(int i, int[] array) {
        int cur = i;
        while (array[cur] != cur) {
            cur = array[cur];
        }
        return cur;
    }
}
