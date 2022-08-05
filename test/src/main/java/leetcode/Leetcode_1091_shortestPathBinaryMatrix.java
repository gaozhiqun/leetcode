package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/26 下午10:46
 */
public class Leetcode_1091_shortestPathBinaryMatrix {
    public static void main(String[] args) {
        Leetcode_1091_shortestPathBinaryMatrix l = new Leetcode_1091_shortestPathBinaryMatrix();
        System.out.println(l.shortestPathBinaryMatrix(new int[][]{
                {0, 0, 0}, {1, 1, 0}, {1, 1, 0}
        }));
    }

    int[][] dir = {{1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        LinkedList<int[]> que = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        que.addLast(new int[]{0, 0});
        int move = 0;
        while (!que.isEmpty()) {
            ++move;
            int size = que.size();
            while (size-- > 0) {
                int[] p = que.poll();
                if (p[0] == m - 1 && p[1] == n - 1) {
                    return move;
                }
                int i = p[0], j = p[1];
                for (int[] d : dir) {
                    int x1 = i + d[0];
                    int y1 = j + d[1];
                    if (x1 < 0 || x1 >= m || y1 < 0 || y1 >= m || grid[x1][y1] == 1) {
                        continue;
                    }
                    que.add(new int[]{x1, y1});
                    grid[x1][y1] = 1;
                }

            }
        }
        return -1;
    }


}
