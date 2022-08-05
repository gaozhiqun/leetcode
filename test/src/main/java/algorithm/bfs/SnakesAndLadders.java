package algorithm.bfs;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/19 下午2:04
 */
public class SnakesAndLadders {
    public static void main(String[] args) {

    }

    public int snakesAndLadders(int[][] boards) {
        int n = boards.length;
        /**
         * (n-1,0) -> n^2的方格，游戏结束
         * [cur+1, min(cur+6,n^2)]
         */
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });
        priorityQueue.offer(new int[]{0, 0});
        Map<Integer, Integer> map = new HashMap<>();
        while (!priorityQueue.isEmpty()) {
            int[] cur = priorityQueue.poll();
            int[] pos = getPos(cur[0], n);
            if (pos[0] == n - 1 && pos[1] == n - 1) {
                return cur[2];
            }
            if (boards[pos[0]][pos[1]] != -1 && cur[0] < map.getOrDefault(boards[pos[0]][pos[1]], Integer.MAX_VALUE) - 1) {
                priorityQueue.offer(new int[]{boards[pos[0]][pos[1]], cur[1] + 1});
            }
            for (int i = 1; i <= 6; i++) {
                if (cur[0] + i > n * 2) {
                    break;
                }
                if (cur[1] + 1 < map.getOrDefault(cur[0] + i, Integer.MAX_VALUE)) {
                    priorityQueue.offer(new int[]{cur[0] + i, cur[1] + 1});
                }
            }
        }
        return -1;
    }

    public int[] getPos(int x, int n) {
        return new int[]{n - x / n - 1, x % n};

    }
}
