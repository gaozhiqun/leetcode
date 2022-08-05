package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/2/21 下午4:33
 */
public class Leetcode_887_superEggDrop {
    public static void main(String[] args) {
        Leetcode_887_superEggDrop l = new Leetcode_887_superEggDrop();
    }


    /**
     * k 枚鸡蛋 n
     * dpNew[i] = 1+min(Math.max(dp[i-x],dp[m-x]),Math.max(dp[i-x-1],dp[m-x-1]))
     */
    public int superEggDrop2(int k, int n) {
        if (k == 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            dp[i] = i;
        }
        for (int i = 2; i <= k; ++i) {
            int[] dpNew = new int[n + 1];
            int x = 1;
            for (int m = 1; m <= n; ++m) {
                while (x < m && Math.max(dp[x - 1], dpNew[m - x]) > Math.max(dp[x], dpNew[m - x - 1])) {
                    ++x;
                }
                dpNew[m] = 1 + Math.max(dp[x - 1], dpNew[m - x]);
            }
            dp = dpNew;
        }
        return dp[n];
    }

    /**
     * k = 1, n = 2
     * dp[i][j] -> i次操作，所能达到的最大楼层
     * f(t, k)-> t次操作 k个鸡蛋
     */
    public int superEggDrop(int k, int n) {
        if (n == 1) {
            return 1;
        }
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= k; ++i) {
            dp[1][i] = 1;
        }
        int ret = -1;
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= k; ++j) {
                dp[i][j] = 1 + dp[i - 1][j - 1] + dp[i - 1][j];
            }
            if (dp[i][k] >= n) {
                ret = i;
                break;
            }
        }
        return ret;
    }
}
