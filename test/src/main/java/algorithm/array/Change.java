package algorithm.array;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/8/25 下午5:31
 */
public class Change {
    public static void main(String[] args) {
        Change change = new Change();
        System.out.println(change.change(5, new int[]{1, 2, 5}));
        System.out.println(change.changeDp(5, new int[]{1, 2, 5}));
    }

    int total = 0;

    public int changeDp(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 1; i <= amount; ++i) {
                if (i - coin >= 0) {
                    dp[i] += dp[i - coin];
                }
            }
        }
        return dp[amount];
    }

    //要去重
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        dfs(amount, coins, 0);
        return total;
    }

    private void dfs(int amount, int[] coins, int cur) {
        if (amount == 0) {
            total += 1;
            return;
        }
        if (cur == coins.length) {
            return;
        }
        while (amount >= 0) {
            dfs(amount, coins, cur + 1);
            amount -= coins[cur];
        }
    }
}
