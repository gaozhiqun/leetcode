package algorithm.offer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/6/10 9:02 下午
 */
public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0, j = i - k; i < nums.length; i++, j++) {
            if (j > 0 && deque.peekFirst() == nums[i - 1]) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            if (j >= 0) {
                res[i] = deque.peekFirst();
            }

        }
        return res;

    }



}

