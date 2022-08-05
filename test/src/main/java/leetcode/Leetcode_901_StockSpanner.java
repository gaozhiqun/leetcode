package leetcode;

import java.util.List;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/2/22 下午4:38
 */
public class Leetcode_901_StockSpanner {

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100));
        System.out.println(stockSpanner.next(80));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(70));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(75));
        System.out.println(stockSpanner.next(85));


    }

    /**
     * 小于或等于
     */
    public static class StockSpanner {

        Stack<int[]> stack;
        AtomicInteger day;

        public StockSpanner() {
            stack = new Stack<>();
            day = new AtomicInteger(0);
        }

        public int next(int price) {
            int today = day.addAndGet(1);
            while (!stack.isEmpty() && stack.peek()[1] <= price) {
                stack.pop();
            }
            int ret;
            if (stack.isEmpty()) {
                ret = today;
            } else {
                ret = today - stack.peek()[0];
            }
            stack.push(new int[]{today, price});
            return ret;
        }
    }
}
