package algorithm.bfs;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/19 下午3:47
 */
public class CatMouseGame {
    public static void main(String[] args) {
        CatMouseGame catMouseGame = new CatMouseGame();
        System.out.println(catMouseGame.catMouseGame(new int[][]{
                {2, 5},
                {3},
                {0, 4, 5},
                {1, 4, 5},
                {2, 3},
                {0, 2, 3}
        }));
    }

    /**
     * leetcode 913 极大极小化
     *
     * @param graph
     * @return
     */
    public int catMouseGame(int[][] graph) {
        int m = graph.length;
        int[][][] status = new int[2 * m][m][m];
        for (int i = 0; i < 2 * m; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(status[i][j], -1);
            }
        }
        return helper(graph, 0, 1, 2, status);
    }

    private int helper(int[][] graph, int step, int mouse, int cat, int[][][] status) {
        if (step >= 2 * graph.length) {
            return 0;
        }
        if (mouse == cat) { //cats win
            status[step][mouse][cat] = 2;
        }
        if (mouse == 0) { //mouse win
            status[step][mouse][cat] = 1;
        }
        if (status[step][mouse][cat] != -1) {
            return status[step][mouse][cat];
        }

        boolean mouseRun = step % 2 == 0;
        if (mouseRun) {
            boolean catWin = true;
            for (int nextPos : graph[mouse]) {
                int nextStatus = helper(graph, step + 1, nextPos, cat, status);
                if (nextStatus == 1) {
                    return status[step][cat][mouse] = 1;
                } else if (nextStatus != 2) {
                    catWin = false;
                }
            }
            if (catWin) {
                return status[step][cat][mouse] = 2;
            } else {
                return status[step][cat][mouse] = 0;
            }
        } else {
            boolean mouseWin = true;
            for (int nextPos : graph[cat]) {
                if (nextPos == 0) {
                    continue;
                }
                int nextStatus = helper(graph, step + 1, mouse, nextPos, status);
                if (nextStatus == 2) {
                    return status[step][mouse][mouse] = 2;
                } else if (nextStatus != 1) {
                    mouseWin = false;
                }
            }
            if (mouseWin) {
                return status[step][mouse][mouse] = 1;
            } else {
                return status[step][mouse][mouse] = 0;
            }
        }
    }
}
