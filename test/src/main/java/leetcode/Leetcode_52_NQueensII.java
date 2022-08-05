package leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_52_NQueensII {

    public static void main(String[] args) {
        Leetcode_52_NQueensII l = new Leetcode_52_NQueensII();
        System.out.println(l.totalNQueens(4));

    }


    boolean[] h, d, rd;


    public int totalNQueens(int n) {
        h = new boolean[n];
        d = new boolean[2 * n - 1];
        rd = new boolean[2 * n - 1];
        return bfs(0, n);
    }

    private int bfs(int i, int N) {
        if (i == N) {
            return 1;
        }
        int ans = 0;
        for (int j = 0; j < N; ++j) {
            int k = i + j, l = N - 1 - i + j;
            if (!h[j] && !d[k] && !rd[l]) {
                h[j] = true;
                d[k] = true;
                rd[l] = true;
                ans += bfs(i + 1, N);
                h[j] = false;
                d[k] = false;
                rd[l] = false;
            }
        }
        return ans;
    }
}
