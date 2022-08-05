package leetcode;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/2/22 下午4:38
 */
public class Leetcode_891_sumSubseqWidths {
    public static void main(String[] args) {

    }

    /**
     * 一个序列的 宽度 定义为该序列中最大元素和最小元素的差值。
     * 该序列中最大元素和最小元素的差值。
     * 213
     */
    public int sumSubseqWidths(int[] nums) {
        int N = nums.length;
        long MOD = 1000_000_007;
        Arrays.sort(nums);

        long[] pow2 = new long[N];
        pow2[0] = 1;
        for (int i = 1; i < N; ++i) {
            pow2[i] = pow2[i - 1] * 2 % MOD;
        }
        long ret = 0;
        for (int i = 0; i < N; ++i) {
            ret = (ret + (pow2[i] - pow2[N - 1 - i]) * nums[i]) % MOD;
        }
        return (int) ret;
    }
}
