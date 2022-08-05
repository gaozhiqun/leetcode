package backtrack;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/26 下午2:20
 */
public class UniquePathIII {
    public static void main(String[] args) {
        UniquePathIII uniquePathIII = new UniquePathIII();
        System.out.println(uniquePathIII.uniquePathIII(new int[][]{
                {1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}
        }));
    }

    int ans;
    int[] start, end;
    int MAXMOVE;
    int M, N;
    int[][] DIRS = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0},};
    int[][] grid;

    /**
     * 1: start
     * 2: end:
     * 0: path
     * -1: obstacle
     *
     * @param gird
     * @return
     */
    public int uniquePathIII(int[][] gird) {
        MAXMOVE = 0;
        M = gird.length;
        N = gird[0].length;
        this.grid = gird;
        ans = 0;
        for (int i = 0; i < gird.length; i++) {
            for (int j = 0; j < gird[0].length; ++j) {
                if (gird[i][j] == 0) {
                    ++MAXMOVE;
                } else if (gird[i][j] == 1) {
                    start = new int[]{i, j};
                } else if (gird[i][j] == 2) {
                    end = new int[]{i, j};
                }
            }
        }
        Set<Integer> visited = new HashSet<>();
        bfs(start[0], start[1], visited, 0);
        return ans;
    }

    public void bfs(int i, int j, Set<Integer> visited, int move) {
        visited.add(i * N + j);
        for (int[] dir : DIRS) {
            int nextI = i + dir[0];
            int nextJ = j + dir[1];
            if (nextI >= 0 && nextI < M && nextJ >= 0 && nextJ < N) {
                if (grid[nextI][nextJ] == 0 && !visited.contains(nextI * N + nextJ)) {
                    bfs(nextI, nextJ, visited, move + 1);
                }
                if (grid[nextI][nextJ] == 2 && move == MAXMOVE) {
                    ++ans;
                }
            }
        }
        visited.remove(i * N + j);
    }
}
