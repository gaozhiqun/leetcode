package algorithm.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/28 下午6:46
 */
public class NumSqurefullPerms {
    public static void main(String[] args) {

    }


    Map<Integer, List<Integer>> nb;
    Map<Integer, Integer> cnt;

    public int NumSqureFullPerms(int[] nums) {
        cnt = new HashMap<>();
        int N = nums.length;
        for (int i = 0; i < N; ++i) {
            cnt.put(i, cnt.getOrDefault(i, 0) + 1);
        }
        for (int i : cnt.keySet()) {
            nb.put(i, new ArrayList<>());
        }
        for (int x : cnt.keySet()) {
            for (int y : cnt.keySet()) {
                int r = (int) (Math.sqrt(x + y) + 0.5);
                if (r * r == x + y) {
                    nb.get(x).add(y);
                }
            }
        }
        int ans = 0;
        for (int x : cnt.keySet()) {
            ans += dfs(x, N - 1);
        }
        return ans;
    }

    private int dfs(int x, int todo) {
        int ans = 0;
        cnt.put(x, cnt.get(x) - 1);
        if (todo > 0) {
            for (int next : nb.get(x)) {
                if (cnt.get(next) > 0) {
                    ans += dfs(next, todo - 1);
                }
            }
        }
        cnt.put(x, cnt.get(x) + 1);
        return ans;
    }
}
