package algorithm.array;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/7/1 下午3:37
 */
public class KSmallestPairs {
    public static void main(String[] args) {

    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int i = 0;
        int j = 0;
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] + nums2[o2[1]];
            }
        });
        priorityQueue.offer(new int[]{0, 0});
        while (result.size() < k && !priorityQueue.isEmpty()) {
            int[] top = priorityQueue.poll();
            //将下一对儿扔进去
        }
        return result;
    }
}
