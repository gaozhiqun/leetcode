package leetcode;

import algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/3/16 下午3:17
 */
public class Leetcode_986_intervalIntersection {
    public static void main(String[] args) {
        Leetcode_986_intervalIntersection l = new Leetcode_986_intervalIntersection();
        System.out.println(l.intervalIntersection(new int[][]{
                {0, 2}, {5, 10}, {13, 23}, {24, 25},
        }, new int[][]{
                {1, 5}, {8, 12}, {15, 24}, {25, 26}
        }));
    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int M = firstList.length, N = secondList.length;
        if (M == 0 || N == 0) {
            return new int[0][0];
        }
        int i = 0, j = 0;
        List<int[]> list = new ArrayList<>();
        while (i < M && j < N) {
            int[] a = firstList[i];
            int[] b = secondList[j];
            if (a[1] < b[0]) {
                i++;
            } else if (b[1] < a[0]) {
                j++;
            } else {
                list.add(new int[]{Math.max(a[0], b[0]), Math.min(a[1], b[1])});
                if (a[1] == b[1]) {
                    i++;
                    j++;
                } else if (a[1] > b[1]) {
                    j++;
                } else {
                    i++;
                }
            }
        }
        int[][] ret = new int[list.size()][];
        for (int idx = 0; idx < list.size(); ++idx) {
            ret[idx] = list.get(idx);
        }
        return ret;
    }

}
