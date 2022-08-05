package algorithm.greedy;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/14 下午4:51
 */
public class ProfitableSchemes {
    public static void main(String[] args) {

    }

    /**
     * leetcode 879
     * n名员工，group[i]名参加。状态压缩算法 对于某种工作，可以做，也可以不做
     * 可以改为DP
     * dp[i][j][k] 前i个工作，j名员工，获得了至少为k的利润
     *
     * @param n
     * @param minProfit
     * @param group
     * @param profit
     * @return
     */
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int m = group.length;
        Set<Integer> seen = new HashSet<>();
        Queue<Status> queue = new LinkedList<>();
        int ans = 0;
        queue.offer(new Status(0, -1, n));
        seen.add(0);
        while (!queue.isEmpty()) {
            Status cur = queue.poll();
            if (cur.profit >= minProfit) {
                ++ans;
            }
            for (int next = cur.cur + 1; next < m && cur.workerRemain >= group[next]; ++next) {
                queue.offer(new Status(cur.profit + profit[next], next, cur.workerRemain - group[next]));
            }
        }
        return ans;
    }

    public int profitableSchemesDp(int n, int minProfit, int[] group, int[] profit) {
        int m = group.length;
        int[][] dp = new int[n + 1][minProfit + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= m; ++i) {
            int w = group[i - 1], p = profit[i - 1];
            for (int j = n; j >= w; j--) {
                for (int k = minProfit - 1; k >= 0; k--) {
                    dp[j][k] = dp[j][k] + dp[j - w][Math.max(0, k - p)];
                }
            }
        }

        return dp[n][minProfit];
    }

    public class Status {
        int cur, profit, workerRemain;

        public Status(int profit, int cur, int workerRemain) {
            this.cur = cur;
            this.profit = profit;
            this.workerRemain = workerRemain;
        }
    }


}
