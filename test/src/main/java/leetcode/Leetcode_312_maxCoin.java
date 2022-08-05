package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_312_maxCoin {

    public static void main(String[] args) {

    }


    /**
     * 3,1,5,8
     * <p>
     * dp[0][n-1] = dp[i]
     */
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] rec = new int[n + 2][n + 2];
        int[] val = new int[n + 2];
        val[0] = val[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            val[i] = nums[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {//lboard
            for (int j = i + 2; j <= n + 1; j++) {//rboard
                for (int k = i + 1; k < j; k++) {// kth ballon
                    int sum = val[i] * val[k] * val[j];
                    sum += rec[i][k] + rec[k][j];
                    rec[i][j] = Math.max(rec[i][j], sum);
                }
            }
        }
        return rec[0][n + 1];
    }

}