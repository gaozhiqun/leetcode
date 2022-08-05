package algorithm.bfs;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/9/1 下午8:05
 */
public class CutOffTree {
    public static void main(String[] args) {
        CutOffTree cutOffTree = new CutOffTree();
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1, 2, 3));
        list.add(Arrays.asList(0, 0, 4));
        list.add(Arrays.asList(7, 6, 5));
        System.out.println(cutOffTree.cutOffTree(list));
    }

    private static int[][] DIRS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int cutOffTree(List<List<Integer>> forest) {
        int m = forest.size();
        int n = forest.get(0).size();
        int result = 0;
        int[][] matrix = new int[m][n];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return forest.get(o1[0]).get(o1[1]) - forest.get(o2[0]).get(o2[1]);
            }
        });
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix[i][j] = forest.get(i).get(j);
                if (matrix[i][j] > 1) {
                    priorityQueue.offer(new int[]{i, j});
                }
            }
        }
        int[] cur = new int[]{0, 0};
        while (!priorityQueue.isEmpty()) {
            int[] next = priorityQueue.poll();
            boolean[][] visited = new boolean[m][n];
            int cnt = moveToNextTree(cur[0], cur[1], next[0], next[1], matrix, visited);
            if (cnt < 0) {
                return -1;
            }
            cur = next;
            result += cnt;
        }
        return result;
    }

    private int moveToNextTree(int i, int j, int x, int y, int[][] matrix, boolean[][] visited) {
        if (i == x && j == y) {
            return 0;
        }
        if (i < 0 || j < 0 ||
                i >= matrix.length || j >= matrix[0].length
                || matrix[i][j] < 1 || visited[i][j]) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        visited[i][j] = true;
        for (int[] dir : DIRS) {
            int step = moveToNextTree(i + dir[0], j + dir[1], x, y, matrix, visited);
            if (step > -1) {
                min = Math.min(min, step + 1);
            }
        }
        visited[i][j] = false;
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
