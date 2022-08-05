package algorithm;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/15 下午3:35
 */
public class MiniSpanningTree {
    public static void main(String[] args) {
        MiniSpanningTree miniSpanningTree = new MiniSpanningTree();


        System.out.println(miniSpanningTree.miniSpanningTree(6, 10, new int[][]{
                {5, 3, 8}, {1, 3, 6}, {2, 5, 4}, {2, 3, 5}, {4, 5, 6}, {3, 4, 3}, {2, 4, 8}, {1, 2, 2}, {1, 4, 5}, {5, 6, 2}
        }));

        System.out.println(miniSpanningTree.miniSpanningTree(3, 3, new int[][]{
                {1, 3, 3}, {1, 2, 1}, {2, 3, 1}
        }));
        System.out.println(miniSpanningTree.miniSpanningTree(2, 1, new int[][]{
                {1, 2, 1}
        }));

    }

    public int miniSpanningTree(int n, int m, int[][] cost) {
        Set<Integer> visited = new HashSet<>();
        Map<Integer, List<int[]>> nbMap = new HashMap<>();
        int[] seed = cost[0];
        for (int[] edge : cost) {
            if (seed[2] > edge[2]) {
                seed = edge;
            }
            nbMap.computeIfAbsent(edge[0], f -> new ArrayList<>()).add(edge);
            nbMap.computeIfAbsent(edge[1], f -> new ArrayList<>()).add(edge);
        }
        int ret = 0;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        priorityQueue.offer(seed);
        while (!priorityQueue.isEmpty()) {
            int[] edge = priorityQueue.poll();
            if (visited.contains(edge[0]) && visited.contains(edge[1])) {
                continue;
            }
            ret += edge[2];
            visited.add(edge[0]);
            visited.add(edge[1]);
            for (int[] nbEdge : nbMap.get(edge[0])) {
                if (nbEdge[1] == edge[0] && !visited.contains(nbEdge[0])
                        || nbEdge[0] == edge[0] && !visited.contains(nbEdge[1])) {
                    priorityQueue.offer(nbEdge);
                }
            }
            for (int[] nbEdge : nbMap.get(edge[1])) {
                if (nbEdge[1] == edge[1] && !visited.contains(nbEdge[0])
                        || nbEdge[0] == edge[1] && !visited.contains(nbEdge[1])) {
                    priorityQueue.offer(nbEdge);
                }
            }
        }

        return ret;
    }


}
