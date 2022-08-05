package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/9 下午3:17
 */
public class Leetcode_385_lexicalOrder {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        dfs(0, 1, n, ans);
        return ans;
    }

    private void dfs(int base, int s, int n, List<Integer> ans) {
        if (base > n) {
            return;
        }
        for (int i = s; i < 10; i++) {
            int num = i + base;
            if (num <= n) {
                ans.add(num);
                dfs(num * 10, 0, n, ans);
            }
        }
    }


}
