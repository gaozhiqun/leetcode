package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/6 下午5:12
 */
public class Leetcode_354_maxEnvelopes {


    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }

        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] e1, int[] e2) {
                if (e1[0] != e2[0]) {
                    return e1[0] - e2[0];
                } else {
                    return e2[1] - e1[1];
                }
            }
        });

        int[] f = new int[n];
        Arrays.fill(f, 1);
        int ans = 1;
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (envelopes[j][1] < envelopes[i][1]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }


    public static void main(String[] args) {
        Leetcode_354_maxEnvelopes leetcode_354_maxEnvelopes = new Leetcode_354_maxEnvelopes();
        System.out.println(leetcode_354_maxEnvelopes.maxEnvelopes(new int[][]{
                {5, 4}, {6, 4}, {6, 7}, {2, 3}
        }));
        System.out.println(leetcode_354_maxEnvelopes.maxEnvelopes(new int[][]{
                {1, 1}, {1, 1}, {1, 1}
        }));

    }


}
