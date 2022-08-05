package leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_51_NQueens {

    public static void main(String[] args) {
        Leetcode_51_NQueens l = new Leetcode_51_NQueens();
        System.out.println(l.solveNQueens(4));

    }


    boolean[] h, d, rd;
    char[][] board;
    List<List<String>> ans;

    public List<List<String>> solveNQueens(int n) {
        h = new boolean[n];
        d = new boolean[2 * n - 1];
        rd = new boolean[2 * n - 1];
        board = new char[n][n];
        for (char[] s : board) {
            Arrays.fill(s, '.');
        }
        ans = new ArrayList<>();
        bfs(0, n);
        return ans;
    }

    private void bfs(int i, int N) {
        if (i == N) {
            List<String> list = new ArrayList<>();
            for (char[] row : board) {
                list.add(new String(row));
            }
            ans.add(list);
            return;
        }
        for (int j = 0; j < N; ++j) {
            int k = i + j, l = N - 1 - i + j;
            if (!h[j] && !d[k] && !rd[l]) {
                board[i][j] = 'Q';
                h[j] = true;
                d[k] = true;
                rd[l] = true;
                bfs(i + 1, N);
                board[i][j] = '.';
                h[j] = false;
                d[k] = false;
                rd[l] = false;
            }
        }
    }
}
