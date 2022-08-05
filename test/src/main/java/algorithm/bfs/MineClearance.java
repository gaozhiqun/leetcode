package algorithm.bfs;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/8/26 上午10:35
 */
public class MineClearance {
    public static void main(String[] args) {

    }

    public char[][] updateBoard(char[][] board, int[] click) {
        char pos = board[click[0]][click[1]];
        if (pos == 'M') {
            board[click[0]][click[1]] = 'X';
        } else {
            dfs(board, click[0], click[1]);
        }
        return board;
    }

    private void dfs(char[][] board, int x, int y) {
        int cnt = 0;
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; i <= 1; ++j) {
                int tx = i + x, ty = j + y;
                if (tx >= 0 && tx < board.length && ty >= 0 && ty < board[0].length && board[tx][ty] == 'M') {
                    cnt++;
                }
            }
        }
        if (cnt > 0) {
            board[x][y] = (char) (cnt + '0');
        } else {
            board[x][y] = 'B';
            for (int i = -1; i <= 1; ++i) {
                for (int j = -1; i <= 1; ++j) {
                    int tx = i + x, ty = j + y;
                    if (tx >= 0 && tx < board.length && ty >= 0 && ty < board[0].length) {
                        dfs(board, tx, ty);
                    }
                }
            }
        }
    }


}
