package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_311_minHeightTree {

    public static void main(String[] args) {
        Leetcode_311_minHeightTree l = new Leetcode_311_minHeightTree();
        System.out.println(l.findMinHeightTrees(6, new int[][]{
                {3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}
        }));

    }

    int n;
    int min;
    private List<List<Integer>> neighbors;
    private List<Integer> ans;


    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        this.n = n;
        this.min = n;
        this.neighbors = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            neighbors.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            neighbors.get(edge[0]).add(edge[1]);
            neighbors.get(edge[1]).add(edge[0]);
        }
        this.ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            int depth = dfs(i);
            if (depth <= min) {
                if (depth < min) {
                    min = depth;
                    ans = new ArrayList<>();
                }
                ans.add(i);
            }
        }
        return ans;
    }

    private int dfs(int cur) {
        int depth = 0;
        Set<Integer> set = new HashSet<>();
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(cur);
        set.add(cur);
        while (!list.isEmpty()) {
            int size = list.size();
            ++depth;
            for (int i = 0; i < size; ++i) {
                int peek = list.pollFirst();
                for (int next : neighbors.get(peek)) {
                    if (!set.contains(next)) {
                        set.add(next);
                        list.addLast(next);
                    }
                }
            }
        }
        return depth;
    }

    public List<Integer> findMinHeightTrees2(int n, int[][] edges) {
        List<List<Integer>> neighbors = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int[] degrees = new int[n];
        for (int i = 0; i < n; ++i) {
            neighbors.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            neighbors.get(edge[0]).add(edge[1]);
            neighbors.get(edge[1]).add(edge[0]);
            degrees[edge[0]]++;
            degrees[edge[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; ++i) {
            if (degrees[i] == 1) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            ans = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int cur = queue.poll();
                ans.add(cur);
                for (int next : neighbors.get(cur)) {
                    degrees[next]--;
                    if (degrees[next] == 1) {
                        queue.offer(next);
                    }
                }
            }
        }
        return ans;
    }


}