package algorithm.array;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/27 下午7:18
 */
public class IntervalIntersection {
    public static void main(String[] args) {
        IntervalIntersection intervalIntersection = new IntervalIntersection();
        int[][] merge = intervalIntersection.intervalIntersection(
                new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}},
                new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}});
        for (int[] i : merge) {
            System.out.println(i[0] + "  " + i[1]);
        }
        merge = intervalIntersection.intervalIntersection(
                new int[][]{{1, 3}, {5, 9}},
                new int[][]{});
        for (int[] i : merge) {
            System.out.println(i[0] + "  " + i[1]);
        }
    }

    /**
     * leetcode 986
     *
     * @param firstList
     * @param secondList
     * @return
     */


    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();
        int a = 0, b = 0, m = firstList.length, n = secondList.length;
        while (a < m && b < n) {
            int lo = Math.max(firstList[a][0], secondList[b][0]);
            int hi = Math.min(firstList[a][1], secondList[b][1]);
            if (lo <= hi) {
                result.add(new int[]{lo, hi});
            }
            if (firstList[a][1] < secondList[b][1]) {
                ++a;
            } else {
                ++b;
            }
        }
        return result.toArray(new int[result.size()][]);
    }

}
