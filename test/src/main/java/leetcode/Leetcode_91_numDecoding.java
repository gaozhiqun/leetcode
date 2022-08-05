package leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_91_numDecoding {

    /**
     * 10
     */

    public static void main(String[] args) {
        Leetcode_91_numDecoding l = new Leetcode_91_numDecoding();
        System.out.println(l.numDecodings("12"));
        System.out.println(l.numDecodings("226"));
    }

    public int numDecodings(String s) {
        if (s.startsWith("0")) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int cur = s.charAt(i - 1) - '0';
            if (cur == 0) {
                dp[i] = 0;
            } else {
                dp[i] = dp[i - 1];
            }
            if (i > 1) {
                int pre = (s.charAt(i - 2) - '0') * 10 + cur;
                if (pre > 9 && pre <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[n];
    }

}
