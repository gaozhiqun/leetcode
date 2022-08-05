package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/4/8 上午11:17
 */
public class Leetcode_1042_gardenNoAdj {
    public static void main(String[] args) {
        Leetcode_1042_gardenNoAdj l = new Leetcode_1042_gardenNoAdj();
        System.out.println(l.gardenNoAdj(6, new int[][]{{6, 4}, {6, 1}, {3, 1}, {4, 5}, {2, 1}, {5, 6}, {5, 2}}));
        System.out.println(l.gardenNoAdj(4, new int[][]{{1, 2}, {2, 3}, {3, 1}}));
    }

    public int[] gardenNoAdj(int n, int[][] paths) {
        int[] ret = new int[n];
        Map<Integer, Set<Integer>> colorMap = new HashMap<>();
        Map<Integer, List<Integer>> nbsMap = new HashMap<>();
        for (int[] path : paths) {
            int i = path[0], j = path[1];
            nbsMap.computeIfAbsent(i, f -> new ArrayList<>()).add(j);
            nbsMap.computeIfAbsent(j, f -> new ArrayList<>()).add(i);
        }
        for (int i = 1; i <= n; ++i) {
            for (int c = 1; c <= 4; ++c) {
                Set<Integer> banishSet = colorMap.computeIfAbsent(c, f -> new HashSet<>());
                if (banishSet.contains(i)) {
                    continue;
                } else {
                    ret[i - 1] = c;
                    List<Integer> nbs = nbsMap.computeIfAbsent(i, f -> new ArrayList<>());
                    banishSet.addAll(nbs);
                    break;
                }
            }
        }
        return ret;
    }

}
