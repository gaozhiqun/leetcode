package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/14 上午10:48
 */
public class Leetcode_435_eraseOverlapIntervals {
    public static void main(String[] args) {
        Leetcode_435_eraseOverlapIntervals l = new Leetcode_435_eraseOverlapIntervals();
        System.out.println(l.findRightInterval(new int[][]{
                {3, 4}, {2, 3}, {1, 2}
        }));
        System.out.println(l.findRightInterval(new int[][]{
                {1, 4}, {2, 3}, {3, 4}
        }));
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[1] - interval2[1];
            }
        });

        int n = intervals.length;
        int right = intervals[0][1];
        int ans = 1;
        for (int i = 1; i < n; ++i) {
            if (intervals[i][0] >= right) {//重叠就合并成一个区间，区间内只能留一个
                ++ans;
                right = intervals[i][1];
            }
        }
        return n - ans;
    }

    //endi<=startj
    public int[] findRightInterval(int[][] intervals) {
        int[] res = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            int min = Integer.MAX_VALUE;
            int minindex = -1;
            for (int j = 0; j < intervals.length; j++) {
                if (intervals[j][0] >= intervals[i][1] && intervals[j][0] < min) {
                    min = intervals[j][0];
                    minindex = j;
                }
            }
            res[i] = minindex;
        }
        return res;
    }

}
