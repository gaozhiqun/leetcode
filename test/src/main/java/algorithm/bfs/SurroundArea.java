package algorithm.bfs;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/4/14 9:40 下午
 */
public class SurroundArea {
    public static void main(String[] args) {

    }

    public void surroundArea(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visit = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; i < n; j++) {
                if (!visit[i][j] && matrix[i][j] == 'O') {
                    Set<int[]> set = new HashSet<>();
                    boolean surround = bfs(i, j, matrix, visit, set);
                    if (surround) {
                        for (int[] point : set) {
                            matrix[point[0]][point[1]] = 'X';
                        }
                    }
                }
            }
        }
    }

    private boolean bfs(int i, int j, char[][] matrix, boolean[][] visit, Set<int[]> set) {
        if (i >= matrix.length || j >= matrix[0].length) {
            return false;
        }
        if (matrix[i][j] == 'X') {
            return true;
        }
        visit[i][j] = true;
        set.add(new int[]{i, j});
        return bfs(i - 1, j, matrix, visit, set)
                && bfs(i + 1, j, matrix, visit, set)
                && bfs(i, j - 1, matrix, visit, set)
                && bfs(i, j + 1, matrix, visit, set);
    }

}
