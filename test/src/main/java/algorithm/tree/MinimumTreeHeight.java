package algorithm.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/6/1 2:53 下午
 */
public class MinimumTreeHeight {
    public static void main(String[] args) {
        MinimumTreeHeight minimumTreeHeight = new MinimumTreeHeight();
        System.out.println(minimumTreeHeight.findMinHeightTrees(6, new int[][]{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}}));
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[][] newEdges = new int[n][n];
        for (int[] point : edges) {
            newEdges[point[0]][point[1]] = 1;
            newEdges[point[1]][point[0]] = 1;
        }
        List<Integer> result = new ArrayList<>();
        Set<Integer> temp = new HashSet<>();
        for (int i = 0; i < n; i++) {
            dfs(i, result, temp, newEdges);
        }
        return result;
    }

    private void dfs(int cur, List<Integer> result, Set<Integer> temp, int[][] edges) {
        temp.add(cur);
        if (temp.size() > result.size()) {
            result.clear();
            result.addAll(temp);
        }
        for (int i = 0; i < edges[0].length; i++) {
            if (edges[cur][i] == 1 && !temp.contains(i)) {
                dfs(i, result, temp, edges);
            }
        }
        temp.remove(cur);
    }
}
