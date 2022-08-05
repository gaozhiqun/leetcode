package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_279_numSquares {
    public static void main(String[] args) {
        Leetcode_279_numSquares l = new Leetcode_279_numSquares();
        System.out.println(l.numSquares(12));
        System.out.println(l.numSquares(13));

    }


    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 100_000_007);
        dp[0] = 0;
        for (int i = 1; i <= n; ++i) {
            int sqt = (int) Math.sqrt(i);
            if (sqt * sqt == i) {
                dp[i] = 1;
            } else {
                for (int j = 1; j <= sqt; j++) {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                }
            }
        }
        return dp[n];
    }

}
