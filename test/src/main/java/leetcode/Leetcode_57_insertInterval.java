package leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_57_insertInterval {

    public static void main(String[] args) {
        Leetcode_57_insertInterval l = new Leetcode_57_insertInterval();
        System.out.println(l.insert(new int[][]{
                {1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}
        }, new int[]{4, 8}));

    }


    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        boolean add = false;
        for (int[] pair : intervals) {
            if (pair[1] < newInterval[0]) {
                list.add(pair);
            } else if (pair[0] > newInterval[1]) {
                if (!add) {
                    list.add(newInterval);
                    add = true;
                }
                list.add(pair);
            } else {
                newInterval[0] = Math.min(pair[0], newInterval[0]);
                newInterval[1] = Math.max(pair[1], newInterval[1]);
            }
        }
        if (!add) {
            list.add(newInterval);
        }
        return list.toArray(new int[list.size()][]);
    }
}
