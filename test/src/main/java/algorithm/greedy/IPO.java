package algorithm.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/8/25 下午2:19
 */
public class IPO {
    public static void main(String[] args) {

    }

    /**
     * 顺序，利润>capital
     * 这道题为啥是hard
     *
     * @param k
     * @param w
     * @param profits
     * @param capital
     * @return
     */
    public int findMaxmizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> projects = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        PriorityQueue<int[]> available = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        for (int i = 0; i < profits.length; i++) {
            projects.offer(new int[]{capital[i], profits[i]});
        }
        while (k > 0) {
            --k;
            while (!projects.isEmpty() && projects.peek()[0] <= w) {
                available.offer(projects.poll());
            }
            if (available.isEmpty()) {
                break;
            } else {
                w += available.poll()[1];
            }
        }
        return w;
    }

}
