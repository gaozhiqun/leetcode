package algorithm.bit;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/8/27 上午11:08
 */
public class FindIntegers {
    public static void main(String[] args) {
        FindIntegers findIntegers = new FindIntegers();
        System.out.println(findIntegers.findIntegers2(5));
    }

    /**
     * 不包含连续1的数字的个数
     * 10/00/01
     *
     * @param n
     * @return
     */
    public int findIntegers(int n) {
        int seed = 1;
        int result = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(seed);
        while (!queue.isEmpty()) {
            int top = queue.poll();
            ++result;
            int next = top << 1;
            if (next <= n) {
                queue.offer(next);
            }
            if (++next <= n && top % 2 == 0) {
                queue.offer(next);
            }
        }
        return result;
    }

    /**
     * f[i] 代表 XXXX0 XXXX01所有可能
     *
     * @param num
     * @return
     */

    public int findIntegers2(int num) {
        int[] f = new int[32];
        f[0] = 1;
        f[1] = 2;
        for (int i = 2; i < f.length; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        int i = 30, sum = 0, preBit = 0;
        while (i >= 0) {
            if ((num & (1 << i)) != 0) {
                sum += f[i];
                if (preBit == 1) {
                    sum--;
                    break;
                }
                preBit = 1;
            } else {
                preBit = 0;
            }
            i--;
        }
        return sum + 1;
    }
}
