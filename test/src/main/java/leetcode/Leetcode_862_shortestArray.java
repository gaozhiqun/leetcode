package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/1/28 下午4:11
 */
public class Leetcode_862_shortestArray {
    public static void main(String[] args) {
        Leetcode_862_shortestArray l = new Leetcode_862_shortestArray();

    }

    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] sums = new long[n + 1];
        for (int i = 1; i <= nums.length; ++i) {
            sums[i] = nums[i - 1] + sums[i - 1];
        }
        int ret = nums.length + 1;
        Deque<Integer> monoq = new LinkedList();
        for (int r = 0; r < sums.length; ++r) {
            while (!monoq.isEmpty() && sums[r] <= sums[monoq.getLast()]) {
                monoq.removeLast();
            }
            while (!monoq.isEmpty() && sums[r] >= sums[monoq.getFirst()] + k) {
                ret = Math.min(ret, r - monoq.removeFirst());
            }
            monoq.addLast(r);
        }
        return ret==n+1?-1:ret;
    }

}
