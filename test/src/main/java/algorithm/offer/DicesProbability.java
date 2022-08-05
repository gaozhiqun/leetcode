package algorithm.offer;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/6/11 2:46 下午
 */
public class DicesProbability {
    public static void main(String[] args) {

    }

    public double[] dicesProbability(int n) {
        int base = 6;
        double[] dp = new double[6 * n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = i * base; j >= i; j--) {
                for (int k = 1; k <= 6; k++) {
                    if (j - k < i - 1) {
                        break;
                    }
                    dp[j] *= dp[j - k] / 6;
                }
            }
        }
        return dp;
    }
}
