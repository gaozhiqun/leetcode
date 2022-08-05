package leetcode;

import algorithm.tree.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/3/29 下午4:31
 */
public class Leetcode_979_uniquePathsIII {
    public static void main(String[] args) {
        Leetcode_979_uniquePathsIII l = new Leetcode_979_uniquePathsIII();
        System.out.println(l.uniquePathsIII(new int[][]{
                {1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}
        }));

    }

    Map<Integer, Integer> memo;
    int si, sj, ei, ej;
    int mask, M, N;
    int[] DIRS = new int[]{1, 0, -1, 0, 1};

    public int uniquePathsIII(int[][] grid) {
        M = grid.length;
        N = grid[0].length;
        mask = 1 << (M * N) - 1;
        memo = new HashMap<>();
        memo.put(mask, 1);
        int initStatus = 0;
        for (int i = 0; i < M; ++i) {
            for (int j = 0; j < N; ++j) {
                if (grid[i][j] == -1) {
                    initStatus |= 1 << (i * M + j);
                } else if (grid[i][j] == 1) {
                    si = i;
                    sj = j;
                } else if (grid[i][j] == 2) {
                    ei = i;
                    ej = j;
                }
            }
        }
        return bfs(initStatus, si, sj);
    }

    private int bfs(int status, int i, int j) {
        if (i < 0 || j < 0 || i >= M || j >= N) {
            return 0;
        }
        status |= 1 << (i * M + j);
        if (i == ei && j == ej) {
            if (status == mask) {
                return 1;
            } else {
                return 0;
            }
        }
        if (memo.containsKey(status)) {
            return memo.get(status);
        }
        int ret = 0;
        for (int d = 0; d < 4; ++d) {
            int ni = i + DIRS[d], nj = j + DIRS[d + 1];
            if ((status & (1 << ni * M + nj)) == 0) {
                ret += bfs(status, ni, nj);
            }
        }
        memo.put(status, ret);
        return ret;
    }



}
