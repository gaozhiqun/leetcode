package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_807_maxIncreaseKeepingSkyline {

    public static void main(String[] args) {
        Leetcode_807_maxIncreaseKeepingSkyline l = new Leetcode_807_maxIncreaseKeepingSkyline();
        System.out.println(l.maxIncreaseKeepingSkyline(new int[][]{
                {3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}
        }));
    }

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        int[] maxRow = new int[M];
        int[] maxCol = new int[N];
        for (int i = 0; i < M; ++i) {
            for (int j = 0; j < N; ++j) {
                maxRow[i] = Math.max(maxRow[i], grid[i][j]);
                maxCol[j] = Math.max(maxCol[j], grid[i][j]);
            }
        }
        int ret = 0;
        for (int i = 0; i < M; ++i) {
            for (int j = 0; j < N; ++j) {
                ret += Math.min(maxRow[i], maxCol[j]) - grid[i][j];
            }
        }
        return ret;
    }
}