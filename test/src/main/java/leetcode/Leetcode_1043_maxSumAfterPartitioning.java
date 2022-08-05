package leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/4/8 下午8:11
 */
public class Leetcode_1043_maxSumAfterPartitioning {


    public static void main(String[] args) {
        Leetcode_1043_maxSumAfterPartitioning l = new Leetcode_1043_maxSumAfterPartitioning();
        System.out.println(l.lastStoneWeight(new int[]{1, 3}));
        System.out.println(l.lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1}));
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int max = arr[i];
            for (int len = 1; len <= k && len <= i + 1; len++) {
                max = Math.max(max, arr[i - len + 1]);
                dp[i + 1] = Math.max(dp[i + 1], dp[i - len + 1] + len * max);
            }
        }
        return dp[n];
    }


    public int lastStoneWeight(int[] stones) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>((a, b) -> b[0] - a[0]);
        int i = 0;
        while (i < stones.length) {
            priorityQueue.offer(new int[]{stones[i], i++});
        }
        while (priorityQueue.size() > 1) {
            int[] a = priorityQueue.poll();
            int[] b = priorityQueue.poll();
            int r = a[0] - b[0];
            if (r != 0) {
                priorityQueue.offer(new int[]{r, i++});
            }
        }
        return priorityQueue.isEmpty() ? 0 : priorityQueue.poll()[0];
    }


    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int i : stones) {
            sum += i;
        }
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        int m = sum / 2;
        for (int i : stones) {
            for (int j = m; j >= i; --j) {
                dp[j] = dp[j] || dp[j - i];
            }
        }
        for (int j = m; ; --j) {
            if (dp[j]) {
                return sum - 2 * j;
            }
        }
    }
}
