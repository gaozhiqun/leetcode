package leetcode;


import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_56_merge {

    public static void main(String[] args) {
        Leetcode_56_merge l = new Leetcode_56_merge();
        System.out.println(l.merge(new int[][]{
                {2, 3}, {4, 5}, {6, 7}, {1, 10}
        }));
        System.out.println(l.merge(new int[][]{
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        }));
    }


    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> list = new LinkedList<>();
        Arrays.sort(intervals, (a, b) -> {
            return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
        });
        for (int[] pair : intervals) {
            if (list.isEmpty()) {
                list.addLast(pair);
            } else {
                int[] last = list.getLast();
                if (pair[0] <= last[1]) {
                    list.pollLast();
                    list.addLast(new int[]{Math.min(last[0], pair[0]), Math.max(last[1], pair[1])});
                } else {
                    list.addLast(pair);
                }
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
