package algorithm.tree;

import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/28 下午7:56
 */
public class MergeStones {
    public static void main(String[] args) {
        MergeStones mergeStones = new MergeStones();
//        System.out.println(mergeStones.mergeStones(new int[]{3, 5, 1, 2, 6}, 3));
//        System.out.println(mergeStones.mergeStones(new int[]{3, 2, 4, 1}, 2));
        System.out.println(mergeStones.mergeStones2(new int[]{6, 4, 4, 6}, 2));
    }

    public int mergeStones2(int[] stones, int K) {
        int M = stones.length;
        if (K > 2 && M % (K - 1) != 1) {
            return -1;
        }
        int[] sums = new int[M + 1];
        for (int i = 0; i < M; ++i) {
            sums[i + 1] = sums[i] + stones[i];
        }
        int[][][] dp = new int[M + 1][M + 1][K + 1];

        for (int i = 1; i <= M; i++) {
            for (int j = 0; j <= M; ++j) {
                Arrays.fill(dp[i][j], 999999);
            }
            dp[i][i][1] = 0;
        }
        for (int len = 2; len <= M; len++) {
            for (int i = 1; i + len - 1 <= M; ++i) {
                int j = i + len - 1;
                for (int k = 2; k <= K; ++k) {
                    for (int t = i; t < j; t++) {
                        dp[i][j][k] = Math.min(dp[i][j][k], dp[i][t][k - 1] + dp[t + 1][j][1]);
                    }
                }
                dp[i][j][1] = dp[i][j][K] + sums[j] - sums[i - 1];
            }
        }
        return dp[1][M][1];
    }

    public int mergeStones(int[] stones, int k) {
        int M = stones.length;
        if (k > 2 && M % (k - 1) != 1) {
            return -1;
        }
        int ans = 0;
        int[] sums = new int[M + 1];
        for (int i = 0; i < M; ++i) {
            sums[i + 1] = sums[i] + stones[i];
        }
        for (int r = M; r > 1; r -= (k - 1)) {
            int min = sums[k], i = k;
            for (int l = k; l <= r; ++l) {
                if (sums[l] - sums[l - k] < min) {
                    min = sums[l] - sums[l - k];
                    i = l;
                }
            }
            ans += min;
            if (r - i >= 0) {
                System.arraycopy(sums, i, sums, i - k + 1, r - i + 1);
            }
        }
        return ans;
    }
}
