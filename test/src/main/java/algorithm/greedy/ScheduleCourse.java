package algorithm.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/8/27 下午3:46
 */
public class ScheduleCourse {
    public static void main(String[] args) {

    }

    /**
     * t 延续时长
     * d 关闭时间 最多的课程
     */
    public int scheduleCourse(int[][] courses) {
/**
 * 按照课程关闭时间排序
 */
        Arrays.sort(courses, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        int time = 0;
        PriorityQueue<Integer> cost = new PriorityQueue<>();
        for (int[] course : courses) {
            if (time + course[0] < course[1]) {
                cost.offer(course[1]);
            } else if (!cost.isEmpty() && course[0] < cost.peek()) {
                time -= cost.poll() - course[0];
                cost.offer(course[0]);
            }
        }
        return cost.size();
    }

}
