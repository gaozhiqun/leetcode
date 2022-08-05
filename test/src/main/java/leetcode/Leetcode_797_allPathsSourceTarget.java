package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/1/17 上午10:53
 */
public class Leetcode_797_allPathsSourceTarget {
    public static void main(String[] args) {
        Leetcode_797_allPathsSourceTarget l = new Leetcode_797_allPathsSourceTarget();
    }


    List<List<Integer>> ans;
    private int[][] graph;
    private int N;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ans = new ArrayList<>();
        N = graph.length;
        this.graph = graph;
        boolean[] visited = new boolean[N];
        dfs(0, new ArrayList<>(), visited);
        return ans;
    }

    private void dfs(int i, List<Integer> temp, boolean[] visited) {
        if (i == N - 1) {
            temp.add(i);
            ans.add(new ArrayList<>(temp));
            temp.remove(temp.size() - 1);
            return;
        }
        visited[i] = true;
        temp.add(i);
        for (int next : graph[i]) {
            if (!visited[next]) {
                dfs(next, temp, visited);
            }
        }
        visited[i] = false;
        temp.remove(temp.size() - 1);
    }


}
