package algorithm.bfs;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/7/2 下午3:45
 */
public class CountBattleShips {
    public static void main(String[] args) {
        CountBattleShips countBattleShips = new CountBattleShips();
        System.out.println(countBattleShips.countBattleShips(new char[][]{
                {'X', '.', '.', 'X'},
                {'X', '.', '.', 'X'},
                {'X', '.', '.', 'X'},
        }));
    }

    private static int[][] DIRS = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};


    public int countBattleShips(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int count = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && board[i][j] == 'X') {
                    bfs(board, visited, i, j, m, n);
                    ++count;
                }
            }
        }
        return count;
    }

    private void bfs(char[][] board, boolean[][] visited, int i, int j, int m, int n) {
        visited[i][j] = true;
        for (int[] dirs : DIRS) {
            int newl = i + dirs[0], newr = j + dirs[1];
            if (newl >= 0 && newl < m && newr >= 0 && newr < n && board[newl][newr] == 'X' && !visited[newl][newr]) {
                bfs(board, visited, newl, newr, m, n);
            }
        }
    }
}
