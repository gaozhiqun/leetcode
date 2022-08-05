package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/3/28 下午3:57
 */
public class Leetcode_962_maxWidthRamp {
    public static void main(String[] args) {
        Leetcode_962_maxWidthRamp l = new Leetcode_962_maxWidthRamp();
        System.out.println(l.maxWidthRamp(new int[]{6, 0, 8, 2, 1, 5}));
        System.out.println(l.maxWidthRamp(new int[]{9, 8, 1, 0, 1, 9, 4, 0, 4, 1}));
    }

    /**
     * i < j 且 A[i] <= A[j]
     * maxHeap
     *
     * @param nums
     * @return
     */
    public int maxWidthRamp(int[] nums) {
        int N = nums.length;
        Integer[] idx = new Integer[N];
        for (int i = 0; i < N; ++i) {
            idx[i] = i;
        }
        Arrays.sort(idx, (i, j) -> nums[i] - nums[j]);
        int minIdx = N, ret = 0;
        for (int i : idx) {
            ret = Math.max(ret, i - minIdx);
            minIdx = Math.min(minIdx, i);
        }
        return ret;
    }


}
