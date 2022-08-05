package leetcode;


import algorithm.tree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/14 上午10:48
 */
public class Leetcode_542_01_matrix {


    public static void main(String[] args) {
        Leetcode_542_01_matrix l = new Leetcode_542_01_matrix();

    }

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] dirs = new int[]{-1, 0, 1, 0, -1};
        int[][] ret = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    visited[i][j] = true;
                    ret[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int i = cur[0], j = cur[1];
                int ni = i + dirs[d];
                int nj = j + dirs[d + 1];
                if (ni >= 0 && nj >= 0 && ni < m && nj < n && !visited[ni][nj]) {
                    visited[ni][nj] = true;
                    ret[ni][nj] = ret[i][j] + 1;
                    q.offer(new int[]{ni, nj});
                }
            }
        }
        return ret;
    }


}