package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/5/5 下午5:28
 */
public class Leetcode_1049_lastStoneWeightII {
    public static void main(String[] args) {

    }

    /**
     * 30 *100 = 3001
     *
     * @param stones
     * @return
     */
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int weight : stones) {
            sum += weight;
        }
        int n = stones.length, m = sum / 2;
        boolean[] dp = new boolean[m + 1];
        dp[0] = true;
        for (int weight : stones) {
            for (int j = m; j >= weight; --j) {
                dp[j] = dp[j] || dp[j - weight];
            }
        }
        for (int j = m;; --j) {
            if (dp[j]) {
                return sum - 2 * j;
            }
        }
    }
}
