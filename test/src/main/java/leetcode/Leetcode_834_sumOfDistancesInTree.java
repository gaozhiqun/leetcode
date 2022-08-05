package leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_834_sumOfDistancesInTree {

    public static void main(String[] args) {
        Leetcode_834_sumOfDistancesInTree l = new Leetcode_834_sumOfDistancesInTree();
        System.out.println(l.sumOfDistancesInTree(6, new int[][]{
                {0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}
        }));
//        System.out.println(l.largestIsland(new int[][]{{1, 1}, {1, 1}}));
    }

    /**
     * 两次DFS进行换底
     */
    int[] ans;
    int[] sz;
    int[] dp;
    List<Integer>[] graph;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        ans = new int[n];
        sz = new int[n];
        dp = new int[n];
        graph = new List[n];
        for (int i = 0; i < n; ++i) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        dfs(0, -1);
        dfs2(0, -1);
        return ans;
    }

    public void dfs(int u, int f) {
        sz[u] = 1;
        dp[u] = 0;
        for (int v : graph[u]) {
            if (v == f) {
                continue;
            }
            dfs(v, u);
            dp[u] += dp[v] + sz[v];
            sz[u] += sz[v];
        }
    }

    public void dfs2(int u, int f) {
        ans[u] = dp[u];
        for (int v : graph[u]) {
            if (v == f) {
                continue;
            }
            int pu = dp[u], pv = dp[v];
            int su = sz[u], sv = sz[v];

            dp[u] -= dp[v] + sz[v];
            //减去v的贡献
            sz[u] -= sz[v];
            dp[v] += dp[u] + sz[u];
            sz[v] += sz[u];

            dfs2(v, u);
            //还原当前树
            dp[u] = pu;
            dp[v] = pv;
            sz[u] = su;
            sz[v] = sv;
        }
    }


}