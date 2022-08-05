package algorithm.dp;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/9/26 下午1:34
 */
public class BestRotation {
    /**
     * 789 得分最高的最小轮调
     * A[i]的取值范围[0,A.length] -> 下标和值可以互换
     */

    public static void main(String[] args) {

    }

    public int bestRotation(int[] A) {
        int N = A.length;
        int[] bad = new int[N];
        for (int i = 0; i < N; ++i) {
            int left = (i - A[i] + 1 + N) % N;
            int right = (i + 1) % N;
            bad[left]--;
            bad[right]++;
            if (left > right)
                bad[0]--;
        }

        int best = -N;
        int ans = 0, cur = 0;
        for (int i = 0; i < N; ++i) {
            cur += bad[i];
            if (cur > best) {
                best = cur;
                ans = i;
            }
        }
        return ans;
    }
}



