package algorithm.greedy;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/8/27 下午4:14
 */
public class SmallestRange {
    public static void main(String[] args) {
        SmallestRange smallestRange = new SmallestRange();
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(4, 10, 15, 24, 26));
        list.add(Arrays.asList(0, 9, 12, 20));
        list.add(Arrays.asList(5, 18, 22, 30));
        System.out.println(smallestRange.smallestRange(list));
    }

    /**
     * 每次pop出最小的，多个有序链表合并，并且取最小值
     *
     * @param nums
     * @return
     */
    public int[] smallestRange(List<List<Integer>> nums) {
        int max = 0, min = Integer.MAX_VALUE, curMax = 0, curMin = Integer.MAX_VALUE;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < nums.size(); i++) {
            int[] cur = new int[]{nums.get(i).get(0), i, 0};
            curMin = Math.min(curMin, cur[0]);
            curMax = Math.min(curMax, cur[0]);
            min = curMin;
            max = curMax;
            priorityQueue.offer(cur);
        }
        while (true) {
            int[] cur = priorityQueue.poll();
            if (cur[2] == nums.get(cur[1]).size() - 1) {
                break;
            }
            priorityQueue.offer(new int[]{nums.get(cur[1]).get(cur[2] + 1), cur[1], cur[2] + 1});
            curMin = priorityQueue.peek()[0];
            curMax = Math.max(nums.get(cur[1]).get(cur[2] + 1), curMax);
            if (curMax - curMin < max - min) {
                min = curMin;
                max = curMax;
            }
        }
        return new int[]{min, max};
    }
}
