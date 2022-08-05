package algorithm.astar;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/9 下午2:15
 */
public class SumOfDistancesInTree {
    public static void main(String[] args) {

    }

    int[] dp, sz, ans;
    List<List<Integer>> graph;

    /**
     * dp[u] = dp[v] + sz[v]
     *
     * @param n
     * @param edges
     * @return
     */
    public int[] sumOfDistancesInTress(int n, int[][] edges) {
        dp = new int[n];//dp[u] 表示以u为根的子树，子节点到该节点距离
        sz = new int[n]; // sz[u] 表示以u为根的子树的节点数量
        ans = new int[n]; // ans[u] 表示最后的结果
        graph = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        dfs(0, -1);
        dfs2(0, -1);
        return ans;

    }

    public void dfs(int u, int p) {
        sz[u] = 1;
        dp[u] = 0;
        for (int v : graph.get(u)) {
            if (v == p) {
                continue;
            }
            dp[u] += dp[v];
            sz[u] += sz[v];
        }
    }

    public void dfs2(int u, int p) {
        ans[u] = dp[u];
        for (int v : graph.get(u)) {
            int pu = dp[u], pv = dp[v], su = sz[u], sv = sz[v];

            dp[u] -= dp[v] + sz[v];
            sz[u] -= sz[v];
            dp[v] += dp[u] + sz[u];
            sz[v] += sz[u];

            dfs2(v, u);

            dp[u] = pu;
            dp[v] = pv;
            sz[u] = su;
            sz[v] = sv;

        }

    }


}
