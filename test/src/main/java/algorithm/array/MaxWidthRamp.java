package algorithm.array;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/25 下午2:09
 */
public class MaxWidthRamp {
    public static void main(String[] args) {

    }

    public int maxWidthRamp(int[] nums) {
        int N = nums.length;
        Integer[] indexReverse = new Integer[N];
        for (int i = 0; i < N; ++i) {
            indexReverse[i] = i;
        }
        Arrays.sort(indexReverse, (a, b) -> Integer.compare(nums[a], nums[b]));
        int ans = 0;
        int m = N;
        for (int i : indexReverse) {
            ans = Math.max(ans, i - m);
            m = Math.min(m, i);
        }
        return ans;
    }
}
