package algorithm.math;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/7/2 上午11:28
 */
public class TrapRainWater {
    public static void main(String[] args) {

    }

    int result = 0;


    /**
     * 从最低洼处开始BFS，然后把周边遇到的比它高的低洼处放进去
     *
     * @param heightMap
     * @return
     */

    public int trapRainWater(int[][] heightMap) {
        int min = Integer.MAX_VALUE;
        int m = heightMap.length;
        int n = heightMap[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {


            }
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return 0;
            }
        });
        return -1;

    }

    private int bfsAndSet(int x, int y, int height) {

        return 0;
    }


}
