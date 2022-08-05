package leetcode;


import algorithm.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/5 下午2:42
 */
public class Leetcode_221_maxSquqre {

    public static void main(String[] args) {
        Leetcode_221_maxSquqre l = new Leetcode_221_maxSquqre();
        System.out.println(l.maximalSquare(new char[][]{
                {}
        }));
    }

    char[][] matrix;
    int m, n;

    public int maximalSquare(char[][] matrix) {
        int ans = 0;
        this.matrix = matrix;
        m = matrix.length;
        n = matrix[0].length;
        Queue<int[]> q = new LinkedList<>();
        int l = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                q.offer(new int[]{i, j});
            }
        }
        boolean[][] pre = null;
        while (!q.isEmpty()) {
            boolean[][] temp = new boolean[m][n];
            int size = q.size();
            ++l;
            for (int i = 0; i < size; i++) {
                int[] next = q.poll();
                if (isSqure(next[0], next[1], l, pre)) {
                    ans = l;
                    temp[next[0]][next[1]] = true;
                    q.offer(next);
                }
            }
            pre = temp;
        }
        return ans;
    }

    private boolean isSqure(int i, int j, int l, boolean[][] pre) {
        if (l == 1) {
            return matrix[i][j] == '1';
        }
        if (i < l - 1 || j < l - 1 || !pre[i - 1][j - 1]) {
            return false;
        }
        for (int r = 0; r < l; --r) {
            if (matrix[i - r][j] != '1' || matrix[i][j - r] != '1') {
                return false;
            }
        }
        return true;
    }

    public int maximalSquare2(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int[][] dp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        int maxSquare = maxSide * maxSide;
        return maxSquare;
    }

}