package algorithm.array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/8/19 下午9:27
 */
public class FindRightInterval {

    public static void main(String[] args) {
        FindRightInterval findRightInterval = new FindRightInterval();
        int[] result = findRightInterval.findRightInterval(new int[][]{{1, 4}, {2, 3}, {3, 4}});
        System.out.println(Arrays.asList(result));
    }

    public int[] findRightInterval(int[][] intervals) {
        if (intervals.length == 1) {
            return new int[]{-1};
        }
        int[] result = new int[intervals.length];
        Map<Integer, Integer> pos = new HashMap<>();
        for (int i = intervals.length - 1; i > -1; --i) {
            int[] cur = intervals[i];
            pos.put(cur[0], i);
        }
        Arrays.fill(result, -1);
        for (int i = 0; i < intervals.length; ++i) {
            result[i] = pos.getOrDefault(intervals[i][1], -1);
        }
        return result;
    }
}
