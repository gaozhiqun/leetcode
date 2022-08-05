package algorithm.dp;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/7/6 下午9:28
 */
public class CanWin {
    public static void main(String[] args) {
        CanWin canWin = new CanWin();
    }

    private boolean canWin(int max, int total) {
        if (max >= total) {
            return true;
        }
        if ((1 + max) * max / 2 < total) {
            return false;
        }
        Boolean[] dp = new Boolean[1 << max];
        return dfs(0, total, dp, max);
    }

    private boolean dfs(int state, int total, Boolean[] dp, int max) {
        if (dp[state] != null) {
            return dp[state];
        }
        for (int i = 1; i <= max; i++) {
            int cur = 1 << (i - 1);
            if ((cur & state) != 0) {
                continue;
            }
            if (i >= total || !dfs(cur | state, total - i, dp, max)) {
                return dp[state] = true;
            }
        }
        return dp[state] = false;
    }
}
