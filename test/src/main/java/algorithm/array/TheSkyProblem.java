package algorithm.array;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/3/22 9:44 下午
 */
public class TheSkyProblem {
    public static void main(String[] args) {

    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> {
            return b[1] - a[1];//按照高度排序
        });
        List<Integer> boundaries = new ArrayList<>();
        for (int[] building : buildings) {
            boundaries.add(building[0]);
            boundaries.add(building[1]);
        }
        Collections.sort(boundaries); //边界从小到大排列
        List<List<Integer>> ans = new ArrayList<>();
        int idx = 0, n = buildings.length;
        for (int boundary : boundaries) {
            while (idx < n && buildings[idx][0] <= boundary) {
                priorityQueue.offer(new int[]{buildings[idx][1], buildings[idx][2]});
                ++idx;
            }
            while (!priorityQueue.isEmpty() && priorityQueue.peek()[0] <= boundary) {
                priorityQueue.poll();
            }
            int maxn = priorityQueue.isEmpty() ? 0 : priorityQueue.peek()[1];
            if (ans.size() == 0 || maxn != ans.get(ans.size() - 1).get(1)) {
                ans.add(Arrays.asList(boundary, maxn));
            }
        }
        return ans;
    }
}
