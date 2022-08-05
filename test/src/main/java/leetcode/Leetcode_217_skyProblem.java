package leetcode;


import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/5 下午2:42
 */
public class Leetcode_217_skyProblem {

    public static void main(String[] args) {
        Leetcode_217_skyProblem l = new Leetcode_217_skyProblem();
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, List<int[]>> map = new TreeMap<>();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[2] - o1[2];// 按照高度排序
            }
        });
        for (int[] b : buildings) {
            map.putIfAbsent(b[0], new ArrayList<>());
            map.putIfAbsent(b[1], new ArrayList<>());
            map.get(b[0]).add(b);
            map.get(b[1]).add(b);
        }
        for (int o : map.keySet()) {
            List<int[]> walls = map.get(o);
            for (int[] b : walls) {
                if (o == b[0]) {
                    maxHeap.add(b);
                } else {
                    maxHeap.remove(b);
                }
                if (maxHeap.size() == 0) {
                    //处理右下角
                    List<Integer> temp = new ArrayList<>();
                    temp.add(o);
                    temp.add(0);
                    ans.add(temp);
                } else {
                    int maxHeight = maxHeap.peek()[2];
                    if (ans.size() == 0 || ans.get(ans.size() - 1).get(1) != maxHeight) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(o);
                        temp.add(maxHeight);
                        ans.add(temp);
                    }
                }
            }

        }
        return ans;

    }

    public List<List<Integer>> getSkyline2(int[][] buildings) {
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