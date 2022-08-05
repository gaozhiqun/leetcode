package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/6 下午8:18
 */
public class Leetcode_374_375_guessGmae {
    public static void main(String[] args) {
        Leetcode_374_375_guessGmae l = new Leetcode_374_375_guessGmae();

    }


    public int getMoneyAmount(int n) {
        int[][] f = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j <= n; j++) {
                f[i][j] = j + f[i][j - 1];
                for (int k = i; k < j; k++) {
                    f[i][j] = Math.min(f[i][j], k + Math.max(f[i][k - 1], f[k + 1][j]));
                }
            }
        }
        return f[1][n];
    }


}
