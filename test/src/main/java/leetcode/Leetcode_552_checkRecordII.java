package leetcode;


import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/14 上午10:48
 */
public class Leetcode_552_checkRecordII {


    public static void main(String[] args) {
        Leetcode_552_checkRecordII l = new Leetcode_552_checkRecordII();
        System.out.println(l.checkRecord(2));
        System.out.println(l.checkRecord(1));
        System.out.println(l.checkRecord(10101));
    }

    /**
     * 可能获得出勤奖励的记录情况 数量
     *
     * @param n
     * @return LLL
     * A 个个数最多为2
     */
    public int checkRecord(int n) {
        final int MOD = 1000000007;
        int[][] dp = new int[2][3];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int[][] dpNew = new int[2][3];
            for (int j = 0; j <= 1; j++) {
                for (int k = 0; k <= 2; k++) {
                    dpNew[j][0] = (dpNew[j][0] + dp[j][k]) % MOD;
                }
            }
            for (int k = 0; k <= 2; k++) {
                dpNew[1][0] = (dpNew[1][0] + dp[0][k]) % MOD;
            }
            for (int j = 0; j <= 1; j++) {
                for (int k = 1; k <= 2; k++) {
                    dpNew[j][k] = (dpNew[j][k] + dp[j][k - 1]) % MOD;
                }
            }
            dp = dpNew;
        }
        int sum = 0;
        for (int j = 0; j <= 1; j++) {
            for (int k = 0; k <= 2; k++) {
                sum = (sum + dp[j][k]) % MOD;
            }
        }
        return sum;
    }


}