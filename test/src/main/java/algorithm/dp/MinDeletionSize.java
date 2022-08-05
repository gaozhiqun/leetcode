package algorithm.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/22 下午3:38
 */
public class MinDeletionSize {
    public static void main(String[] args) {

    }

    public int minDeletionSize(String[] strs) {
        int M = strs[0].length();
        int N = strs.length;
        int[] dp = new int[M];//(0...N)能组成的最长字符串
        for (int i = 0; i < M; ++i) {
            dp[i] = 1;
            search:
            for (int j = 0; j < i; ++j) {
                for (String s : strs) {
                    if (s.charAt(i) > s.charAt(j)) {
                        continue search;
                    }
                }
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        int kept = 0;
        for (int x : dp) {
            kept = Math.max(x, kept);
        }
        return M - kept;
    }
}
