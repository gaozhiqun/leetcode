package algorithm.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/27 下午3:35
 */
public class MinCostTickets {
    public static void main(String[] args) {
        MinCostTickets minCostTickets = new MinCostTickets();
        System.out.println(minCostTickets.minCostTickets(
                new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15}
        ));
        System.out.println(minCostTickets.minCostTickets(
                new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15}
        ));
        System.out.println(minCostTickets.minCostTickets(
                new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31}, new int[]{2, 7, 15}
        ));
    }

    public int minCostTickets(int[] days, int[] costs) {
        int N = days.length;
        Arrays.sort(days);
        int k = 0;
        int last = days[N - 1];
        int[] dp = new int[last + 1];
        for (int i = 1; i <= last; ++i) {
            if (i == days[k]) {
                ++k;
                dp[i] = dp[i - 1] + costs[0];
                dp[i] = Math.min(dp[i], dp[Math.max(i - 7, 0)] + costs[1]);
                dp[i] = Math.min(dp[i], dp[Math.max(i - 30, 0)] + costs[2]);
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[last];
    }
}
