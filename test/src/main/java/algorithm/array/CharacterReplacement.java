package algorithm.array;

import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/7/5 下午2:10
 */
public class CharacterReplacement {
    public static void main(String[] args) {

    }

    /**
     * 424 替换后最长重复字符串
     * dp[i][j] dp[j+1] dp[j+2][n-1]
     * dp[j] == dp[j+2];
     *
     * @param s
     * @param k
     * @return
     */

    public int characterReplacementDp(String s, int k) {
        int m = s.length();
        int[][] dp = new int[k + 1][m];
        for (int i = 0; i <= k; i++) {
            for (int j = 0; j < m; m++) {
                int diff = k;
                int cur = j;
                while (cur >= 0 && diff > 0) {
                    if (s.charAt(j) != s.charAt(cur)) {
                        diff--;
                    }
                    --cur;
                    dp[i][j] = Math.max(dp[i][j], dp[diff][cur] + j - cur + 1);
                }
            }
        }
        return dp[k][s.length()];
    }

    public int characterReplacementArray(String s, int k) {
        int[] pos = new int[26];
        int[] prePos = new int[s.length()];
        int result = Integer.MIN_VALUE;
        Arrays.fill(pos, 0);
        for (int i = 0; i < s.length(); i++) {
            prePos[i] = pos[s.charAt(i) - 'A'];
            pos[s.charAt(i) - 'A'] = i;
        }
        for (int r = 1; r <= s.length(); r++) {
            int l = r - 1;
            int remain = k;
            while (l > 0 && remain > 0) {
                int need = prePos[l] - l + 1;
                remain -= Math.min(remain, need);
                l = Math.max(0, l - Math.min(need, remain));
            }
            result = Math.max(result, r - l);
        }
        return result;
    }

    public int characterReplacement(String s, int k) {
        int[] counts = new int[26];
        int m = s.length();
        int l = 0, r = 0, maxCounts = 0;
        while (r < m) {
            counts[s.charAt(r) - 'A']++;
            maxCounts = Math.max(maxCounts, counts[s.charAt(r) - 'A']);
            while (r - l + 1 - maxCounts > k) {
                counts[s.charAt(l) - 'A']++;
                l++;
            }
            r++;
        }
        return r - l;
    }

}
