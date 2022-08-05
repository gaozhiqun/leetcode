package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/27 下午10:45
 */
public class Leetcode_1155_numRollsToTarget {

    public static void main(String[] args) {
        Leetcode_1155_numRollsToTarget l = new Leetcode_1155_numRollsToTarget();
        System.out.println(l.numRollsToTarget(2, 6, 7));
    }

    public int numRollsToTarget(int n, int k, int target) {
        if (target < n) {
            return 0;
        }
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int r = 1; r <= n; ++r) {
            int[] temp = new int[target + 1];
            for (int p = 1; p <= target; ++p) {
                for (int j = 1; j <= k; ++j) {
                    if (j > p) {
                        continue;
                    }
                    temp[p] += dp[p - j];
                    temp[p] %= 1000000007;
                }
            }
            dp = temp;
        }
        return dp[target];
    }
}
