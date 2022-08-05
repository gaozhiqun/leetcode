package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/1/27 下午2:48
 */
public class Leetcode_835_largestOverlap {
    public static void main(String[] args) {
        Leetcode_835_largestOverlap l = new Leetcode_835_largestOverlap();
        System.out.println(l.pushDominoes(".L.R...LR..L.."));
//        System.out.println(l.numMagicSquaresInside(new int[][]{
//                {4, 3, 8, 4}, {9, 5, 1, 9}, {2, 7, 6, 2}
//        }));
    }

    int M, N;

    public int largestOverlap(int[][] img1, int[][] img2) {
        int m = img1.length;
        int n = img1[0].length;

        int[] a = new int[m], b = new int[m];
        for (int i = 0; i < m; ++i) {
            a[i] = b[i] = 0;
            for (int j = 0; j < n; ++j) {
                if (img1[i][j] == 1) {
                    a[i] |= (1 << j);
                }
                if (img1[2][j] == 1) {
                    b[i] |= (1 << j);
                }
            }
        }
        int ret = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                ret = Math.max(ret, getCount(a, b, i, j));
            }
        }
        return ret;
    }

    private int getCount(int[] a, int[] b, int x, int y) {
        int ret = 0;
        for (int i = x; i < a.length; i++) {
            int k = a[i] >> y;
            ret += (Integer.bitCount(a[i - x] & k));
        }
        return ret;
    }

    public int numMagicSquaresInside(int[][] grid) {
        int M = grid.length, N = grid[0].length;
        int ret = 0;
        int[][] rowSums = new int[M + 1][N + 1];
        int[][] colSums = new int[M + 1][N + 1];
        int[][] digSums = new int[M + N - 2][Math.min(M, N) + 1];
        for (int i = 1; i <= M; ++i) {
            for (int j = 1; j <= N; ++j) {
                rowSums[i][j] = rowSums[i - 1][j] + grid[i - 1][j - 1];
                colSums[i][j] = colSums[i][j - 1] + grid[i - 1][j - 1];
                digSums[getDig(i, j, N)][i + j] = digSums[getDig(i, j, N)][i + j - 2] + grid[i - 1][j - 1];
            }
        }
        for (int i = 3; i <= M; ++i) {
            outter:
            for (int j = 3; j <= N; ++j) {
                for (int k = 0; k < 3; k++) {
                    if (colSums[i - k][j] - colSums[i - k][j - 3] != 15
                            || rowSums[i][j - k] - rowSums[i - 3][j - k] != 15) {
                        continue outter;
                    }
                }
                ++ret;
            }
        }
        return ret;
    }

    private int getDig(int i, int j, int M) {
        return M - i + j - 1;
    }

    /**
     * 爱丽丝的分数不超过 n 的概率是多少？
     *
     * @param n
     * @param k
     * @param maxPts
     * @return
     */
    public double new21Game(int n, int k, int maxPts) {
        if (k == 0) {
            return 1.0;
        }
        double[] dp = new double[k + maxPts];
        for (int i = k; i <= n && i < k + maxPts; i++) {
            dp[i] = 1.0;
        }
        dp[k - 1] = 1.0 * Math.min(n - k + 1, maxPts) / maxPts;
        for (int i = k - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] - (dp[i + maxPts + 1] - dp[i + 1]) / maxPts;
        }
        return dp[0];
    }

    /**
     * 输入：".L.R...LR..L.."
     * 输出："LL.RR.LLRRLL.."
     * ".L.RRRRLRRRL.."
     * "LL.RLLLLRLLL.."
     */
    public String pushDominoes(String S) {
        char[] A = S.toCharArray();
        int N = A.length;
        int[] forces = new int[N];

        // Populate forces going from left to right
        int force = 0;
        for (int i = 0; i < N; ++i) {
            if (A[i] == 'R') force = N;
            else if (A[i] == 'L') force = 0;
            else force = Math.max(force - 1, 0);
            forces[i] += force;
        }

        // Populate forces going from right to left
        force = 0;
        for (int i = N - 1; i >= 0; --i) {
            if (A[i] == 'L') force = N;
            else if (A[i] == 'R') force = 0;
            else force = Math.max(force - 1, 0);
            forces[i] -= force;
        }

        StringBuilder ans = new StringBuilder();
        for (int f : forces)
            ans.append(f > 0 ? 'R' : f < 0 ? 'L' : '.');
        return ans.toString();
    }
}
