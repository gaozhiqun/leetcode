package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/2/21 下午4:33
 */
public class Leetcode_882_reachableNodes {
    public static void main(String[] args) {
        Leetcode_882_reachableNodes l = new Leetcode_882_reachableNodes();
        System.out.println(l.reachableNodes(new int[][]{{}}, 6, 3));
    }

    public int reachableNodes(int[][] edges, int M, int N) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph.computeIfAbsent(u, x -> new HashMap()).put(v, w);
            graph.computeIfAbsent(v, x -> new HashMap()).put(u, w);
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });
        //按照与0点的距离排序
        int ret = 0;
        Map<Integer, Integer> distanceMap = new HashMap<>();
        Map<Integer, Integer> edgeMap = new HashMap<>();
        distanceMap.put(0, 0);
        priorityQueue.offer(new int[]{0, 0});
        while (!priorityQueue.isEmpty()) {
            int[] cur = priorityQueue.poll();
            int n = cur[0], d = cur[1];
            if (d > distanceMap.getOrDefault(n, 0)) {
                continue;
            }
            ++ret;
            if (!graph.containsKey(n)) {
                continue;
            }
            for (int nei : graph.get(n).keySet()) {
                int weight = graph.get(n).get(nei);
                int v = Math.min(weight, M - d);
                edgeMap.put(n * N + nei, v);
                int d2 = d + weight + 1;
                if (d2 < distanceMap.getOrDefault(nei, M + 1)) {
                    priorityQueue.offer(new int[]{nei, d2});
                    distanceMap.put(nei, d2);
                }
            }
        }
        for (int[] edge : edges) {
            ret += Math.min(edge[2], edgeMap.getOrDefault(edge[0] * N + edge[1], 0) +
                    edgeMap.getOrDefault(edge[1] * N + edge[0], 0));
        }
        return ret;
    }
}
