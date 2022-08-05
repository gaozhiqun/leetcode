package algorithm.greedy;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/13 上午11:15
 */
public class MinCostToHireWorkers {
    public static void main(String[] args) {

    }

    /**
     * leetcode 857
     * 1. 按照工作质量比例支付工资
     * 2. 至少获得期望工资
     * 思路： 按照工资比例倒叙，优先比较性价比最高的
     * 当恰好有人得到满足时
     *
     * @param quality
     * @param wage
     * @param k
     * @return
     */

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        Worker[] workers = new Worker[quality.length];
        for (int i = 0; i < wage.length; i++) {
            workers[i] = new Worker(quality[i], wage[i]);
        }
        Arrays.sort(workers);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        double ans = Double.MAX_VALUE;
        int sumq = 0;
        for (Worker worker : workers) {
            priorityQueue.offer(-worker.quality);
            sumq += worker.quality;
            if (priorityQueue.size() > k) {
                sumq += priorityQueue.poll();
            }
            if (priorityQueue.size() == k) {
                ans = Math.min(ans, sumq * worker.radio());
            }
        }
        return ans;
    }

    public static class Worker implements Comparable<Worker> {
        private final int quality, wage;

        public Worker(int quality, int wage) {
            this.quality = quality;
            this.wage = wage;
        }

        private double radio() {
            return ((double) wage) / quality;
        }


        @Override
        public int compareTo(Worker o) {
            return Double.compare(radio(), o.radio());
        }
    }
}
