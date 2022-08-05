package leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_79_wordSearch {

    public static void main(String[] args) {
        Leetcode_79_wordSearch l = new Leetcode_79_wordSearch();
        System.out.println(l.exist(new char[][]{
                {'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}
        }, "SEE"));
        System.out.println(l.exist(new char[][]{
                {'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}
        }, "ABCCED"));
        System.out.println(l.exist(new char[][]{
                {'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}
        }, "ABCB"));

    }

    private static int[] H = {-1, 0, 1, 0};
    private static int[] V = {0, 1, 0, -1};

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        if (m == 0) {
            return false;
        }
        int n = board[0].length;
        if (n == 0) {
            return false;
        }
        boolean[][] used = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                boolean ans = bfs(board, used, i, j, word, 0);
                if (ans) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean bfs(char[][] board, boolean[][] used, int i, int j, String word, int cur) {
        if (word.charAt(cur) != board[i][j]) {
            return false;
        }
        if (cur == word.length() - 1) {
            return true;
        }
        used[i][j] = true;
        for (int d = 0; d < 4; ++d) {
            int ni = i + H[d], nj = j + V[d];
            if (ni >= 0 && nj >= 0 && ni < board.length && nj < board[0].length && !used[ni][nj]) {
                boolean next = bfs(board, used, ni, nj, word, cur + 1);
                if (next) {
                    return true;
                }
            }
        }
        used[i][j] = false;
        return false;
    }


}
