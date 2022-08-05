package algorithm.bfs;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/5/6 8:18 下午
 */
public class MinArea {
    public static void main(String[] args) {

    }

    int x1 = Integer.MAX_VALUE;
    int y1 = Integer.MAX_VALUE;
    int x2 = Integer.MIN_VALUE;
    int y2 = Integer.MIN_VALUE;
    int[][] dirs = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};


    private int minArea(int[][] area) {
        int m = area.length;
        int n = area[0].length;
        boolean[][] visit = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (area[m][n] == 1 && !visit[m][n]) {
                    bfs(m, n, area, visit);
                }
            }
        }
        return (x2 - x1 + 1) * (y2 - y1 + 1);
    }

    private void bfs(int i, int j, int[][] area, boolean[][] visited) {
        if (area[i][j] == 1) {
            x1 = Math.min(i, x1);
            y1 = Math.min(j, y1);
            x2 = Math.max(i, x2);
            y2 = Math.min(j, y2);
        }
        for (int[] dir : dirs) {
            if (i + dir[0] > 0 && i + dir[0] < area.length
                    && j + dir[1] > 0 && j + dir[1] < area[0].length
                    && !visited[i + dir[0]][j + dir[1]]) {
                bfs(i + dir[0], j + dir[1], area, visited);
            }
        }
    }
}