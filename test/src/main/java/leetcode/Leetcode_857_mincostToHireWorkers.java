package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/2/1 下午8:08
 */
public class Leetcode_857_mincostToHireWorkers {
    public static void main(String[] args) {

    }

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int N = quality.length;
        Worker[] workers = new Worker[N];
        for (int i = 0; i < N; ++i) {
            workers[i] = new Worker(quality[i], wage[i]);
        }
        Arrays.sort(workers);
        int qTotal = 0;
        double ans = 1e9;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            Worker w = workers[i];
            priorityQueue.offer(-w.quality);
            qTotal += w.quality;
            while (priorityQueue.size() > k) {
                qTotal += priorityQueue.poll();
            }
            if (priorityQueue.size() == k) {
                ans = Math.min(ans, qTotal * w.ratio);
            }
        }
        return ans;
    }
}

class Worker implements Comparable<Worker> {
    public int quality, wage;
    public double ratio;

    public Worker(int q, int w) {
        quality = q;
        wage = w;
        this.ratio = ratio();
    }

    public double ratio() {
        return (double) wage / quality;
    }

    @Override
    public int compareTo(Worker other) {
        return Double.compare(ratio, other.ratio);
    }

}
