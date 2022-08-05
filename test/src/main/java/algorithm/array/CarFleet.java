package algorithm.array;

import java.util.PriorityQueue;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/12 下午7:53
 */
public class CarFleet {
    public static void main(String[] args) {

    }

    public int carFleet(int target, int[] position, int[] speed) {

        /**
         * 速度由大到小排列
         */
        PriorityQueue<int[]> speedHeap = new PriorityQueue<int[]>((a, b) -> {
            return b[1] - a[1];
        });
        for (int i = 0; i < speed.length; ++i) {
            speedHeap.offer(new int[]{position[i], speed[i]});

        }
        int result = speed.length;
        while (!speedHeap.isEmpty()) {
            int[] cur = speedHeap.poll();
            for (int[] next : speedHeap) {
                if (cur[1] > next[1] && cur[0] < next[0]
                        && (target - cur[0]) * next[1] > (target - next[0]) * cur[1]) {
                    result--;
                }
            }
        }
        return result;
    }

}
