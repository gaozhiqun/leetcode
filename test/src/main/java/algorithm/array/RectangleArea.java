package algorithm.array;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/11 下午7:32
 */
public class RectangleArea {

    /**
     * 天际线问题的变种，是底不对齐的天际线问题
     *
     * @param args
     */
    public static void main(String[] args) {

        RectangleArea rectangleArea = new RectangleArea();
        System.out.println(rectangleArea.rectangleArea(new int[][]{
                {0, 0, 2, 2}, {1, 0, 2, 3}, {1, 0, 3, 1}
        }));
    }

    public int rectangleArea(int[][] rectangles) {
        long areaTotal = 0;
        int mod = 1000_000_007;
        Arrays.sort(rectangles, (a, b) -> {
            return a[0] - b[0];//按照右边从小到大排;
        });//按照左边排序
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> {
            return a[2] - b[2];//按照右边从小到大排;
        });
        for (int[] area : rectangles) {
            areaTotal += (area[3] - area[1]) * (long) (area[2] - area[0]);
            while (priorityQueue.peek()[2] < area[0]) {

            }
        }
        return (int) (areaTotal % mod);
    }
}
