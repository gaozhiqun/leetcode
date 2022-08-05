package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/1/10 下午4:47
 */
public class Leetcode_632_smallestRange {
    public static void main(String[] args) {
        Leetcode_632_smallestRange leetcode_632_smallestRange = new Leetcode_632_smallestRange();
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(4, 10, 15, 24, 26));
        list.add(Arrays.asList(0, 9, 12, 20));
        list.add(Arrays.asList(5, 18, 22, 30));
        System.out.println(Arrays.asList(leetcode_632_smallestRange.smallestRange(list)));
        list = new ArrayList<>();
        list.add(Arrays.asList(1, 2, 3));
        list.add(Arrays.asList(1, 2, 3));
        list.add(Arrays.asList(1, 2, 3));
        System.out.println(Arrays.asList(leetcode_632_smallestRange.smallestRange(list)));
        list = new ArrayList<>();
        list.add(Arrays.asList(10, 10));
        list.add(Arrays.asList(11, 11));
        System.out.println(Arrays.asList(leetcode_632_smallestRange.smallestRange(list)));

    }


    public int[] smallestRange(List<List<Integer>> nums) {
        int m = nums.size();
        int max = Integer.MIN_VALUE;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> {
            return nums.get(a[0]).get(a[1]) - nums.get(b[0]).get(b[1]);
        });
        int[] ret = null;
        for (int i = 0; i < m; ++i) {
            int n = nums.get(i).get(0);
            max = Math.max(n, max);
            priorityQueue.offer(new int[]{i, 0});
        }
        while (priorityQueue.size() == m) {
            int[] cur = priorityQueue.poll();
            int i = cur[0], j = cur[1], curMin = nums.get(i).get(j);
            if (ret == null || ret[1] - ret[0] > max - curMin) {
                ret = new int[]{curMin, max};
            }
            if (j + 1 < nums.get(i).size()) {
                priorityQueue.offer(new int[]{i, j + 1});
                max = Math.max(max, nums.get(i).get(j + 1));
            }
        }
        return ret;
    }

    public int findLengthOfLCIS(int[] nums) {
        int len = 1, max = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                ++len;
            } else {
                len = 1;
            }
            max = Math.max(len, max);
        }
        return max;
    }
}
