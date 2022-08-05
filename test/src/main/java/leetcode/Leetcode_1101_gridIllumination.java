package leetcode;

import algorithm.tree.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/3/16 下午3:17
 */
public class Leetcode_1101_gridIllumination {
    public static void main(String[] args) {
        Leetcode_1101_gridIllumination l = new Leetcode_1101_gridIllumination();
        System.out.println(l.gridIllumination(5, new int[][]{{0, 0}, {4, 4}}, new int[][]{{1, 1}, {1, 1}}));
        System.out.println(l.gridIllumination(5, new int[][]{{0, 0}, {4, 4}}, new int[][]{{1, 1}, {1, 0}}));
        System.out.println(l.gridIllumination(5, new int[][]{{0, 0}, {0, 4}}, new int[][]{{0, 4}, {0, 1}, {1, 4}}));
    }

    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        Set<Long> lights = new HashSet<>();
        Map<Integer, Integer> colMap = new HashMap<>();
        Map<Integer, Integer> rowMap = new HashMap<>();
        Map<Integer, Integer> diagMap = new HashMap<>();
        Map<Integer, Integer> rDiagMap = new HashMap<>();
        for (int[] lamp : lamps) {
            int i = lamp[0], j = lamp[1];
            colMap.put(i, colMap.getOrDefault(i, 0) + 1);
            rowMap.put(j, rowMap.getOrDefault(j, 0) + 1);
            diagMap.put(i + j, diagMap.getOrDefault(i + j, 0) + 1);
            rDiagMap.put(i - j, rDiagMap.getOrDefault(i - j, 0) + 1);
            lights.add(((long) i) << 32 + j);
        }
        int[] ret = new int[queries.length];
        for (int q = 0; q < queries.length; ++q) {
            int i = queries[q][0], j = queries[q][1];
            if (colMap.getOrDefault(i, 0) > 0
                    || rowMap.getOrDefault(j, 0) > 0
                    || diagMap.getOrDefault(i + j, 0) > 0
                    || rDiagMap.getOrDefault(i - j, 0) > 0) {
                ret[q] = 1;
            }
            for (int r = -1; r < 2; ++r) {
                for (int c = -1; c < 2; ++c) {
                    int ni = r + i, nj = c + j;
                    if (ni < 0 || nj < 0 || ni > n - 1 || nj > n - 1) {
                        continue;
                    }
                    if (lights.contains(((long) ni) << 32 + nj)) {
                        colMap.put(ni, colMap.getOrDefault(ni, 0) - 1);
                        rowMap.put(nj, rowMap.getOrDefault(nj, 0) - 1);
                        diagMap.put(ni + nj, diagMap.getOrDefault(ni + nj, 0) - 1);
                        rDiagMap.put(ni - nj, rDiagMap.getOrDefault(ni - nj, 0) - 1);
                        lights.remove(((long) ni) << 32 + nj);
                    }
                }
            }
        }
        return ret;
    }


}
