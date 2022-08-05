package algorithm.array;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/20 下午7:58
 */
public class MinAreaReact {
    public static void main(String[] args) {

    }

    public int minAreaReact(int[][] points) {
        Set<Integer> pointSet = new HashSet<>();
        for (int[] point : points) {
            pointSet.add(point[0] * 40001 + point[1]);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i][0] != points[j][0] && points[i][1] != points[j][1]) {
                    if (pointSet.contains(points[i][0] * 40001 + points[j][1])
                            && pointSet.contains(points[j][0] * 40001 + points[i][1])) {
                        ans = Math.min(ans, Math.abs(points[i][0] - points[j][0]) * Math.abs(points[i][1] - points[j][1]));
                    }
                }
            }
        }
        return ans < Integer.MAX_VALUE ? ans : 0;
    }
}
