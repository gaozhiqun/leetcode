package algorithm.array;


import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/7/5 下午4:37
 */
public class EraseOverlapIntervals {
    public static void main(String[] args) {

    }

    public int eraseOverlapIntervals(int[][] intervals) {
        int m = intervals.length;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[] dp = new int[m];
        Arrays.fill(dp, 1);
        dp[0] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (intervals[i][0] >= intervals[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
        }
        return m - Arrays.stream(dp).max().getAsInt();
    }

    public int eraseOverlapIntervals2(int[][] intervals) {
        int m = intervals.length;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int result = 0;
        int r = intervals[0][1];

        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] >= r) {
                ++result;
                r = intervals[i][1];
            }
        }
        return m - result;
    }

}
