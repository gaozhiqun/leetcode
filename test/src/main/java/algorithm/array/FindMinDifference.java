package algorithm.array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/8/26 上午11:11
 */
public class FindMinDifference {
    public static void main(String[] args) {

    }

    public int findMinDifference(List<String> timePoints) {
        List<Integer> time = timePoints.stream().map(this::getTime).collect(Collectors.toList());
        Collections.sort(time);
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < timePoints.size(); i++) {
            if (i == 0) {
                result = Math.min(3600 - time.get(time.size() - 1) + time.get(i), result);
            } else {
                result = Math.min(time.get(i) - time.get(i - 1), result);
            }
        }
        return result;
    }

    private int getTime(String s) {
        String[] time = s.split(":");
        return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
    }
}
