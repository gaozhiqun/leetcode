package algorithm.dp;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/9 下午3:05
 */
public class New21Game {
    public static void main(String[] args) {
        New21Game new21Game = new New21Game();
        System.out.println(new21Game.new21Game(21, 17, 10));
    }

    /**
     * 每次获取 [1, maxPts], 共K次，不超过n的概率
     * 从后往前填表
     *
     * @param n
     * @param k
     * @param w
     * @return
     */
    public double new21Game(int n, int k, int w) {
        double[] dp = new double[k + w];
        double[] suffixSum = new double[k + w + 1];
        for (int i = k + w - 1; i >= 0; --i) {
            if (i >= k) {
                dp[i] = i > n ? 0.0 : 1.0;
            } else {
                dp[i] = (suffixSum[i + 1] - suffixSum[i + w + 1]) / w;
            }
            suffixSum[i] = suffixSum[i + 1] + dp[i];
        }
        return dp[0];
    }
}
