package algorithm.graph;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/14 下午8:01
 */
public class ReachableNodes {
    public static void main(String[] args) {

    }

    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        Queue<int[]> queue = new LinkedList<>();
        List<Edge> edgeList = new ArrayList<>();
        boolean[] reach = new boolean[n];
        reach[0] = true;
        Map<Integer, List<Edge>> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            map.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            Edge edge1 = new Edge(edge[0], edge[1], edge[2]);
            map.get(edge[0]).add(edge1);
            map.get(edge[1]).add(edge1);
            edgeList.add(edge1);
        }
        queue.offer(new int[]{0, maxMoves});
        int ans = 1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int p = cur[0], step = cur[1];
            for (Edge edge : map.get(p)) {
                if (edge.u == p) {
                    if (step > edge.gap) {
                        edge.u2v = edge.gap;
                        if (!reach[edge.v]) {
                            ++ans;
                            reach[edge.v] = true;
                        }
                        queue.offer(new int[]{edge.v, step -= edge.gap + 1});
                    } else {
                        edge.u2v = Math.max(step, edge.u2v);
                    }
                } else {
                    if (step > edge.gap) {
                        edge.v2u = edge.gap;
                        if (!reach[edge.u]) {
                            ++ans;
                            reach[edge.u] = true;
                        }
                        queue.offer(new int[]{edge.u, step -= edge.gap + 1});
                    } else {
                        edge.v2u = Math.max(step, edge.v2u);
                    }
                }
            }
        }
        for (Edge edge : edgeList) {
            ans += Math.min(edge.gap, edge.u2v + edge.v2u);
        }
        return ans;
    }

    public static class Edge {
        int u, v, gap, u2v, v2u;

        public Edge(int u, int v, int gap) {
            this.u = u;
            this.v = v;
            this.gap = gap;
            u2v = 0;
            v2u = 0;
        }
    }
}
