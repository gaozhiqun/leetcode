package algorithm.array;

import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/19 下午2:35
 */
public class SmallestRange {
    public static void main(String[] args) {

    }

    public int smallestRange(int[] A, int K) {
        if (A.length == 1) {
            return 0;
        }
        Arrays.sort(A);
        int N = A.length;
        int ans = A[N - 1] - A[0];
        for (int i = 0; i < A.length - 1; ++i) {
            int a = A[i], b = A[i + 1];
            int high = Math.max(A[N - 1] - K, a + K);
            int low = Math.max(A[0] + K, b - K);
            ans = Math.min(high - low, ans);
        }
        return ans;
    }
}
