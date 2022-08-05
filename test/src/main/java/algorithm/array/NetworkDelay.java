package algorithm.array;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/9/10 下午7:23
 */
public class NetworkDelay {
    public static void main(String[] args) {

    }

    public int networkDelay(int[][] times, int n, int k) {
        int[] minDistance = new int[n];
        int[][] distance = new int[n][n];
        for (int[] dis : distance) {
            Arrays.fill(dis, Integer.MAX_VALUE);
        }
        for (int[] time : times) {
            distance[time[0]][time[1]] = time[2];
        }
        Arrays.fill(minDistance, Integer.MAX_VALUE);
        minDistance[k - 1] = 0;
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; ++i) {
            int x = -1;
            for (int y = 0; y < n; ++y) {
                if (!used[y] && (x == -1) || minDistance[y] < minDistance[x]) {
                    x = y;
                }
            }
            used[x] = true;
            for (int y = 0; y < n; ++y) {
                minDistance[y] = Math.min(minDistance[y], minDistance[x] + distance[x][y]);
            }
        }
        int ans = Arrays.stream(minDistance).max().getAsInt();
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

}
