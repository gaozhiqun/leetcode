package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/27 下午5:04
 */
public class Leetcode_1124_longestWPI {
    public static void main(String[] args) {
        Leetcode_1124_longestWPI l = new Leetcode_1124_longestWPI();
        System.out.println(l.longestWPI(new int[]{
                9, 9, 6, 0, 6, 6, 9
        }));
    }


    public int longestWPI(int[] hours) {
        int m = hours.length;
        int[] preSum = new int[m + 1];
        for (int i = 0; i < m; ++i) {
            if (hours[i] > 8) {
                preSum[i + 1] = preSum[i] + 1;
            } else {
                preSum[i + 1] = preSum[i] - 1;
            }
        }
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i <= m; ++i) {
            if (deque.isEmpty() || preSum[deque.peekLast()] > preSum[i]) {
                deque.addLast(i);
            }
        }
        int ret = 0;
        for (int j = m; j > 0; --j) {
            while (!deque.isEmpty() && preSum[deque.peekLast()] < preSum[j]) {
                ret = Math.max(ret, j - deque.pollLast());
            }
        }
        return ret;
    }
}
