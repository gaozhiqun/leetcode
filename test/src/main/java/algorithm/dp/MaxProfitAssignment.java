package algorithm.dp;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/8 下午5:31
 */
public class MaxProfitAssignment {
    public static void main(String[] args) {

    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] workers) {
        int[][] jobs = new int[difficulty.length][2];
        for (int i = 0; i < difficulty.length; i++) {
            jobs[i] = new int[2];
            jobs[i][0] = difficulty[i];
            jobs[i][1] = difficulty[profit[i]];
        }
        Arrays.sort(jobs, (a, b) -> {
            return b[1] - a[1];
        });
        int result = 0;
        for (int worker : workers) {
            for (int[] job : jobs) {
                if (worker >= job[0]) {
                    result += job[1];
                    break;
                }
            }
        }
        return result;
    }
}
