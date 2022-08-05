package algorithm.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/25 下午3:22
 */
public class LeastOpsExpressTarget {
    public static void main(String[] args) {

    }

    Map<String, Integer> memo;
    int x;

    public int leastOpsExpressTarget(int x, int target) {
        this.x = x;
        this.memo = new HashMap<>();
        return dp(0, target) - 1;
    }

    public int dp(int i, int target) {//i: 几个数字， target: 当前结果
        String key = String.format("%s_%s", i, target);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int ans;
        if (target == 0) {
            ans = 0;
        } else if (i >= 39) {
            ans = target + 1;
        } else {
            int t = target / x;
            int r = target % x;
            ans = Math.max(dp(i + 1, t) + r * cost(i),
                    (x - r) * cost(i) + dp(i + 1, t + 1));
        }
        memo.put(key, ans);
        return ans;
    }

    public int cost(int x) {
        return x > 0 ? x : 2;
    }
//

}
