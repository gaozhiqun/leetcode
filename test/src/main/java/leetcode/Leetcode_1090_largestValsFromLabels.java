package leetcode;


import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/26 下午8:29
 */
public class Leetcode_1090_largestValsFromLabels {

    public static void main(String[] args) {
        Leetcode_1090_largestValsFromLabels l = new Leetcode_1090_largestValsFromLabels();
        // System.out.println(l.largestValsFromLabels(new int[]{5, 4, 3, 2, 1}, new int[]{1, 1, 2, 2, 3}, 3, 1));
        //System.out.println(l.largestValsFromLabels(new int[]{5, 4, 3, 2, 1}, new int[]{1, 3, 3, 3, 2}, 3, 2));
        System.out.println(l.largestValsFromLabels(new int[]{9, 8, 8, 7, 6}, new int[]{0, 0, 0, 1, 1}, 3, 1));
    }

    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        Map<Integer, List<Integer>> price = new HashMap<>();
        int ret = 0, cnt = 0;
        Map<Integer, Integer> cnts = new HashMap<>();
        //价值
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> {
            return values[b] - values[a];
        });
        for (int i = 0; i < labels.length; ++i) {
            priorityQueue.offer(i);
        }
        while (!priorityQueue.isEmpty()) {
            int cur = priorityQueue.poll();
            int labelCnt = cnts.getOrDefault(labels[cur], 0);
            if (labelCnt >= useLimit) {
                continue;
            }
            ret += values[cur];
            cnts.put(labels[cur], labelCnt + 1);
            ++cnt;
            if (cnt == numWanted) {
                break;
            }
        }
        return ret;
    }


}
