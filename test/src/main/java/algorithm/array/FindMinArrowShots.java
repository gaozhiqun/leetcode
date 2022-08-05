package algorithm.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/7/6 下午7:53
 */
public class FindMinArrowShots {
    public static void main(String[] args) {
        FindMinArrowShots findMinArrowShots = new FindMinArrowShots();
        System.out.println(findMinArrowShots.findMinArrowShots(new int[][]{
                {10, 16},
                {2, 8},
                {1, 6},
                {7, 12}
        }));
    }

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int result = 0;
        int max = 0;
        for (int[] balloon : points) {
            if (balloon[0] > max) {
                result++;
                max = balloon[1];
            }
        }
        return result;
    }
}
