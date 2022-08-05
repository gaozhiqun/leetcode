package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/6 下午8:18
 */
public class Leetcode_368_kSmallestPairs {
    public static void main(String[] args) {
        Leetcode_368_kSmallestPairs l = new Leetcode_368_kSmallestPairs();
        System.out.println(l.kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));
        System.out.println(l.kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 2));
        System.out.println(l.kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 10));
        System.out.println(l.kSmallestPairs(new int[]{1, 2}, new int[]{3}, 3));

    }


    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        int m = nums1.length;
        int n = nums2.length;

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]];
            }
        });
        for (int j = 0; j < n; j++) {
            priorityQueue.offer(new int[]{0, j});//将nums1的下标0和nums2的各个下标组队入队
        }
        for (int i = 0; i < k && !priorityQueue.isEmpty(); i++) {
            int[] cur = priorityQueue.poll();
            ans.add(Arrays.asList(nums1[cur[0]], nums2[cur[1]]));
            if (cur[0] + 1 < m) {
                priorityQueue.offer(new int[]{cur[0] + 1, cur[1]});
            }
        }
        return ans;
    }


}
