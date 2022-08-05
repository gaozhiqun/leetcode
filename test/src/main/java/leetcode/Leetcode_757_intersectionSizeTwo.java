package leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/1/13 下午5:35
 */
public class Leetcode_757_intersectionSizeTwo {
    public static void main(String[] args) {
        Leetcode_757_intersectionSizeTwo l = new Leetcode_757_intersectionSizeTwo();
        System.out.println(l.intersectionSizeTwo(new int[][]{
                {2, 10}, {3, 7}, {3, 15}, {4, 11}, {6, 12}, {6, 16}, {7, 8}, {7, 11}, {7, 15}, {11, 12}}));

        System.out.println(l.intersectionSizeTwo(new int[][]{
                {1, 3}, {1, 4}, {2, 5}, {3, 5}
        }));

        System.out.println(l.intersectionSizeTwo(new int[][]{
                {1, 2}, {2, 3}, {2, 4}, {4, 5}
        }));


    }

    public int intersectionSizeTwo2(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[0] != b[0] ? a[0] - b[0] : b[1] - a[1];
        });
        int M = intervals.length;
        if (M == 0) {
            return 0;
        }
        int ret = 0, cover = 0;
        int[] pre = new int[]{-1, -1};
        for (int i = 0; i < M; ++i) {
            int[] cur = intervals[i];
            if (cur[0] > pre[1]) {
                ret += 2;
                cover = 2;
                pre = intervals[i];
            } else if (cur[0] == pre[1]) {
                ret++;
                pre = new int[]{cur[0] + 1, cur[1]};
                cover = 1;
            } else {
                if (cover == 1) {
                    pre = new int[]{pre[1] + 1, cur[1]};
                    cover = 1;
                    ret++;
                } else {
                    pre = new int[]{Math.max(cur[0], pre[0]), Math.min(cur[1], pre[1])};
                }
            }
        }
        return ret;
    }

    /**
     * 往前可以覆盖到哪里
     *
     * @param intervals
     * @return
     */

    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
        });
        int[] todo = new int[intervals.length];
        Arrays.fill(todo, 2);
        int ans = 0;
        for (int t = intervals.length - 1; t >= 0; --t) {
            int s = intervals[t][0];
            int m = todo[t];
            for (int p = s; p < s + m; ++p) {
                for (int i = 0; i <= t; ++i) {
                    if (todo[i] > 0 && p <= intervals[i][1]) {
                        todo[i]--;
                    }
                }
                ans++;
            }
        }
        return ans;
    }

}
