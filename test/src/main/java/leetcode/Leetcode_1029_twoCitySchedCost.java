package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/4/6 下午3:33
 */
public class Leetcode_1029_twoCitySchedCost {
    public static void main(String[] args) {
        Leetcode_1029_twoCitySchedCost l = new Leetcode_1029_twoCitySchedCost();
        System.out.println(l.twoCitySchedCost(new int[][]{
                {10, 20}, {30, 200}, {400, 50}, {30, 20}
        }));
        System.out.println(l.twoCitySchedCost(new int[][]{
                {259, 770}, {448, 54}, {926, 667}, {184, 139}, {840, 118}, {577, 469}
        }));
        System.out.println(l.twoCitySchedCost(new int[][]{
                {515, 563}, {451, 713}, {537, 709}, {343, 819}, {855, 779}, {457, 60}, {650, 359}, {631, 42}
        }));
    }

    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o1[1] - (o2[0] - o2[1]);
            }
        });
        int ans = 0;
        int N = costs.length / 2;
        for (int i = 0; i < N; ++i) {
            ans += costs[i][0] + costs[i + N][1];
        }
        return ans;
    }


}
