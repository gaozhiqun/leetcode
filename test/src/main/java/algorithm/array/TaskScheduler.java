package algorithm.array;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/8/27 下午1:37
 */
public class TaskScheduler {
    public static void main(String[] args) {
        TaskScheduler taskScheduler = new TaskScheduler();
        System.out.println(taskScheduler.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
    }

    public int leastInterval(char[] tasks, int n) {
        int total = tasks.length;
        int result = 0;
        int[] counts = new int[26];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });
        for (char ch : tasks) {
            counts[ch - 'A']++;
        }
        for (int i = 0; i < 26; i++) {
            if (counts[i] > 0) {
                priorityQueue.offer(counts[i]);
            }
        }
        while (!priorityQueue.isEmpty()) {
            int cur = Math.min(n + 1, priorityQueue.size());
            for (int i = 0; i < cur; ++i) {
                int top = priorityQueue.poll() - 1;
                if (top > 0) {
                    priorityQueue.offer(top);
                }
            }
            result += priorityQueue.isEmpty() ? cur : (n + 1);
        }
        return result;
    }
}
