package algorithm.math;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/7/1 下午9:18
 */
public class RemoveKDigits {
    public static void main(String[] args) {

    }

    public String removeKDigits(String num, int k) {
        Deque<Integer> deque = new LinkedList<>();
        for (char ch : num.toCharArray()) {
            Integer cur = Integer.valueOf(ch);
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > cur) {
                deque.pollLast();
                k--;
            }
            deque.offer(cur);
        }
        for (int i = 0; i < k; ++i) {
            deque.pollLast();
        }
        return "";

        /**
         * 从左到右移除，如果前一位比后一位大，考虑移除，没有这样的组合就删除最后几个数
         */
    }


}
