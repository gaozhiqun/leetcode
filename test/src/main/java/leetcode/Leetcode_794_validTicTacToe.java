package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/1/17 上午10:53
 */
public class Leetcode_794_validTicTacToe {
    public static void main(String[] args) {
        Leetcode_794_validTicTacToe l = new Leetcode_794_validTicTacToe();
    }

    public boolean validTicTacToe(String[] board) {
        int xCount = 0, oCount = 0;
        for (String row : board) {
            for (char c : row.toCharArray()) {
                xCount = (c == 'X') ? (xCount + 1) : xCount;
                oCount = (c == 'O') ? (oCount + 1) : oCount;
            }
        }
        return !((oCount != xCount && oCount != xCount - 1) ||
                (oCount != xCount - 1 && win(board, 'X')) ||
                (oCount != xCount && win(board, 'O')));
    }

    public boolean win(String[] board, char p) {
        for (int i = 0; i < 3; ++i) {
            if ((p == board[0].charAt(i) && p == board[1].charAt(i) && p == board[2].charAt(i)) ||
                    (p == board[i].charAt(0) && p == board[i].charAt(1) && p == board[i].charAt(2))) {
                return true;
            }
        }
        return ((p == board[0].charAt(0) && p == board[1].charAt(1) && p == board[2].charAt(2)) ||
                (p == board[0].charAt(2) && p == board[1].charAt(1) && p == board[2].charAt(0)));
    }
}
