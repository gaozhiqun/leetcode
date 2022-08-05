package leetcode;


/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_36_isValidSudoku {

    public static void main(String[] args) {
        Leetcode_36_isValidSudoku l = new Leetcode_36_isValidSudoku();
        System.out.println(l.isValidSudoku(new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        }));
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
