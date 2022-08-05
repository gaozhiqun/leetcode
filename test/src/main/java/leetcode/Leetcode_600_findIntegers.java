package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_600_findIntegers {

    public static void main(String[] args) {
        Leetcode_600_findIntegers l = new Leetcode_600_findIntegers();
    }

    /**
     * 0/1
     * dp[i][0]
     * dp[i][1]
     * 非负整数<= 5
     * 在由所有小于等于 nn 的非负整数构成的 0101 字典树中，找出不包含连续 11 的从根结点到叶结点的路径数量。
     *
     * @param n
     * @return
     */
    public int findIntegers(int n) {
        int[] dp = new int[32];
        dp[0] = dp[1] = 1;
        for (int i = 2; i < 32; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        int ans = 0, pre = 0;
        for (int j = 29; j >= 0; --j) {
            if ((n & (1 << j)) != 0) {
                ans += dp[j + 1];
                if (pre == 1) {
                    break;
                }
                pre = 1;
            } else {
                pre = 0;
            }
            if (j == 0) {
                ++ans;
            }
        }
        return ans;
    }


}