package leetcode;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_295_MedianFinder {
    public static void main(String[] args) {
        Leetcode_295_MedianFinder l = new Leetcode_295_MedianFinder();
        MedianFinder m = new MedianFinder();
        m.addNum(1);
        m.addNum(2);
        System.out.println(m.findMedian());
        m.addNum(3);
        System.out.println(m.findMedian());

    }

    public static class MedianFinder {

        private PriorityQueue<Integer> sq;
        private PriorityQueue<Integer> bq;

        public MedianFinder() {
            sq = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return Integer.compare(o2, o1);
                }
            });
            bq = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (sq.isEmpty() || num < sq.peek()) {
                sq.offer(num);
            } else {
                bq.offer(num);
            }
            rebalance();
        }

        private void rebalance() {
            while (bq.size() > sq.size()) {
                sq.offer(bq.poll());
            }
            while (sq.size() - bq.size() > 1) {
                bq.offer(sq.poll());
            }
        }

        public double findMedian() {
            if (bq.size() == sq.size()) {
                return (bq.peek() + sq.peek()) / 2.0;
            }
            return sq.peek();
        }

    }


    public boolean canWinNim(int n) {
        if (n <= 3) {
            return true;
        }
        boolean[] win = new boolean[n + 1];
        win[0] = win[1] = win[2] = win[3] = true;
        for (int i = 4; i <= n; ++i) {
            win[i] = !(win[i - 1] && win[i - 2] && win[i - 3]);
        }
        return win[n];
    }


}
