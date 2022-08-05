package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/2 下午9:11
 */
public class Leetcode_347_topKFrequent {
    /**
     * 1 <= nums.length <= 105
     * k 的取值范围是 [1, 数组中不相同的元素的个数]
     * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
     * <p>
     * 必须 优于 O(n log n)
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int i : nums) {
            cntMap.put(i, cntMap.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            queue.offer(new int[]{entry.getKey(), entry.getValue()});
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; ++i) {
            ans[i] = queue.poll()[0];
        }
        return ans;
    }


}
