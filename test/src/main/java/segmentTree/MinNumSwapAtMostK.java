package segmentTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/30 下午3:09
 */
public class MinNumSwapAtMostK {
    public static void main(String[] args) {
        MinNumSwapAtMostK minNumSwapAtMostK = new MinNumSwapAtMostK();
        System.out.println(minNumSwapAtMostK.minInteger("9438957234785635408", 23));
        System.out.println(minNumSwapAtMostK.minInteger("36789", 22));
        System.out.println(minNumSwapAtMostK.minInteger("4321", 4));
    }

    /**
     * "36789" 逆序对
     */

    public String minInteger(String num, int k) {
        int n = num.length();
        Queue<Integer>[] queues = new Queue[10];
        for (int i = 0; i < 10; ++i) {
            queues[i] = new LinkedList<>();
        }
        for (int i = 0; i < n; ++i) {
            queues[num.charAt(i) - '0'].offer(i + 1);
        }
        BIT bit = new BIT(n);
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j < 10; ++j) {
                if (queues[j].isEmpty()) {
                    continue;
                }
                int behind = bit.getSum(queues[j].peek() + 1, n);
                int dist = queues[j].peek() + behind - i;
                if (dist <= k) {
                    bit.update(queues[j].poll(), 1);
                    ans.append(j);
                    k -= dist;
                    break;
                }
            }
        }
        return ans.toString();
    }


    public static class BIT {
        int n;
        int[] tree;

        public BIT(int n) {
            this.n = n;
            this.tree = new int[n + 1];
        }

        private int lowBit(int x) {
            return x & (-x);
        }

        private void update(int x, int val) {
            while (x <= n) {
                tree[x] += val;
                x += lowBit(x);
            }
        }

        public int getSum(int x) {
            int ans = 0;
            while (x > 0) {
                ans += tree[x];
                x -= lowBit(x);
            }
            return ans;
        }

        public int getSum(int x, int y) {
            return getSum(y) - getSum(x - 1);
        }
    }

}
