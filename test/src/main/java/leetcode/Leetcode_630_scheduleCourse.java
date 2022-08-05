package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/1/7 下午4:15
 */
public class Leetcode_630_scheduleCourse {

    public static void main(String[] args) {

    }

    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (c1, c2) -> c1[1] - c2[1]);//按照截止时间排序
        PriorityQueue<int[]> heap = new PriorityQueue<>((c1, c2) -> c2[0] - c1[0]);
        int day = 0;
        for (int[] c : courses) {
            if (day + c[0] <= c[1]) {
                day += c[0];
                heap.offer(c);
            } else if (!heap.isEmpty() && heap.peek()[0] > c[0]) {
                day -= heap.poll()[0] - c[0];
                heap.offer(c);
            }
        }
        return heap.size();
    }
}
