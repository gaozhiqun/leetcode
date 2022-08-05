package algorithm.huawei;

import java.util.Scanner;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/23 下午9:49
 */
public class MatMulti {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int k = in.nextInt();
        int[][] a = new int[m][n];
        int[][] b = new int[n][k];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                a[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < k; ++j) {
                b[i][j] = in.nextInt();
            }
        }
        int[][] ret = matMulti(m, n, k, a, b);
        for (int[] row : ret) {
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
    }


    public static int[][] matMulti(int m, int n, int k, int[][] a, int[][] b) {

        int[][] ret = new int[m][k];
        // a的第i行
        for (int i = 0; i < m; ++i) {
            // b的第j列
            for (int j = 0; j < k; ++j) {
                for (int t = 0; t < n; ++t) {
                    ret[i][j] += a[i][t] * b[t][j];
                }
            }
        }
        return ret;
    }
}
