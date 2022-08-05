package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/2 下午8:52
 */
public class leetcode_329_longestIncreasingPath {
    public static void main(String[] args) {
        leetcode_329_longestIncreasingPath l = new leetcode_329_longestIncreasingPath();
        System.out.println(l.longestIncreasingPath(new int[][]{
                {9, 9, 4}, {6, 6, 8}, {2, 1, 1}
        }));
    }

    int[] v = new int[]{1, 0, -1, 0};
    int[] h = new int[]{0, 1, 0, -1};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int ans = 1;
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return matrix[o1[0]][o1[1]] - matrix[o2[0]][o2[1]];
            }
        });
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                queue.offer(new int[]{i, j});
            }
        }
        int[][] dp = new int[m][n];
        for (int[] r : dp) {
            Arrays.fill(r, 1);
        }
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newi = p[0] + v[i];
                int newj = p[1] + h[i];
                if (newi >= 0 && newi < m && newj >= 0 && newj < n
                        && matrix[p[0]][p[1]] > matrix[newi][newj]) {
                    dp[p[0]][p[1]] = Math.max(dp[p[0]][p[1]], dp[newi][newj] + 1);
                    ans = Math.max(ans, dp[p[0]][p[1]]);
                }
            }
        }
        return ans;

    }
}
