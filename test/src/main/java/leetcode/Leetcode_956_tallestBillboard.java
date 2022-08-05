package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/3/25 下午2:36
 */
public class Leetcode_956_tallestBillboard {
    public static void main(String[] args) {
        Leetcode_956_tallestBillboard l = new Leetcode_956_tallestBillboard();
        System.out.println(l.tallestBillboard(new int[]{
                1, 2, 3, 6
        }));
        System.out.println(l.tallestBillboard(new int[]{
                1, 2, 3, 4, 5, 6
        }));
    }


    /**
     * 每个钢支架的高度必须相等
     * 0 <= rods.length <= 20
     * 1 <= rods[i] <= 1000
     * sum(rods[i]) <= 5000
     */

    int MIN = Integer.MIN_VALUE / 3;
    int N;
    int[] rods;
    Integer[][] dp;

    public int tallestBillboard(int[] rods) {
        this.N = rods.length;
        this.rods = rods;
        dp = new Integer[N][10001];
        return dp(0, 5000);
    }

    private int dp(int i, int s) {
        if (i == N) {
            return s == 5000 ? 0 : MIN;
        } else if (dp[i][s] != null) {
            return dp[i][s];
        }
        int ret = dp(i + 1, s);
        ret = Math.max(ret, dp(i + 1, s - rods[i]));
        ret = Math.max(ret, rods[i] + dp(i + 1, s + rods[i]));
        dp[i][s] = ret;
        return ret;
    }

}
