package algorithm.array;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/8/25 下午9:37
 */
public class CountArrangement {
    public static void main(String[] args) {

    }

    /**
     * 1 质数只能和1 和自己的倍数交换
     *
     * @param n
     * @return
     */

    public int countArrangement(int n) {
        int[] dp = new int[1 << n];//2^n状态
        dp[0] = 1;
        for (int mask = 1; mask < 1 << n; mask++) {
            int num = Integer.bitCount(mask);
            for (int i = 0; i < n; ++i) {
                if ((1 << i & mask) > 0 && num % (i + 1) == 0 || (i + 1) % num == 0) {
                    dp[mask] += dp[mask ^ (1 << i)];
                }
            }
        }
        return dp[1 << n - 1];

    }


}
