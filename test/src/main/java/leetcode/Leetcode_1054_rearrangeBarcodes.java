package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/5/5 下午6:43
 */
public class Leetcode_1054_rearrangeBarcodes {
    public static void main(String[] args) {
        Leetcode_1054_rearrangeBarcodes l = new Leetcode_1054_rearrangeBarcodes();
        System.out.println(l.rearrangeBarcodes(new int[]{
                7, 7, 7, 8, 5, 7, 5, 5, 5, 8}));
        System.out.println(l.rearrangeBarcodes(new int[]{
                1, 1, 1, 1, 2, 2, 3, 3}));
        System.out.println(l.rearrangeBarcodes(new int[]{
                1, 1, 1, 2, 2, 2}));
    }

    public int[] rearrangeBarcodes(int[] barcodes) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> {
            return b[1] - a[1];
        });
        Map<Integer, Integer> cnts = new HashMap<>();
        for (int i : barcodes) {
            cnts.put(i, cnts.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : cnts.entrySet()) {
            priorityQueue.offer(new int[]{entry.getKey(), entry.getValue()});
        }
        int[] ret = new int[barcodes.length];
        int i = 0;
        while (!priorityQueue.isEmpty()) {
            int[] cur = priorityQueue.poll();
            if (i == 0 || ret[i - 1] != cur[0]) {
                ret[i++] = cur[0];
                cur[1]--;
                if (cur[1] > 0) {
                    priorityQueue.offer(cur);
                }
            } else {
                if (priorityQueue.size() < 1) {
                    return ret;
                }
                int[] next = priorityQueue.poll();
                ret[i++] = next[0];
                next[1]--;
                if (next[1] > 0) {
                    priorityQueue.offer(next);
                }
                priorityQueue.offer(cur);
            }
        }
        return ret;
    }
}
