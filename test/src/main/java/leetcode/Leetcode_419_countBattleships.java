package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/13 下午2:55
 */
public class Leetcode_419_countBattleships {
    public static void main(String[] args) {
        Leetcode_419_countBattleships l = new Leetcode_419_countBattleships();
        System.out.println(l.countBattleships(new char[][]{
                {'X', '.', '.', 'X'}, {'.', '.', '.', 'X'}, {'.', '.', '.', 'X'}
        }));
    }

    int m, n;
    char[][] board;

    public int countBattleships(char[][] board) {
        this.board = board;
        m = board.length;
        n = board[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; ++j) {
                if (this.board[i][j] == 'X') {
                    ++ans;
                    bfs(i, j);
                }
            }
        }
        return ans;
    }

    private void bfs(int i, int j) {
        board[i][j] = '.';
        int[] dirs = new int[]{-1, 0, 1, 0, -1};
        for (int d = 0; d < 4; d++) {
            int nx = i + dirs[d];
            int ny = j + dirs[d + 1];
            if (nx >= 0 && ny >= 0 && nx < m && ny < n && board[nx][ny] == 'X') {
                bfs(nx, ny);
            }
        }
    }


}
