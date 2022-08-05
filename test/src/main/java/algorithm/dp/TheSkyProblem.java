package algorithm.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/8 上午10:28
 */
public class TheSkyProblem {
    public static void main(String[] args) {

    }

    /**
     * leetcode 221 天际线问题
     *
     * @param buildings
     * @return
     */
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        /**
         * maxHeap 按照高度排序
         */
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
            return b[2] - a[2];
        });
        for (int[] b : buildings) {
            map.putIfAbsent(b[0], new ArrayList<>());
            map.putIfAbsent(b[1], new ArrayList<>());
            map.get(b[0]).add(b);
            map.get(b[1]).add(b);
        }
        for (int o : map.keySet()) {
            List<int[]> bs = map.get(o);
            for (int[] b : bs) {
                if (b[0] == o) {
                    maxHeap.offer(b);
                } else {
                    maxHeap.remove(b);
                }
            }
            if (maxHeap.size() == 0) {
                //处理右下角
                List<Integer> temp = new ArrayList<>();
                temp.add(o);
                temp.add(0);
                result.add(temp);
            } else {
                int maxHeight = maxHeap.peek()[2];
                if (result.size() == 0 || result.get(result.size() - 1).get(1) != maxHeight) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(o);
                    temp.add(maxHeight);
                    result.add(temp);
                }
            }

        }
        return result;
    }

}
