package leetcode;


import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/5 下午2:42
 */
public class Leetcode_204_countPrimes {

    public static void main(String[] args) {
        Leetcode_204_countPrimes l = new Leetcode_204_countPrimes();
        System.out.println(l.countPrimes(5));
        System.out.println(l.countPrimes(10));
        System.out.println(l.countPrimes(0));
        System.out.println(l.countPrimes(1));
    }

    /**
     * 2/3/5/7/11
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }
        boolean[] dp = new boolean[n];
        Arrays.fill(dp, true);
        int ans = 0;
        dp[0] = dp[1] = false;
        for (int i = 2; i * i < n; ++i) {
            for (int k = 2; i * k < n; ++k) {
                dp[i * k] = false;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (dp[i]) {
                ans++;
            }
        }
        return ans;
    }

    private boolean isPrime(int m) {
        for (int i = 2; i * i <= m; i++) {
            if (m % i == 0) {
                return false;
            }
        }
        return true;
    }
}