package leetcode;


import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_37_solveSudoku {

    public static void main(String[] args) {
        Leetcode_37_solveSudoku l = new Leetcode_37_solveSudoku();
        char[][] chars = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        l.solveSudoku(chars);
        System.out.println(Arrays.toString(chars));
    }

    public void solveSudoku(char[][] board) {
        boolean[][] verticals = new boolean[9][9];
        boolean[][] horizontals = new boolean[9][9];
        boolean[][] digones = new boolean[9][9];
        int m = board.length, n = board[0].length;
        LinkedList<int[]> todoList = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int k = getDigNum(i, j);
                char ch = board[i][j];
                if (ch == '.') {
                    todoList.addLast(new int[]{i, j});
                    continue;
                }
                int num = ch - '0' - 1;
                verticals[i][num] = true;
                horizontals[j][num] = true;
                digones[k][num] = true;
            }
        }
        bfs(board, todoList, verticals, horizontals, digones);
    }

    private boolean bfs(char[][] board, LinkedList<int[]> todoList,
                        boolean[][] vertical, boolean[][] horizontal, boolean[][] dignals) {
        if (todoList.isEmpty()) {
            return true;
        }
        int[] next = todoList.pollFirst();
        int i = next[0], j = next[1], k = getDigNum(i, j);
        for (int n = 0; n < 9; n++) {
            if (!vertical[i][n] && !horizontal[j][n] && !dignals[k][n]) {
                board[i][j] = (char) ((n + 1) + '0');
                vertical[i][n] = true;
                horizontal[j][n] = true;
                dignals[k][n] = true;
                boolean done = bfs(board, todoList, vertical, horizontal, dignals);
                if (done) {
                    return true;
                }
                board[i][j] = '.';
                vertical[i][n] = false;
                horizontal[j][n] = false;
                dignals[k][n] = false;
            }
        }
        todoList.addFirst(new int[]{i, j});
        return false;
    }


    public boolean isValidSudoku(char[][] board) {
        boolean[][] verticals = new boolean[9][9];
        boolean[][] horizontals = new boolean[9][9];
        boolean[][] digones = new boolean[9][9];
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int k = getDigNum(i, j);
                char ch = board[i][j];
                if (ch == '.') {
                    continue;
                }
                int num = ch - '0' - 1;
                if (verticals[i][num] || horizontals[j][num] || digones[k][num]) {
                    return false;
                }
                verticals[i][num] = true;
                horizontals[j][num] = true;
                digones[k][num] = true;
            }
        }
        return true;
    }

    private int getDigNum(int i, int j) {
        return 3 * (i / 3) + j / 3;
    }
}
