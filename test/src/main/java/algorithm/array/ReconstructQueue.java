package algorithm.array;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/7/2 上午10:53
 */
public class ReconstructQueue {
    public static void main(String[] args) {
        ReconstructQueue reconstructQueue = new ReconstructQueue();
        int[][] result = reconstructQueue.reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});
        int[][] result2 = reconstructQueue.reconstructQueue2(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});
        /**
         *{5,0},{7,0},{6,1},{5,2},{4,4},{7,1}
         */
        System.out.println(result);
        System.out.println(result2);
    }

    public int[][] reconstructQueue2(int[][] people) {
        int[][] result = new int[people.length][2];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? Integer.compare(o2[0], o1[0]) : Integer.compare(o1[1], o2[1]);
            }
        });
        for (int[] p : people) {
            priorityQueue.offer(p);
        }
        List<int[]> list = new LinkedList<>();
        while (!priorityQueue.isEmpty()) {
            int[] cur = priorityQueue.poll();
            list.add(cur[1], cur);
        }
        return list.toArray(new int[list.size()][]);
    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] person1, int[] person2) {
                if (person1[0] != person2[0]) {
                    return person2[0] - person1[0];
                } else {
                    return person1[1] - person2[1];
                }
            }
        });
        List<int[]> ans = new ArrayList<int[]>();
        for (int[] person : people) {
            ans.add(person[1], person);
        }
        return ans.toArray(new int[ans.size()][]);
    }
}

