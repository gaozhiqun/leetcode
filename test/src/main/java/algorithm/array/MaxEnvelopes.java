package algorithm.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/6/29 下午7:30
 */
public class MaxEnvelopes {
    public static void main(String[] args) {

    }

    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        int ans = 1;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; j++) {
                if (envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }


}
