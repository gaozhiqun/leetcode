package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/1/28 下午4:11
 */
public class Leetcode_851_loudAndRich {
    public static void main(String[] args) {

    }

    /**
     *  answer[x] = y 的前提是，在所有拥有的钱肯定不少于 person x 的人中，person y 是最安静的人（也就是安静值 quiet[y] 最小的人）。
     *
     */

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        List<Integer>[] g = new List[n];
        for (int i = 0; i < n; ++i) {
            g[i] = new ArrayList<Integer>();
        }
        for (int[] r : richer) {
            g[r[1]].add(r[0]);
        }

        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int i = 0; i < n; ++i) {
            dfs(i, quiet, g, ans);
        }
        return ans;
    }

    public void dfs(int x, int[] quiet, List<Integer>[] g, int[] ans) {
        if (ans[x] != -1) {
            return;
        }
        ans[x] = x;
        for (int y : g[x]) {
            dfs(y, quiet, g, ans);
            if (quiet[ans[y]] < quiet[ans[x]]) {
                ans[x] = ans[y];
            }
        }
    }

}
