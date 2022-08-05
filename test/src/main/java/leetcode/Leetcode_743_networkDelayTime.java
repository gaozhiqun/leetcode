package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_743_networkDelayTime {

    public static void main(String[] args) {
        Leetcode_743_networkDelayTime l = new Leetcode_743_networkDelayTime();
        System.out.println(l.networkDelayTime(new int[][]{
                {2, 1, 1}, {2, 3, 1}, {3, 4, 1}
        }, 4, 2));
        System.out.println(l.networkDelayTime(new int[][]{
                {1, 2, 1}
        }, 2, 1));
        System.out.println(l.networkDelayTime(new int[][]{
                {1, 2, 1}
        }, 2, 2));
    }


    public int networkDelayTime(int[][] times, int n, int k) {
        int[] arr = new int[n];
        Arrays.fill(arr, Integer.MAX_VALUE);
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(matrix[i], Integer.MAX_VALUE);
        }
        for (int[] time : times) {
            matrix[time[0] - 1][time[1] - 1] = time[2];
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });
        priorityQueue.offer(new int[]{k - 1, 0});
        while (!priorityQueue.isEmpty()) {
            int[] cur = priorityQueue.poll();
            int p = cur[0], cost = cur[1];
            if (cost > arr[p]) {
                continue;
            }
            arr[p] = cost;
            for (int next = 0; next < n; ++next) {
                if (p != next && matrix[p][next] != Integer.MAX_VALUE && matrix[p][next] + cost < arr[next]) {
                    priorityQueue.offer(new int[]{next, cost + matrix[p][next]});
                }
            }
        }
        int ret = -1;
        for (int i : arr) {
            if (i == Integer.MAX_VALUE) {
                return -1;
            }
            ret = Math.max(ret, i);
        }
        return ret;
    }

}