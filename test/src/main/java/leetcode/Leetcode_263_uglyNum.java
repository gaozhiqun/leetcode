package leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_263_uglyNum {
    public static void main(String[] args) {
        Leetcode_263_uglyNum l = new Leetcode_263_uglyNum();
        System.out.println(l.isUgly(21));
        System.out.println(l.nthUglyNumber(10));
        System.out.println(l.nthUglyNumber(1407));

    }

    /**
     * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
     *
     * @param n
     * @return
     */

    public boolean isUgly(int n) {
        while (n > 0 && (n % 5 == 0 || n % 3 == 0 || n % 2 == 0)) {
            if (n % 5 == 0) {
                n /= 5;
            }
            if (n % 2 == 0) {
                n /= 2;
            }
            if (n % 3 == 0) {
                n /= 2;
            }
        }
        return n == 1;
    }

    public int nthUglyNumber(int n) {
        PriorityQueue<Long> p = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        p.offer(1L);
        int i = 1;
        while (i < n) {
            ++i;
            long m = p.poll();
            for (int q : new int[]{2, 3, 5}) {
                long next = m * q;
                if (!set.contains(next)) {
                    set.add(next);
                    p.offer(next);
                }
            }
        }
        return Math.toIntExact(p.poll());
    }

}
