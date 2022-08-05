package algorithm.search.binary;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/9/17 下午7:31
 */
public class KthSmallestPrimeFraction {
    public static void main(String[] args) {

    }

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int m = arr.length;
        if (k == 1) {
            return new int[]{arr[0], arr[m - 1]};
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Long.compare(o1[0] * (long) o2[1], o2[0] * (long) o1[0]);
            }
        });
        priorityQueue.offer(new int[]{arr[0], arr[m - 1]});
        int total = 1;
        int[] next = null;
        while (total < k && !priorityQueue.isEmpty()) {
            next = priorityQueue.poll();
            if (next[0] < m - 1) {
                priorityQueue.offer(new int[]{next[0] + 1, next[1]});
            }
            if (next[1] < m) {
                priorityQueue.offer(new int[]{next[0], next[1] + 1});
            }
        }
        return next;
    }

}
