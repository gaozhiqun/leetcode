package algorithm.array;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/12 下午7:15
 */
public class LoundAndRich {
    public static void main(String[] args) {

    }

    /**
     * 喧嚣he富有 leetcode 851
     * richer[i] = [x,y] -> x比y更有钱
     * answer[x] = y 的前提 拥有的钱 richer[x,y] = true And quiet[y] 最小
     *
     * @param richer
     * @param quiet
     * @return
     */
    ArrayList<Integer>[] edges;
    int[] ans;
    int[] quiet;

    public int[] loundAndRich(int[][] richer, int[] quiet) {
        int m = quiet.length;
        edges = new ArrayList[m];
        for (int i = 0; i < m; ++i) {
            edges[i] = new ArrayList<>();
        }
        for (int[] rich : richer) {
            edges[rich[1]].add(rich[0]);
        }
        ans = new int[m];
        this.quiet = quiet;
        Arrays.fill(ans, -1);
        for (int i = 0; i < m; ++i) {
            dfs(i);
        }
        return ans;
    }

    private int dfs(int i) {
        if (ans[i] == -1) {
            ans[i] = i;
            for (int next : edges[i]) {
                int cand = dfs(next);
                if (quiet[cand] < quiet[ans[i]]) {
                    ans[i] = cand;
                }
            }
        }
        return ans[i];
    }
}
