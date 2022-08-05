package algorithm.array;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/4/26 4:09 下午
 */
public class MaximumValueSlidingWindow {
    public static void main(String[] args) {

    }

    public int[] maximumValue(int[] array, int k) {
        int[] result = new int[array.length - k];
        int[] maxHeap = new int[k];
        Arrays.fill(maxHeap, Integer.MIN_VALUE);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < array.length; i++) {
            priorityQueue.offer(array[i]);
            if (i >= k) {
                result[i - k] = priorityQueue.poll();
            }
        }
        return result;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }


}
