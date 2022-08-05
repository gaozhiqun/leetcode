package algorithm.dp;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/7/2 上午10:06
 */
public class FrogMove {
    public static void main(String[] args) {
        FrogMove frogMove = new FrogMove();
        System.out.println(frogMove.canCross(new int[]{0, 1, 3, 5, 6, 8, 12, 17}));
    }

    public boolean canCross(int[] stones) {
        return helper(0, 0, stones);
    }

    /**
     * 所有的递归都能改成dp
     *
     * @param cur
     * @param lastJump
     * @param stones
     * @return
     */

    private boolean helper(int cur, int lastJump, int[] stones) {
        if (cur == stones.length - 1) {
            return true;
        }
        int next = cur + 1;
        boolean result = false;
        while (next < stones.length && stones[next] - stones[cur] <= lastJump + 1) {
            if (stones[next] - stones[cur] == lastJump - 1 || stones[next] - stones[cur] == lastJump || stones[next] - stones[cur] == lastJump + 1) {
                result = result || helper(next, stones[next] - stones[cur], stones);
            }
            ++next;
        }
        return result;
    }

    public boolean canCrossWithDp(int[] stones) {
        int m = stones.length;
        boolean[][] dp = new boolean[m][m];
        dp[0][0] = true;
        for (int i = 1; i < m; ++i) {
            if (stones[i] - stones[i - 1] > i) {
                return false;
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int k = stones[i] - stones[j];
                if (k > j + 1) {
                    break;
                }
                dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];
                if (i == m - 1 && dp[i][k]) {
                    return true;
                }
            }
        }
        return false;
    }
}
