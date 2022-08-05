package algorithm.array;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/13 下午2:55
 */
public class ShortestSubArray {
    public static void main(String[] args) {

    }

    public int shortestSubarray(int[] nums, int k) {
        int ans = 100_000_007;
        int[] sums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {
            sums[i] = sums[i + 1] + nums[i];
        }
        /**
         * 单调递增栈
         */
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && sums[i] <= sums[deque.getLast()]) {
                deque.removeLast();
            }
            while (!deque.isEmpty() && sums[i] - sums[deque.getFirst()] >= k) {
                ans = Math.min(ans, i - deque.removeFirst());
            }
        }
        return ans == 100_000_007 ? -1 : ans;
    }
}
