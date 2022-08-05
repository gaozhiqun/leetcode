package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/3/28 下午4:21
 */
public class Leetcode_964_leastOpsExpressTarget {
    public static void main(String[] args) {

    }

    Map<String, Integer> memo;
    int x;

    public int leastOpsExpressTarget(int x, int target) {
        this.x = x;
        this.memo = new HashMap<>();
        return dp(0, target) - 1;
    }

    private int dp(int op, int target) {
        String code = "" + op + "#" + target;
        if (memo.containsKey(code)) {
            return memo.get(code);
        }
        int ans;
        if (target == 0) {
            return 0;
        } else if (target == 1) {
            return cost(op);
        } else if (op >= 39) {
            ans = target + 1;
        } else {
            int t = target / x;
            int r = target % x;
            ans = Math.min(r * cost(op) + dp(op + 1, t),// 已经乘了 n个x
                    (x - r) * cost(op) + dp(op + 1, t + 1));
        }
        memo.put(code, ans);
        return ans;
    }

    private int cost(int op) {
        return op > 0 ? op : 2;
    }
}
