package leetcode;


import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/5 下午2:42
 */
public class Leetcode_130_surrondedArea {
    public static void main(String[] args) {
        Leetcode_130_surrondedArea l = new Leetcode_130_surrondedArea();
        char[][] board = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
        };
        l.solve(board);
        for (char[] row : board) {
            System.out.println(new String(row));
        }
    }

    /**
     * 输入：nums = [100,4,200,1,3,2]
     * O(n) 的算法
     * 0 <= nums.length <= 105
     * -109 <= nums[i] <= 109
     */

    int[] h = new int[]{-1, 1, 0, 0};
    int[] v = new int[]{0, 0, -1, 1};

    public void solve(char[][] board) {
        int m = board.length;
        if (m == 0) {
            return;
        }
        int n = board[0].length;
        if (n == 0) {
            return;
        }
        boolean[][] visited = new boolean[m][n];
        List<int[]> candidates = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            if (board[i][n - 1] == 'O' && !visited[i][n - 1]) {
                bfs(board, i, n - 1, visited, candidates);
            }
            if (board[i][0] == 'O' && !visited[i][0]) {
                bfs(board, i, 0, visited, candidates);
            }
        }

        for (int j = 1; j < m - 1; ++j) {
            if (board[m - 1][j] == 'O' && !visited[m - 1][j]) {
                bfs(board, m - 1, j, visited, candidates);
            }
            if (board[0][j] == 'O' && !visited[0][j]) {
                bfs(board, 0, j, visited, candidates);
            }
        }

        for (char[] row : board) {
            Arrays.fill(row, 'X');
        }
        for (int[] p : candidates) {
            board[p[0]][p[1]] = 'O';
        }

    }

    private void bfs(char[][] board, int i, int j, boolean[][] visited, List<int[]> candidates) {
        visited[i][j] = true;
        candidates.add(new int[]{i, j});
        for (int k = 0; k < 4; k++) {
            int newi = i + h[k];
            int newj = j + v[k];
            if (newi < 0 || newj < 0 || newi >= board.length || newj >= board[0].length
                    || board[newi][newj] == 'X' || visited[newi][newj]) {
                continue;
            }
            bfs(board, newi, newj, visited, candidates);
        }
    }


}
